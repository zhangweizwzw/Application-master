package com.yt.wia.application;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.RelativeLayout;

import com.esri.android.map.GraphicsLayer;
import com.esri.android.map.LocationDisplayManager;
import com.esri.android.map.MapView;
import com.esri.android.map.ags.ArcGISTiledMapServiceLayer;
import com.esri.android.map.event.OnStatusChangedListener;
import com.esri.core.geometry.GeometryEngine;
import com.esri.core.geometry.Point;
import com.esri.core.geometry.SpatialReference;
import com.esri.core.map.Graphic;
import com.esri.core.symbol.PictureMarkerSymbol;
import com.esri.core.symbol.SimpleMarkerSymbol;
import com.yt.wia.adapter.LampListAdapter;

public class LampAddressActivity extends AppCompatActivity implements View.OnClickListener {
    private static final String TAG="LampAddressActivity";
    private ArcGISTiledMapServiceLayer tileLayer;
    private GraphicsLayer graphicsLayer;
    private MapView lampmap;
    private Graphic graphic;
    private RelativeLayout large_rela,small_rela;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lamp_address);

        initView();
    }

    private void initView() {
        large_rela= (RelativeLayout) findViewById(R.id.large_rela);
        small_rela= (RelativeLayout) findViewById(R.id.small_rela);
        large_rela.setOnClickListener(this);
        small_rela.setOnClickListener(this);

        final Double lat=getIntent().getDoubleExtra("lat",0.0);
        final Double lon=getIntent().getDoubleExtra("lon",0.0);


        lampmap = (MapView) findViewById(R.id.lampmap);
        tileLayer = new ArcGISTiledMapServiceLayer("http://services.arcgisonline.com/ArcGIS/rest/services/World_Street_Map/MapServer");
        lampmap.setOnStatusChangedListener(new OnStatusChangedListener() {
            public void onStatusChanged(Object source, STATUS status) {
                if (source == lampmap && status == STATUS.INITIALIZED) {
                    ShowLocation(lon,lat);
                }
            }
        });


        lampmap.addLayer(tileLayer);
        graphicsLayer = new GraphicsLayer();
        lampmap.addLayer(graphicsLayer);
    }

    //将地图移动到当前位置
    public void ShowLocation(double locx,double locy) {
        PictureMarkerSymbol locationPH = new PictureMarkerSymbol(LampAddressActivity.this.getResources().getDrawable(R.mipmap.redlocation));
        Point wgspoint = new Point(locx, locy);
        Point mapPoint = (Point) GeometryEngine.project(wgspoint,
                SpatialReference.create(4326), lampmap.getSpatialReference());
        graphicsLayer.removeAll();
        graphicsLayer.addGraphic(new Graphic(mapPoint, locationPH));
        lampmap.centerAt(mapPoint, true);// 漫游到当前位置
    }
    /**
     * 点击事件
     */
    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.large_rela:
                finish();
                break;
            case R.id.small_rela:

                break;
        }
    }

}
