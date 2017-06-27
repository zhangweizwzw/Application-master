package com.yt.wia.application;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.provider.Settings;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.esri.android.map.FeatureLayer;
import com.esri.android.map.GraphicsLayer;
import com.esri.android.map.MapView;
import com.esri.android.map.ags.ArcGISTiledMapServiceLayer;
import com.esri.core.geodatabase.ShapefileFeatureTable;
import com.esri.core.geometry.GeometryEngine;
import com.esri.core.geometry.Line;
import com.esri.core.geometry.MultiPath;
import com.esri.core.geometry.Point;
import com.esri.core.geometry.Polygon;
import com.esri.core.geometry.Polyline;
import com.esri.core.map.Graphic;
import com.esri.core.renderer.Renderer;
import com.esri.core.renderer.SimpleRenderer;
import com.esri.core.symbol.SimpleFillSymbol;
import com.esri.core.symbol.SimpleLineSymbol;
import com.esri.core.symbol.SimpleMarkerSymbol;
import com.esri.core.symbol.Symbol;
import com.yt.wia.commons.DownloadUtil;
import com.yt.wia.config.SystemSettings;
import com.yt.wia.utils.GPSInfoProvider;
import com.yt.wia.utils.GpsUtil;
import com.yt.wia.utils.ProcessUtil;
import com.yt.wia.utils.RangeUtil;
import com.yt.wia.utils.SdcardUtil;
import com.yt.wia.utils.StringUtil;
import com.yt.wia.utils.ToastUtil;
import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.callback.StringCallback;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import okhttp3.Call;

public class TwoDActivity extends AppCompatActivity implements View.OnClickListener{
    private final String TAG="TwoDActivity";
    private MapView map;
    private ArcGISTiledMapServiceLayer tileLayer;
    private GraphicsLayer graphicsLayer;
    private FeatureLayer featureLayer;
    private Button location_btn,sure_btn,delete_btn;
    private List<Point> points = new ArrayList<Point>();
    private TextView text_center;
    private ImageView image_left;
    private String wkid;//shape文件的wkid
    private Graphic graphic;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_two_d);

        String locat= GPSInfoProvider.getLngAndLat(this);
        Log.i(TAG,"返回结果为aaa："+locat);

        initView();

        //判断GPS是否开启
        if(!GpsUtil.isOPen(this)){
            showGpsAlert();
        }
    }

    private void initView() {
        /**
         * 初始胡标题
         */
        text_center= (TextView) findViewById(R.id.text_center);
        text_center.setText("二维地图");
        image_left= (ImageView) findViewById(R.id.image_left);
        image_left.setImageResource(R.mipmap.title_back);
        image_left.setOnClickListener(this);
        //加载图层
        map = (MapView) findViewById(R.id.map);
        location_btn= (Button) findViewById(R.id.location_btn);
        location_btn.setOnClickListener(this);
        sure_btn= (Button) findViewById(R.id.sure_btn);
        sure_btn.setOnClickListener(this);
        delete_btn= (Button) findViewById(R.id.delete_btn);
        delete_btn.setOnClickListener(this);


        tileLayer = new ArcGISTiledMapServiceLayer("http://services.arcgisonline.com/ArcGIS/rest/services/World_Street_Map/MapServer");
        map.addLayer(tileLayer);

        addShape();//加载shape

        graphicsLayer = new GraphicsLayer();
        map.addLayer(graphicsLayer);

    }
    /**
     * 加载shape
     */
    private void addShape() {
        String shpPath = SdcardUtil.getSDPath() + "/shapefile/北京102100.shp";
        try {
            ShapefileFeatureTable shapefileFeatureTable = new ShapefileFeatureTable(shpPath);
            wkid=shapefileFeatureTable.getSpatialReference().getID()+"";
            Log.i(TAG,"wkid="+wkid);
            //渲染featurelayer
            featureLayer = new FeatureLayer(shapefileFeatureTable);
            Symbol symbol = new SimpleFillSymbol(Color.BLUE);
            Renderer renderer = new SimpleRenderer(symbol);
            featureLayer.setRenderer(renderer);

            map.addLayer(featureLayer);
        } catch (FileNotFoundException e) {
            e.printStackTrace();

        }
    }

    /**
     * 网络设置对话框
     */
    private void showGpsAlert() {
        Log.i("TAG","进入gps设置");
        AlertDialog.Builder alert=new AlertDialog.Builder(this);
        alert.setTitle("提示");
        alert.setMessage("GPS定位未开启，去开启？");
        alert.setCancelable(false);
        alert.setPositiveButton("设置", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                startActivity(new Intent(Settings.ACTION_LOCATION_SOURCE_SETTINGS));
            }
        });
        alert.setNegativeButton("取消", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                finish();
            }
        });
        alert.create();
        alert.show();
    }
    /**
     * 设置完gps
     * @param requestCode
     * @param resultCode
     * @param data
     */
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode==1){

        }
    }

    /**
     * 验证shape名称是否为纯数字
     * @param str
     * @return
     */
    public boolean isNumeric(String str){
        Pattern pattern = Pattern.compile("[0-9]*");
        Matcher isNum = pattern.matcher(str);
        if( !isNum.matches() ){
            return false;
        }
        return true;
    }

    /**
     * shape名称对话框
     */
    private void showInputDialog() {
        final EditText editText = new EditText(TwoDActivity.this);
        AlertDialog.Builder inputDialog =
                new AlertDialog.Builder(TwoDActivity.this);
        inputDialog.setTitle("请输入要生成的shape名").setView(editText);
        inputDialog.setPositiveButton("确定",
                new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        String shapename=editText.getText().toString();
                        Log.i(TAG,"shapename="+shapename);
                        if(StringUtil.isEmpty(shapename)){
                            ToastUtil.showToast(TwoDActivity.this,"shape不能为空！");
                        }else if(isNumeric(shapename)){
                            ToastUtil.showToast(TwoDActivity.this,"shape名称不能为纯数字！");
                        }else if(shapename.length()>20){
                           ToastUtil.showToast(TwoDActivity.this,"shape名称过长！");
                        }else{
                            uplodePoint(shapename);
                        }
                    }
                });
        inputDialog.setNegativeButton("取消", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        });
        inputDialog.show();
    }

    /**
     * 上传位置信息
     */
    private void uplodePoint(final String shapename) {
        String strpoint="";
        for (int i=0;i<points.size();i++){
            strpoint=strpoint+points.get(i).getX()+","+points.get(i).getY()+";";
        }
        Log.i(TAG,"strpoint="+strpoint);

        ProcessUtil.showProcess(this,"正在加载，请稍后...");
        OkHttpUtils
                .post()
                .url(SystemSettings.NEWREQUEST_URL+"gis/createShp")
                .addParams("targetName",shapename)
                .addParams("porints",strpoint)
                .addParams("wkid", wkid)
                .build()
                .execute(new StringCallback() {
                    @Override
                    public void onError(Call call, Exception e) {
                        ProcessUtil.dismiss();
                        ToastUtil.showToast(TwoDActivity.this, e.getMessage());//弹出错误信息
                        Log.i(TAG, "生成shape文件错误返回=" + e.getMessage());
                        showchongshi(shapename);
                    }

                    @Override
                    public void onResponse(String response) {
                        Log.i(TAG, "生成shape文件返回=" + response);
                        ProcessUtil.dismiss();
                        if("0".equals(response)){
                            showNormalDialog(shapename);
//                            showchongshi(shapename);
                        }
                    }

            });

    }

    /**
     * 生成shape文件失败
     * 弹框提示是否重新生成
     * @param shapename
     */
    private void showchongshi(final String shapename) {
        final AlertDialog.Builder normalDialog =
                new AlertDialog.Builder(TwoDActivity.this);
        normalDialog.setTitle("提示");
        normalDialog.setMessage("生成shape文件失败，是否重试?");
        normalDialog.setPositiveButton("确定",
                new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        uplodePoint(shapename);
                    }
                });
        normalDialog.setNegativeButton("取消",
                new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        String spoint="";
                        for (int i=0;i<points.size();i++){
                            spoint=spoint+points.get(i).getX()+","+points.get(i).getY()+";";
                        }

                        createfilejia();//创建文件夹
                        String filecontent="targetname="+shapename+"\nporints="+spoint+"\nwkid="+wkid;
                        if(fileIsExists(shapename+".txt")){//判断文件是否存在
                            showfileexistsdialog(shapename,filecontent);
                        }else{
                            writeTxtToFile(shapename,filecontent);
                        }

                    }
                });
        // 显示
        normalDialog.show();

    }

    /**
     * shape.txt文件存在
     * 提示是否继续
     * @param sname
     * @param content
     */
    private void showfileexistsdialog(final String sname, final String content) {
        final AlertDialog.Builder normalDialog =
                new AlertDialog.Builder(TwoDActivity.this);
        normalDialog.setTitle("提示");
        normalDialog.setMessage("shape文件已存在，是否继续？");
        normalDialog.setPositiveButton("确定",
                new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        if(deletefile(sname)){
                            writeTxtToFile(sname,content);
                        }else{
                            ToastUtil.showToast(TwoDActivity.this,"文件删除失败，请重试！");
                        }

                    }
                });
        normalDialog.setNegativeButton("取消",
                new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                });
        // 显示
        normalDialog.show();
    }

    /**
     * 生成成功
     * 提示是否下载
     */
    private void showNormalDialog(final String shapename){
        final AlertDialog.Builder normalDialog =
                new AlertDialog.Builder(TwoDActivity.this);
        normalDialog.setTitle("提示");
        normalDialog.setMessage("生成shape文件成功，是否保存到本地?");
        normalDialog.setPositiveButton("确定",
                new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        downShape(shapename);
                    }
                });
        normalDialog.setNegativeButton("取消",
                new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                    }
                });
        // 显示
        normalDialog.show();
    }

    /**
     * 下载shape.zip文件
     * @param shapename
     */
    private void downShape(String shapename) {
        DownloadUtil.get().download(SystemSettings.UPLOADSHAPEREQUEST_URL+shapename+".zip", SdcardUtil.getSDPath(), new DownloadUtil.OnDownloadListener() {
            @Override
            public void onDownloadSuccess() {
                ToastUtil.showToast(TwoDActivity.this, "下载完成");
            }
            @Override
            public void onDownloading(int progress) {
//                progressBar.setProgress(progress);
                Log.i(TAG,"下载进度="+progress);
            }
            @Override
            public void onDownloadFailed() {
                ToastUtil.showToast(TwoDActivity.this, "下载失败");
            }
        });
    }


    /**
     * 定位
     */
    private void contLocation() {
        String locat= GPSInfoProvider.getLngAndLat(this);
        Log.i(TAG,"返回结果为："+locat);
        if("".equals(locat)){
//            ToastUtil.showToast(this,"获取卫星失败");
        }else{
//            Point point1=new Point();
//            point1.setX(1.2988176563379282E7);
//            point1.setY(4904376.693592213);
//
//            Point point2=new Point();
//            point2.setX(1.2925498200185413E7);
//            point2.setY(4899484.723781959);
//
//            Point point3=new Point();
//            point3.setX(1.2919077489809455E7);
//            point3.setY(4852705.262471414);
//
//            Point point4=new Point();
//            point4.setX(1.2955461515273213E7);
//            point4.setY(4793084.380408954);
//
//            Point point5=new Point();
//            point5.setX(1.3037860631764665E7);
//            point5.setY(4842921.322850907);
//
//            Point point6=new Point();
//            point6.setX(1.2988176563379282E7);
//            point6.setY(4904376.693592213);
//
//            if(points.size()==0){
//                points.add(point1);
//            }else  if(points.size()==1){
//                points.add(point2);
//            }else  if(points.size()==2){
//                points.add(point3);
//            }else  if(points.size()==3){
//                points.add(point4);
//            }else  if(points.size()==4){
//                points.add(point5);
//            }else  if(points.size()==5){
//                points.add(point6);
//            }

            String lots[]=locat.split(",");
            Double lat=Double.valueOf(lots[1]);
            Double lon=Double.valueOf(lots[0 ]);
            Log.i(TAG,"定位经度为:"+lat+"\n"+"纬度为:"+lon);
            Point po=new Point();
            po.setX(Double.valueOf(lat));
            po.setX(Double.valueOf(lon));

            Point poi=new Point();
            poi.setX(Double.valueOf(lat));
            poi.setY(Double.valueOf(lon));

//            Point mapPoint = (Point) GeometryEngine.project(poi ,SpatialReference.create(4326),map.getSpatialReference());
//            Point laopPoint = (Point) GeometryEngine.project(po ,SpatialReference.create(4326),map.getSpatialReference());
            Point mapPoint = (Point)GeometryEngine.project(lon, lat, map.getSpatialReference());
            points.add(mapPoint);

            Log.i(TAG,mapPoint.getX()+mapPoint.getY()+"<----->"+points.size()+"<------");

            if(points.size()>1){
                range();
            }
            drawLine();
        }


        //经纬度坐标转投影坐标
//
    }

    /**
     * 2点之间距离
     */
    public void range(){
        Line line = new Line();
        line.setStart(points.get(points.size()-2));
        line.setEnd(points.get(points.size()-1));

        String length = Double.toString(Math.round(line.calculateLength2D())) + " 米";
        ToastUtil.showToast(this,"2点距离为："+length);
        Log.i(TAG,"2点之间距离:"+length);
    }

    /**
     * 创建文件夹
     */
    private void createfilejia() {
        File destDir = new File(SdcardUtil.getSDPath()+"/shapetxt");
        if (!destDir.exists()) {
            destDir.mkdirs();
        }
    }

    /**
     * 判断.txt文件是否存在
     * @param filename
     * @return
     */
    public boolean fileIsExists(String filename){
        try{
            File f=new File(SdcardUtil.getSDPath()+"/shapetxt/"+filename);
            if(!f.exists()){
                return false;
            }
        }catch (Exception e) {
            return false;
        }
        return true;
    }

    // 将字符串写入到文本文件中
    public void writeTxtToFile(String fileName,String strcontent) {
        String strFilePath = SdcardUtil.getSDPath()+"/shapetxt/"+fileName+".txt";
        Log.i(TAG,"strFilePath="+strFilePath);
        try {
            File file = new File(strFilePath);
            if (!file.exists()) {
                Log.i(TAG,"创建件夹");
                file.getParentFile().mkdirs();
                file.createNewFile();
            }
            RandomAccessFile raf = new RandomAccessFile(file, "rwd");
            raf.seek(file.length());
            raf.write(strcontent.getBytes());
            raf.close();
            Log.i(TAG,"创建txt文件成功");
            ToastUtil.showToast(TwoDActivity.this, "文件保存成功！");
        } catch (Exception e) {
            Log.i(TAG,"创建txt文件失败"+e.getMessage());
            ToastUtil.showToast(TwoDActivity.this, "文件保存失败！");
        }
    }

    /**
     * 删除单个shape.txt文件
     * @param   sname
     */
    public boolean deletefile(String sname) {
        String strFilePath = SdcardUtil.getSDPath()+"/shapetxt/"+sname+".txt";
        boolean flag = false;
        File file = new File(strFilePath);
        // 路径为文件且不为空则进行删除
        if (file.isFile() && file.exists()) {
            file.delete();
            flag = true;
        }
        return flag;
    }

    /**
     * 画线
     */
    //划线
    private void drawLine() {
        if(points.size()>0){
            if (graphicsLayer == null) {
                graphicsLayer = new GraphicsLayer();
                map.addLayer(graphicsLayer);
            }

            Graphic graphic;
            MultiPath multipath;
            multipath = new Polyline();
            multipath.startPath(points.get(0));
            for (int i = 1; i < points.size(); i++) {
                multipath.lineTo(points.get(i));
            }
            Log.i(TAG,"点的个数为:"+points.size());
            graphic = new Graphic(multipath, new SimpleLineSymbol(Color.RED, 4));
            graphicsLayer.addGraphic(graphic);

            //一条数据画点
            graphic = new Graphic(points.get(0), new SimpleMarkerSymbol(Color.BLACK,5, SimpleMarkerSymbol.STYLE.CIRCLE));
            graphicsLayer.addGraphic(graphic);
        }
    }

    /**
     * 计算面积
     */
    public void  showarea(){
        Polygon tempPolygon=new Polygon();
        Point startPoint=null;
        Point endPoint=null;
        for(int i=1;i<points.size();i++)
        {
            startPoint = points.get(i-1);
            endPoint = points.get(i);

            Line line1 = new Line();
            line1.setStart(startPoint);
            line1.setEnd(endPoint);

            tempPolygon.addSegment(line1, false);
        }
        String sArea =RangeUtil.getAreaString(tempPolygon.calculateArea2D());
       Log.i(TAG,"面积为:"+sArea);
        ToastUtil.showToast(this,"面积为:"+sArea);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.location_btn:
                contLocation();
                break;
            case R.id.sure_btn:
                if(points.size()<4){
                    ToastUtil.showToast(this,"位置信息不能少于4个点！");
                }else{
                    if(points.get(0).getX()!=points.get(points.size()-1).getX()||points.get(0).getY()!=points.get(points.size()-1).getY()){
                        ToastUtil.showToast(this,"位开始位置和结束位置不一致！");
                    }else{
                        showarea();
//                        showInputDialog();
                    }
                }
                break;
            case R.id.delete_btn:
                if(points.size()==0){
                    ToastUtil.showToast(TwoDActivity.this,"暂没有保存的坐标点!");
                }else{
                    points.remove(points.size()-1);
                    graphicsLayer.removeAll();
                    drawLine();
                }
                break;
            case R.id.image_left:
                finish();
                break;
        }
    }

}


