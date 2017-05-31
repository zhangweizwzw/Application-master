package com.yt.wia.adapter;

import java.util.List;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.provider.Settings;
import android.support.v7.app.AlertDialog;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.google.gson.Gson;
import com.yt.wia.application.LampActivity;
import com.yt.wia.application.LampAddressActivity;
import com.yt.wia.application.LampDetailActivity;
import com.yt.wia.application.R;
import com.yt.wia.config.SystemSettings;
import com.yt.wia.model.LampCmncBean;
import com.yt.wia.model.LampCmncRequestBean;
import com.yt.wia.model.LampListBean;
import com.yt.wia.utils.ProcessUtil;
import com.yt.wia.utils.ToastUtil;
import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.callback.StringCallback;

import okhttp3.Call;
import okhttp3.MediaType;
import okhttp3.RequestBody;

/***
 * listView的适配器
 * @author Administrator
 *
 */
public class LampListAdapter extends BaseAdapter {
	private final String TAG="LampListAdapter";
	private LayoutInflater mInflater;
	private OrderViewHolder holder;
	private Activity mcontext;
	private List<LampListBean.ListBean> mData;
	private LayoutInflater mLayoutInflater;
	public static final MediaType JSON=MediaType.parse("application/json; charset=utf-8");

	public LampListAdapter(Activity context,List<LampListBean.ListBean> list) {
		mcontext=context;
		mInflater = LayoutInflater.from(mcontext);
		this.mData=list;
		mLayoutInflater=LayoutInflater.from(mcontext);
	}
	
	@Override        
	public int getCount() {            
		return mData.size();
	}
	
	@Override        
	public Object getItem(int position) {            
		return mData.get(position);
	}            
	
	@Override       
	public long getItemId(int position) {       
		return position;
	}            
	
	@Override        
	public View getView(final int position, View convertView, ViewGroup parent) {            
		holder = null;
		//convertView为null的时候初始化convertView。  
		final LampListBean.ListBean dataList= mData.get(position);
		if (convertView == null) {
		holder = new OrderViewHolder();
		convertView = mInflater.inflate(R.layout.lamp_item_view, null);
		holder.lname = (TextView) convertView.findViewById(R.id.lname);
		holder.lmac = (TextView) convertView.findViewById(R.id.lmac);
		holder.lamass = (TextView) convertView.findViewById(R.id.lamass);
		holder.lid = (TextView) convertView.findViewById(R.id.lid);
		holder.laddress = (TextView) convertView.findViewById(R.id.laddress);
		holder.ltype = (TextView) convertView.findViewById(R.id.ltype);
		holder.lloop = (TextView) convertView.findViewById(R.id.lloop);
		holder.lstatus = (TextView) convertView.findViewById(R.id.lstatus);
		holder.lcstatus = (TextView) convertView.findViewById(R.id.lcstatus);
		holder.largeLin= (LinearLayout) convertView.findViewById(R.id.largeLin);
		holder.address_btn= (Button) convertView.findViewById(R.id.address_btn);
		holder.onoroff_btn= (Button) convertView.findViewById(R.id.onoroff_btn);
			convertView.setTag(holder);
		} else {
			holder = (OrderViewHolder) convertView.getTag();
		}
		holder.lname.setText(dataList.getLamp_cntr_name());
		holder.lmac.setText(dataList.getLamp_cntr_mcad());
		holder.lamass.setText(dataList.getCntr_cntr_name());
		holder.lid.setText(dataList.getLamp_cntr_sn()+"");
		holder.laddress.setText(dataList.getCntr_cntr_adrs());
		holder.ltype.setText(dataList.getType_name());
		holder.lloop.setText(dataList.getLamp_subordinate_circuit());
		holder.lstatus.setText(dataList.getLamp_cntr_lcst());
		holder.lcstatus.setText(dataList.getLamp_cntr_lccn());

		String lcstStatus=dataList.getLamp_cntr_lcst();
		if(lcstStatus.contains("Off")){
			holder.onoroff_btn.setText("开灯");
		}else if(lcstStatus.contains("On")){
			holder.onoroff_btn.setText("关灯");
		}else{
			holder.onoroff_btn.setVisibility(View.GONE);
		}

		final OrderViewHolder tempHolder = holder;
		/**
		 *显示详情
		 */
		tempHolder.largeLin.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				Intent intent=new Intent();
				intent.putExtra("lid", dataList.getLamp_cntr_id()+"");
				intent.setClass(mcontext,LampDetailActivity.class);
				mcontext.startActivity(intent);
			}
		});

		/**
		 *显示位置
		 */
		tempHolder.address_btn.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				Intent intent=new Intent();
				Double lat=dataList.getLamp_cntr_lttd();
				Double lon=dataList.getLamp_cntr_lngt();

				intent.putExtra("lat",lat);
				intent.putExtra("lon",lon);
				intent.setClass(mcontext,LampAddressActivity.class);
				mcontext.startActivity(intent);
			}
		});

		/**
		 * 开灯or关灯
		 */
		tempHolder.onoroff_btn.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				showGpsAlert(dataList);
//				lompOffOn(dataList);

			}
		});

		return convertView;
	}
	/**
	 * 弹框提示是否确认开关灯
	 */
	private void showGpsAlert(final LampListBean.ListBean dataList) {
		String strLcst=dataList.getLamp_cntr_lcst();
		String lompname=dataList.getLamp_cntr_name();

		String strMsg="";
		if(strLcst.contains("Off")){
			strMsg="当前要开启的灯控器为"+lompname+",请确认是否进行操作";
		}else if(strLcst.contains("On")){
			strMsg="当前要关闭的灯控器为"+lompname+",请确认是否进行操作";
		}
		AlertDialog.Builder alert=new AlertDialog.Builder(mcontext);
		alert.setTitle("提示");
		alert.setMessage(strMsg);
		alert.setCancelable(false);
		alert.setPositiveButton("确定", new DialogInterface.OnClickListener() {
			@Override
			public void onClick(DialogInterface dialogInterface, int i) {
				lompOffOn(dataList);
			}
		});
		alert.setNegativeButton("取消", new DialogInterface.OnClickListener() {
			@Override
			public void onClick(DialogInterface dialogInterface, int i) {

			}
		});
		alert.create();
		alert.show();
	}


	/**
	 * 开灯关灯请求网络
	 * @param dataList
	 */
	private void lompOffOn(LampListBean.ListBean dataList) {
		String strLcst=dataList.getLamp_cntr_lcst();
		String kaiguan="";
		String stroffon="";
		if(strLcst.contains("Off")){
            stroffon="100";
            kaiguan="正在开灯，请稍后...";
        }else if(strLcst.contains("On")){
            stroffon="0";
            kaiguan="正在关灯，请稍后...";
        }

		LampCmncBean bean=new LampCmncBean();
		bean.setCmnc_ccad(dataList.getCntr_cntr_adrs());
		bean.setCmnc_lnsn(Integer.parseInt(dataList.getLamp_subordinate_circuit()));
		bean.setCmnc_lmsn(dataList.getLamp_cntr_sn());
		bean.setCmnc_cmnd("144");
		bean.setCmnc_data(stroffon);

		Gson gson=new Gson();
		String jsonstr=gson.toJson(bean);
		RequestBody body=RequestBody.create(JSON,jsonstr);

		ProcessUtil.showProcess(mcontext,kaiguan);

		OkHttpUtils
                .put()
                .url(SystemSettings.LAMP_URL+"opencloselamp")
                .requestBody(body)
                .build()
                .connTimeOut(1000*60*5)
                .readTimeOut(1000*60*5)
                .writeTimeOut(1000*60*5)
                .execute(new StringCallback() {
                    @Override
                    public void onError(Call call, Exception e) {
                        Log.i(TAG,"开关灯错误："+e.toString());
                        ProcessUtil.dismiss();
                        ToastUtil.showToast(mcontext,"服务器繁忙，请稍后重试！");
                    }

                    @Override
                    public void onResponse(String response) {
                        ProcessUtil.dismiss();
                        Log.i(TAG,"开关灯返回："+response);
                        Gson gson=new Gson();
                        LampCmncRequestBean rbean=gson.fromJson(response, LampCmncRequestBean.class);
						rbean.getCmnc_stts();
                        if(rbean.getCmnc_stts().equals("1")){
                            ToastUtil.showToast(mcontext,"操作成功");
                        }else{
                            ToastUtil.showToast(mcontext,"操作失败，请稍后再试！");
                        }

                    }
                });
	}


	public final class OrderViewHolder {
		private TextView lname,lmac,lamass,lid,laddress,ltype,lloop,lstatus,lcstatus;
		private LinearLayout largeLin;
		private Button address_btn,onoroff_btn;
	}   
	
}