package com.example.and_1;

import android.Manifest;
import android.content.pm.PackageManager;
import android.location.Location;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationCallback;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.LocationResult;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
    LocationRequest mLocationRequest;
    FusedLocationProviderClient mFusedLocationClient;
    LocationCallback mLocationCallback;
    TextView mLocationTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);

        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);

        mLocationTextView = findViewById(R.id.location);
        mLocationRequest = new LocationRequest();
        mLocationRequest.setInterval(10000);
        mLocationRequest.setPriority(LocationRequest.PRIORITY_HIGH_ACCURACY);
        mFusedLocationClient = LocationServices.getFusedLocationProviderClient(this);

        mLocationCallback = new LocationCallback() {

            @Override
            public void onLocationResult(LocationResult locationResult) {
                Location currentLocation = locationResult.getLastLocation();
                LatLng currentLatLong = new LatLng(currentLocation.getLatitude(), currentLocation.getLongitude());
                mLocationTextView.setText(currentLocation.getLatitude() + ",  " + currentLocation.getLongitude());
                mMap.moveCamera(CameraUpdateFactory.newLatLng(currentLatLong));
                super.onLocationResult(locationResult);
            }
        };

        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED) {
            doSomethingWithPermission();
        } else {
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.ACCESS_FINE_LOCATION}, 42);
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        if (requestCode == 42) {
            if (grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                doSomethingWithPermission();
            } else {
                Toast.makeText(this, "Permissions NOT Granted :(", Toast.LENGTH_SHORT).show();
            }
        }
    }

    private void doSomethingWithPermission() {
        Toast.makeText(this, "Permissions Granted", Toast.LENGTH_SHORT).show();
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED
                && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            return;
        }
        mFusedLocationClient.requestLocationUpdates(mLocationRequest, mLocationCallback, null);
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;
        LatLng bilka = new LatLng(55.8586554, 9.8540085);
        mMap.addMarker(new MarkerOptions().position(bilka).title("Bilka"));
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(bilka,20f));

        LatLng netto = new LatLng(55.858922, 9.853815);
        mMap.addMarker(new MarkerOptions().position(netto).title("Netto"));
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(netto,20f));

        LatLng fakta = new LatLng(55.858886, 9.854781);
        mMap.addMarker(new MarkerOptions().position(fakta).title("Fakta"));
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(fakta,20f));

        LatLng rema = new LatLng(55.859563, 9.845155);
        mMap.addMarker(new MarkerOptions().position(rema).title("Rema 1000"));
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(rema,20f));

    }

    public void changeMapType(View view) {
        switch (view.getId()) {
            case R.id.normal:
                mMap.setMapType(GoogleMap.MAP_TYPE_NORMAL);
                break;
            case R.id.satellite:
                mMap.setMapType(GoogleMap.MAP_TYPE_SATELLITE);
                break;
            case R.id.hybrid:
                mMap.setMapType(GoogleMap.MAP_TYPE_HYBRID);
                break;
        }
    }
}

