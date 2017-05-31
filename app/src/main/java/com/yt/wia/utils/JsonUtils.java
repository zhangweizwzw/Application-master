package com.yt.wia.utils;

import com.yt.wia.config.Users;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.List;

/**
 * Created by wxixis on 16/7/28.
 */
public class JsonUtils {
    public static Users getJson(String s){
        JSONObject jsonObject= null;
        try {
            jsonObject = new JSONObject(s);
            boolean b=false;
            Users users=new Users();
            String status=jsonObject.getString("status");
            if(status.equals("true")){
                String avatarImage=jsonObject.getString("avatarImage");
                users.setAvatarImage("http://192.168.1.103:89/"+avatarImage);
            }
            users.setStatus(status);

            return users;
        } catch (JSONException e) {
            e.printStackTrace();
        }

        return null;
    }
}
