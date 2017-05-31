package com.yt.wia.application;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Environment;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.Toast;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.yt.signature.SignaturePad;
import com.yt.wia.commons.ThreadToast;
import com.yt.wia.config.SystemSettings;
import com.yt.wia.config.UploadBean;

import org.xutils.view.annotation.ContentView;
import org.xutils.view.annotation.ViewInject;
import org.xutils.x;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;

import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

@ContentView(value =R.layout.activity_signature)
public class SignatureActivity extends Activity {
    @ViewInject(value =R.id.signature_pad)
    private SignaturePad mSignaturePad;
    @ViewInject(value =R.id.clear_button)
    private Button mClearButton;
    @ViewInject(value =R.id.save_button)
    private Button mSaveButton;
    private File svgFile;
    private Context mContext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);//隐藏标题
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);//设置全屏
        x.view().inject(this);

        mContext=this;
        svgFile = new File(getAlbumStorageDir("SignaturePad"), String.format("Signature_%d.svg", System.currentTimeMillis()));

        mSignaturePad.setOnSignedListener(new SignaturePad.OnSignedListener() {
            @Override
            public void onStartSigning() {
            }

            @Override
            public void onSigned() {
                mSaveButton.setEnabled(true);
                mClearButton.setEnabled(true);
            }

            @Override
            public void onClear() {
                mSaveButton.setEnabled(false);
                mClearButton.setEnabled(false);
            }
        });
    }

    public void OnClearall(View v){
        mSignaturePad.clear();
    }
    public void onSaveButton(View v){

        Bitmap signatureBitmap = mSignaturePad.getSignatureBitmap();
//        if(addJpgSignatureToGallery(signatureBitmap)) {
//            System.out.println("保存成功！"+svgFile);
//            uploadImage(svgFile+"");
            saveBitmap(signatureBitmap);
//        } else {
//            System.out.println("保存失败！");
//        }
//        if(addSvgSignatureToGallery(mSignaturePad.getSignatureSvg())) {
//        } else {
//        }
    }

    public boolean addJpgSignatureToGallery(Bitmap signature) {
        boolean result = false;
        try {
            File photo = new File(getAlbumStorageDir("SignaturePad"), String.format("Signature_%d.jpg", System.currentTimeMillis()));
            saveBitmapToJPG(signature, photo);
            scanMediaFile(photo);
            result = true;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }

    public File getAlbumStorageDir(String albumName) {
        // Get the directory for the user's public pictures directory.
        File file = new File(Environment.getExternalStoragePublicDirectory(
                Environment.DIRECTORY_PICTURES), albumName);
        if (!file.mkdirs()) {
        }
        return file;
    }

    public void saveBitmapToJPG(Bitmap bitmap, File photo) throws IOException {
        Bitmap newBitmap = Bitmap.createBitmap(bitmap.getWidth(), bitmap.getHeight(), Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(newBitmap);
        canvas.drawColor(Color.WHITE);
        canvas.drawBitmap(bitmap, 0, 0, null);
        OutputStream stream = new FileOutputStream(photo);
        newBitmap.compress(Bitmap.CompressFormat.JPEG, 80, stream);
        stream.close();
    }

    private void scanMediaFile(File photo) {
        Intent mediaScanIntent = new Intent(Intent.ACTION_MEDIA_SCANNER_SCAN_FILE);
        Uri contentUri = Uri.fromFile(photo);
        mediaScanIntent.setData(contentUri);
        SignatureActivity.this.sendBroadcast(mediaScanIntent);
    }

    public boolean addSvgSignatureToGallery(String signatureSvg) {
        boolean result = false;
        try {
            OutputStream stream = new FileOutputStream(svgFile);
            OutputStreamWriter writer  = new OutputStreamWriter(stream);
            writer.write(signatureSvg);
            writer.close();
            stream.flush();
            stream.close();
            scanMediaFile(svgFile);
            result = true;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }

    /**
     * 上传图片
     * @param imagePath
     */
    private void uploadImage(String imagePath) {
        new NetworkTask().execute(imagePath);
    }

    /**
     * 访问网络AsyncTask,访问网络在子线程进行并返回主线程通知访问的结果
     */
    class NetworkTask extends AsyncTask<String, Integer, String> {

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
        }

        @Override
        protected String doInBackground(String... params) {
            return doPost(params[0]);
        }

        @Override
        protected void onPostExecute(String result) {}
    }

    /**
     * 保存图片
     * @param bmp
     */
    private void saveBitmap(Bitmap bmp) {
        String pathimg=getApplicationContext().getFilesDir().getAbsolutePath();
        File file = new File(pathimg);
        if (!file.exists())
            file.mkdir();

        String newFilePath = ""+pathimg+"/handwrite.jpg";
        file = new File(newFilePath);
        try {
            file.createNewFile();
            FileOutputStream fos = new FileOutputStream(file);
            bmp.compress(Bitmap.CompressFormat.JPEG, 50, fos);
            fos.flush();
            fos.close();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        uploadImage(newFilePath);
    }

    private String doPost(String imagePath) {
        OkHttpClient mOkHttpClient = new OkHttpClient();

        String result = "error";
        MultipartBody.Builder builder = new MultipartBody.Builder();
        builder.addFormDataPart("files", imagePath,
                RequestBody.create(MediaType.parse("image/jpeg"), new File(imagePath)));
        RequestBody requestBody = builder.build();
        Request.Builder reqBuilder = new Request.Builder();
        Request request = reqBuilder
//                .url(Constant.BASE_URL + "/uploadimage")
                .url(SystemSettings.BASE_URL)
                .post(requestBody)
                .build();

//        System.out.println("请求地址 " + BASE_URL);
        try{
            Response response = mOkHttpClient.newCall(request).execute();
            System.out.println( "响应码 " + response.code());
            if (response.isSuccessful()) {
                String resultValue = response.body().string();
//                System.out.println("响应体 " + resultValue);
                Gson gson=new Gson();
//                UploadBean uBean=gson.fromJson(resultValue, UploadBean.class);
                UploadBean uBean=gson.fromJson(resultValue.substring(1,resultValue.length()-1), UploadBean.class);
                ThreadToast.backThreadLongToast(mContext,"上传成功,图片URL==>http://192.168.1.103:8080/rm/upload/handwrite/"+uBean.getNewName());
                return resultValue;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

}
