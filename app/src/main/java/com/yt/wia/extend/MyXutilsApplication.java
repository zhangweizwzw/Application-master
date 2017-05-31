package com.yt.wia.extend;

import android.app.Application;
import android.os.Environment;
import android.util.Log;

//import com.alipay.euler.andfix.patch.PatchManager;
import com.yt.wia.application.BuildConfig;

import org.xutils.DbManager;
import org.xutils.x;

import java.io.File;
import java.io.IOException;

/**
 * Created by wxixis on 16/7/11.
 */
public class MyXutilsApplication extends Application{
    private static final String TAG = "euler";
    private static MyXutilsApplication myXutilsApplication;
    private static  DbManager.DaoConfig daoConfig;
    private static final String APATCH_PATH = "/out.apatch";
//    private PatchManager mPatchManager;

    /**
     * 存储用户数据
     */
    public String userName="";//userName
    public String sex="";//sex
    public String addr="";//addr



    @Override
    public void onCreate() {
        super.onCreate();
        myXutilsApplication=this;
        x.Ext.init(this);//xutils初始化
//        x.Ext.setDebug(BuildConfig.DEBUG);
        setDbConfig();//配置数据库

//        try {
//            //注意每次appversion变更都会导致所有补丁被删除,如果appversion没有改变，则会加载已经保存的所有补丁。
//            String appversion= getPackageManager().getPackageInfo(getPackageName(), 0).versionName;
//            mPatchManager = new PatchManager(this);
//            mPatchManager.init(appversion);
//            mPatchManager.loadPatch();
//            //添加patch，只需指定patch的路径即可，补丁会立即生效
//            String fpath = Environment.getExternalStorageDirectory().getAbsolutePath() + APATCH_PATH;
//            mPatchManager.addPatch(fpath);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
    }

    public static MyXutilsApplication myXutilsApplication(){
        return myXutilsApplication;
    }

    public DbManager.DaoConfig getDaoConfig(){
        return daoConfig;
    }
    private void setDbConfig(){
        daoConfig=new DbManager.DaoConfig()
                .setDbName("users.db")
                .setDbVersion(1)
                .setDbUpgradeListener(new DbManager.DbUpgradeListener() {
                    @Override
                    public void onUpgrade(DbManager db, int oldVersion, int newVersion) {
                        db.getDatabase().enableWriteAheadLogging();//提高读写速度
                    }
                });
    }
}
