package com.edinsson.mapsapp;

import androidx.fragment.app.FragmentActivity;

import android.os.Bundle;
import android.widget.Toast;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

import java.util.ArrayList;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback, GoogleMap.OnMarkerClickListener {

    private GoogleMap mMap;
    private ArrayList<Marker> googleMaps = new ArrayList<>();
    private String location;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
        Bundle info = this.getIntent().getExtras();
        location = info.getString("location");
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
        LatLng valleDeReyes = new LatLng(25.740189, 32.6019692);
        googleMaps.add(googleMap.addMarker(new MarkerOptions().position(valleDeReyes).title("Valle de Reyes")
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.god))));

        LatLng toreEiffel = new LatLng(48.8582602, 2.2944991);
        googleMaps.add(googleMap.addMarker(new MarkerOptions().position(toreEiffel).title("Torre Eiffel")
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.paris))));

        LatLng vaticano = new LatLng(41.9038149, 41.9038149);
        googleMaps.add(googleMap.addMarker(new MarkerOptions().position(vaticano).title("Vaticano")
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.monument))));

        LatLng machuPichu = new LatLng(24.0111285, -104.6539106);
        googleMaps.add(googleMap.addMarker(new MarkerOptions().position(machuPichu).title("Machu Pichu")
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.peru))));

        LatLng hollywood = new LatLng(34.0980031, -118.329523);
        googleMaps.add(googleMap.addMarker(new MarkerOptions().position(hollywood).title("Hollywwod")
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.oscar))));

        switch (location){
            case "valleDeReyes":
                mMap.moveCamera(CameraUpdateFactory.newLatLng(valleDeReyes));
                break;
            case "vaticano":
                mMap.moveCamera(CameraUpdateFactory.newLatLng(vaticano));
                break;
            case "torreEiffel":
                mMap.moveCamera(CameraUpdateFactory.newLatLng(toreEiffel));
                break;
            case "hollywood":
                mMap.moveCamera(CameraUpdateFactory.newLatLng(hollywood));
                break;
            default: Toast.makeText(this, "Algo falló", Toast.LENGTH_LONG).show();
        }

        googleMap.setOnMarkerClickListener(this);
    }

    @Override
    public boolean onMarkerClick(Marker marker) {

        if(marker.equals(googleMaps.get(0)))
            Toast.makeText(this, "Acá se encuentre Tutankamón", Toast.LENGTH_LONG).show();
        if(marker.equals(googleMaps.get(1)))
            Toast.makeText(this, "El lugar del amor", Toast.LENGTH_LONG).show();
        if(marker.equals(googleMaps.get(2)))
            Toast.makeText(this, "Sede mundial de la religión catolica", Toast.LENGTH_LONG).show();
        if(marker.equals(googleMaps.get(3)))
            Toast.makeText(this, "Antiguas ruinas en Perú", Toast.LENGTH_LONG).show();
        if(marker.equals(googleMaps.get(4)))
            Toast.makeText(this, "Bienvenido a las estrellas", Toast.LENGTH_LONG).show();
        return false;
    }
}