package com.test.mylocation;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import androidx.fragment.app.FragmentActivity;


import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.test.mylocation.data.Store;

import java.util.ArrayList;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;


    ArrayList<MarkerOptions> list = new ArrayList<>();
    double lat;
    double lng;
    String name;
    String addr;
    ArrayList<Store> storeArrayList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

        Intent i = getIntent();
        Store store = (Store) i.getSerializableExtra("store");

        name = store.getName();
        addr = store.getVicinity();
        lat = store.getLat();
        lng = store.getLng();


        if (storeArrayList != null) {

        } else {
            lat = i.getDoubleExtra("lat", 0);
            lng = i.getDoubleExtra("lng", 0);
            name = i.getStringExtra("name");
            Log.i("BBB", "" + lat);
            Log.i("BBB", "" + lng);
        }

    }


    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        // Add a marker in Sydney and move the camera
        LatLng storeInfo = new LatLng(lat,lng);
        mMap.addMarker(new MarkerOptions().position(storeInfo).title(name).snippet(addr));
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(storeInfo,15));



//        if (storeArrayList != null){
//            for (int i = 0; i < storeArrayList.size();i++){
//                list.add(new MarkerOptions().position(new LatLng(storeArrayList.get(i).getLat(),storeArrayList.get(i).getLng())).title(storeArrayList.get(i).getName()));
//            }
//            for (MarkerOptions markerOptions : list){
//                mMap.addMarker(markerOptions);
//            }
//            mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(new LatLng(storeArrayList.get(0).getLat(),storeArrayList.get(0).getLng()),15));
//        }else {
//            MarkerOptions storeInfo = new MarkerOptions().position(new LatLng(lat, lng))
//                    .title(name);
//            // 2. ArrayList 에 넣어준다.
//            list.add(storeInfo);
//
//            for (MarkerOptions markerOptions : list){
//                mMap.addMarker(markerOptions);
//            }
        // 지도의 중심으로 잡고 싶은 좌표를 넣어주면, 지도의 중심으로 설정된다.
//            mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(new LatLng(lat,lng), 18));

    }


}
