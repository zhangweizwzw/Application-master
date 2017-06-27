package com.yt.wia.adapter;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.google.gson.Gson;
import com.yt.wia.application.ApplyDetailActivity;
import com.yt.wia.application.LampAddressActivity;
import com.yt.wia.application.LampDetailActivity;
import com.yt.wia.application.R;
import com.yt.wia.config.SystemSettings;
import com.yt.wia.model.ApplyListBean;
import com.yt.wia.model.LampCmncBean;
import com.yt.wia.model.LampCmncRequestBean;
import com.yt.wia.model.LampListBean;
import com.yt.wia.utils.ProcessUtil;
import com.yt.wia.utils.ToastUtil;
import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.callback.StringCallback;

import java.util.List;

import okhttp3.Call;
import okhttp3.MediaType;
import okhttp3.RequestBody;

/***
 * listView的适配器
 * @author Administrator
 *
 */
public class ApplyListAdapter extends BaseAdapter {
	private final String TAG="ApplyListAdapter";
	private LayoutInflater mInflater;
	private OrderViewHolder holder;
	private Activity mcontext;
	private List<ApplyListBean.ListBean> mData;
	private LayoutInflater mLayoutInflater;
	public static final MediaType JSON=MediaType.parse("application/json; charset=utf-8");

	public ApplyListAdapter(Activity context, List<ApplyListBean.ListBean> list) {
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
		final ApplyListBean.ListBean dataList= mData.get(position);
			if (convertView == null) {
				holder = new OrderViewHolder();
		convertView = mInflater.inflate(R.layout.apply_item_view, null);
		holder.people_name = (TextView) convertView.findViewById(R.id.people_name);
		holder.company_name = (TextView) convertView.findViewById(R.id.company_name);
		holder.project_name = (TextView) convertView.findViewById(R.id.project_name);
		holder.tze = (TextView) convertView.findViewById(R.id.tze);
		holder.applytime = (TextView) convertView.findViewById(R.id.applytime);
		holder.sqqk = (TextView) convertView.findViewById(R.id.sqqk);
		holder.update= (Button) convertView.findViewById(R.id.update);
		holder.chakan= (Button) convertView.findViewById(R.id.chakan);

			convertView.setTag(holder);
		} else {
			holder = (OrderViewHolder) convertView.getTag();
		}
		holder.people_name.setText(dataList.getPersonName());
		holder.company_name.setText(dataList.getOrgName());
		holder.project_name.setText(dataList.getProjectName());
		holder.tze.setText(dataList.getTze()+"");
		holder.applytime.setText(dataList.getEntryTime());

		final int review=dataList.getReviewLink();
		String strRe="";
		if(review==1){
			strRe="待审核";
		}else if(review==99){
			strRe="完成";
		}
		holder.sqqk.setText(strRe);

		if(review==99){
			holder.update.setVisibility(View.INVISIBLE);
		}

		holder.update.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				Intent intent=new Intent();
				intent.putExtra("id",dataList.getId());
				intent.putExtra("xiugai","1");
				intent.putExtra("shenhe",review);
				intent.setClass(mcontext, ApplyDetailActivity.class);
				mcontext.startActivity(intent);
			}
		});

		holder.chakan.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				Intent intent=new Intent();
				intent.putExtra("id",dataList.getId());
				intent.putExtra("xiugai","0");
				intent.putExtra("shenhe",review);
				intent.setClass(mcontext, ApplyDetailActivity.class);
				mcontext.startActivity(intent);
			}
		});
		return convertView;
	}


	public final class OrderViewHolder {
		private TextView people_name,company_name,project_name,tze,applytime,sqqk;
		private Button update,chakan;
	}
	
}