package com.yt.wia.extend;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import com.squareup.picasso.Picasso;
import com.yt.wia.application.R;
import com.yt.wia.config.DbUserBean;
import com.yt.wia.view.CircleImageView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by wxixis on 16/7/19.
 */
public class AvatarAdapter extends BaseAdapter{
    private Context context;
    private List<DbUserBean> adapterList;

    private int selected = -1;

    public AvatarAdapter(){}

    public AvatarAdapter(Context context, List<DbUserBean> adapterList) {
        this.context=context;
        this.adapterList=adapterList;
        adapterList=new ArrayList<>();
    }

    public void setNotifyDataChanged(int id) {
        selected = id;
        super.notifyDataSetChanged();
    }

    @Override
    public int getCount() {
        if (adapterList!=null){
            return adapterList.size();
        }
        return 0;
    }

    @Override
    public Object getItem(int position) {
        return adapterList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder=null;
        if (convertView==null){
            convertView= LayoutInflater.from(context).inflate(R.layout.avataradapter_item,null);
            viewHolder=new ViewHolder();
            viewHolder.iv= (CircleImageView) convertView.findViewById(R.id.avataradapter_iv);
            convertView.setTag(viewHolder);
        }
        viewHolder= (ViewHolder) convertView.getTag();
        //加载用户头像
        if(adapterList.get(position).getAvatarImage().equals("http://192.168.1.103:89/null")){
            viewHolder.iv.setImageResource(R.drawable.default_photo);
        }else{
            Picasso.with(context).load(adapterList.get(position).getAvatarImage()).into(viewHolder.iv);
        }

        if (selected==position){
            RelativeLayout.LayoutParams linearParams = (RelativeLayout.LayoutParams) viewHolder.iv.getLayoutParams(); // 取控件当前的布局参数
            linearParams.height = dip2px(75);// 强制设置控件的宽高
            linearParams.width = dip2px(75);
            viewHolder.iv.setLayoutParams(linearParams); // 使设置好的布局参数应用到控件


        }else{
            RelativeLayout.LayoutParams linearParams = (RelativeLayout.LayoutParams) viewHolder.iv.getLayoutParams(); // 取控件当前的布局参数
            linearParams.height = dip2px(70);// 强制设置控件的宽高
            linearParams.width = dip2px(70);
            viewHolder.iv.setLayoutParams(linearParams); // 使设置好的布局参数应用到控件
        }

        return convertView;
    }
    class ViewHolder{
        private CircleImageView iv;
    }

    public int dip2px(float dpValue) {
        float scale = context.getResources().getDisplayMetrics().density;
        return (int) (dpValue * scale + 0.5f);
    }

}
