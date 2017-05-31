package com.yt.wia.commons;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;

import android.app.Activity;
import android.app.AlertDialog.Builder;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Environment;
import android.os.Handler;
import android.os.Message;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.google.gson.Gson;
import com.yt.wia.application.R;
import com.yt.wia.config.Strings;
import com.yt.wia.config.SystemSettings;
import com.yt.wia.config.UpdateBean;
import com.yt.wia.view.MaterialDialog;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

/**
 * 
 */

public class UpdateManager {
	private static final int DOWNLOAD = 1;
	private static final int DOWNLOAD_FINISH = 2;
	private static final int ISUPDATE=3;
	private String mSavePath;
	private int progress;
	private boolean cancelUpdate = false;
	private Activity mContext;
	private ProgressBar mProgress;
	private Dialog mDownloadDialog;
	private String getApkUrl;
	private MaterialDialog mMaterialDialog;
	private String saveApkPath;
	private boolean forciblyUpdate=false;
	private TextView textprocess;

	public UpdateManager(Activity context) {
		mContext = context;
		mMaterialDialog = new MaterialDialog(mContext);
	}

	private Handler mHandler = new Handler() {
		public void handleMessage(Message msg) {
			switch (msg.what) {
			case DOWNLOAD:
				mProgress.setProgress(progress);
				textprocess.setText(progress+"%");
				break;
			case DOWNLOAD_FINISH:
				installApk();
				break;
			case ISUPDATE:
				showNoticeDialog();
				break;
			default:
				break;
			}
		};
	};

	public String getVersionCode() {
		String version="";
		PackageManager manager=mContext.getPackageManager();
		try {
			PackageInfo info=manager.getPackageInfo(mContext.getPackageName(),0);
			version=info.versionCode+"";//获取当前版本号

			return version;
		} catch (PackageManager.NameNotFoundException e) {
			e.printStackTrace();
		}
		return "0";
	}

	/**
	 * 检查是否有更新
	 */
	public void checkUpdate() {
		OkHttpClient client = new OkHttpClient();
		RequestBody body = new FormBody.Builder().
				add("version", getVersionCode()).
				build();
		String requesturl= SystemSettings.REQUEST_URL;
		Request request = new Request.Builder().url(requesturl+"terminal/checkUpdate?").post(body).build();
		Call call = client.newCall(request);
		call.enqueue(new Callback() {
			@Override
			public void onFailure(Call call, IOException e) {
				ThreadToast.backThreadLongToast(mContext.getApplicationContext(), Strings.soft_newest);
			}

			@Override
			public void onResponse(Call call, Response response) throws IOException {
				String r = response.body().string();
				if (response.isSuccessful()) {
					Gson gson=new Gson();
					UpdateBean uBean=gson.fromJson(r,UpdateBean.class);
					if(uBean.getFileUrl().contains("http")){
						getApkUrl=uBean.getFileUrl();
					}else{
						getApkUrl="http://192.168.1.103:89"+uBean.getFileUrl();
					}
					forciblyUpdate=uBean.isForciblyUpdate();
					saveApkPath=new SimpleDateFormat("yyyy-MM-dd").format(new Date()) + "zhjy.apk";
					mHandler.sendEmptyMessage(ISUPDATE);
				}
			}
		});
	}

	/**
	 * 
	 */
	private void showNoticeDialog() {
		mMaterialDialog.setTitle(R.string.soft_update_title)
				.setMessage(R.string.soft_update_info)
				.setCanceledOnTouchOutside(false)
				.setPositiveButton(R.string.soft_update_updatebtn, new View.OnClickListener() {
					@Override public void onClick(View v) {
						mMaterialDialog.dismiss();
						showDownloadDialog();//立即更新
					}
				})
				.setNegativeButton(R.string.soft_update_later,
						new View.OnClickListener() {
							@Override public void onClick(View v) {
								if(forciblyUpdate){
									System.exit(0);
								}else{
									mMaterialDialog.dismiss();//暂不更新
								}
							}
						})
					.setCanceledOnTouchOutside(false)
				.show();
	}

	/**
	 */
	private void showDownloadDialog() {
		Builder builder = new Builder(mContext);
		builder.setTitle(R.string.soft_updating)
		.setCancelable(false);
		final LayoutInflater inflater = LayoutInflater.from(mContext);
		View v = inflater.inflate(R.layout.softupdate_progress, null);
		mProgress = (ProgressBar) v.findViewById(R.id.update_progress);
		textprocess = (TextView) v.findViewById(R.id.textprocess);
		mProgress.setProgress(0);
		builder.setView(v);
		builder.setNegativeButton(R.string.soft_update_cancel,
				new OnClickListener() {
					@Override
					public void onClick(DialogInterface dialog, int which) {
						dialog.dismiss();
						cancelUpdate = true;
					}
				});
		mDownloadDialog = builder.create();
		mDownloadDialog.show();
		downloadApk();

	}

	/**
	 */
	private void downloadApk() {
		new downloadApkThread().start();
	}

	/**
	 * 
	 */
	private class downloadApkThread extends Thread {
		@Override
		public void run() {
			try {
				if (Environment.getExternalStorageState().equals(
						Environment.MEDIA_MOUNTED)) {
					String sdpath = Environment.getExternalStorageDirectory().getPath() + "/";
					mSavePath = sdpath + "download";
					URL url = new URL(getApkUrl);
					HttpURLConnection conn = (HttpURLConnection) url
							.openConnection();
					conn.connect();
					int length = conn.getContentLength();
					InputStream is = conn.getInputStream();
					File file = new File(mSavePath);
					if (!file.exists()) {
						file.mkdir();
					}
					File apkFile = new File(mSavePath, "zhjy");
					FileOutputStream fos = new FileOutputStream(apkFile);
					int count = 0;
					byte buf[] = new byte[1024];
					do {
						int numread = is.read(buf);
						count += numread;
						progress = (int) (((float) count / length) * 100);
						mHandler.sendEmptyMessage(DOWNLOAD);
						if (numread <= 0) {
							mHandler.sendEmptyMessage(DOWNLOAD_FINISH);
							break;
						}
						fos.write(buf, 0, numread);
					} while (!cancelUpdate);
					fos.close();
					is.close();
				}
			} catch (MalformedURLException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
			mDownloadDialog.dismiss();
		}
	};
	private void installApk(){
		File apkfile = new File(mSavePath,"zhjy");
		if (!apkfile.exists()) {
			return;
		}
		// 通过Intent安装APK文件
		Intent i = new Intent(Intent.ACTION_VIEW);
		i.setDataAndType(Uri.parse("file://" + apkfile.toString()), "application/vnd.android.package-archive");
		mContext.startActivity(i);
	}
}
