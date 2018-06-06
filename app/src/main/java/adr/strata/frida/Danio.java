package adr.strata.frida;

import android.Manifest;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.location.LocationManager;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.view.WindowManager;
import android.view.inputmethod.EditorInfo;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GoogleApiAvailability;
import com.google.android.gms.dynamic.SupportFragmentWrapper;
import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Danio extends AppCompatActivity{
    private LocationManager locManager;
    private Location loc;
    private GoogleMap mapa;
    private static final String TAG = "Danio";
    private EditText buscar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.danio);
        buscar = findViewById(R.id.buscar);
        
        if(servicios()){
            initMapa();
        }
    }

    private void initMapa() {
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map);
        mapFragment.getMapAsync(new OnMapReadyCallback() {
            @Override
            public void onMapReady(GoogleMap googleMap) {
                Toast.makeText(getApplicationContext(),"Esta listo",Toast.LENGTH_SHORT).show();
                mapa = googleMap;
                RecuperarLocalizacion();
                if(ActivityCompat.checkSelfPermission(getApplicationContext(),Manifest.permission.ACCESS_FINE_LOCATION)!=
                        PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(getApplicationContext(),Manifest
                .permission.ACCESS_COARSE_LOCATION)!=PackageManager.PERMISSION_GRANTED){
                    return;
                }
                mapa.setMyLocationEnabled(true);
                init();
            }
        });
    }

    private void init(){
        buscar.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                if(actionId==EditorInfo.IME_ACTION_SEARCH
                    || actionId==EditorInfo.IME_ACTION_DONE
                    || event.getAction()==KeyEvent.ACTION_DOWN
                    || event.getAction()==KeyEvent.KEYCODE_ENTER){
                    geoLocalizar();
                }
                ocultarTeclado();
                return false;
            }
        });
    }

    private void geoLocalizar(){

        String cadenaBuscar= buscar.getText().toString();
        Geocoder geocoder = new Geocoder(Danio.this);
        List<Address> list = new ArrayList<>();

        try{
            list = geocoder.getFromLocationName(cadenaBuscar,1);
        }catch (IOException e){
            e.printStackTrace();
        }


        if(list.size()>0){
            Address address = list.get(0);
            Log.d(TAG,address.toString());

            moverCamara(new LatLng(address.getLatitude(),address.getLongitude()),15f,address.getAddressLine(0));
        }
    }

    public boolean servicios(){
        Log.d(TAG,"Google services");
        int disponible = GoogleApiAvailability.getInstance().isGooglePlayServicesAvailable(Danio.this);

        if(disponible == ConnectionResult.SUCCESS){
            Log.d(TAG,"Google Services está funcionando.");
            return true;
        }else{
            Toast.makeText(this,"No se puede hacer la consulta",Toast.LENGTH_SHORT).show();
        }
        return false;
    }

    public void RecuperarLocalizacion(){
        try {
            ActivityCompat.requestPermissions(Danio.this, new String[]{Manifest.permission.ACCESS_FINE_LOCATION}, 1);

            if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
                Toast.makeText(this, "Verifica que tengas los permisos requeridos", Toast.LENGTH_SHORT).show();
                return;
            } else {
                locManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
                loc = locManager.getLastKnownLocation(LocationManager.GPS_PROVIDER);
                moverCamara(new LatLng(loc.getLatitude(),loc.getLongitude()),15f,"Mi localizacion");
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    private void moverCamara(LatLng latitud, float zoom,String titulo){
        mapa.moveCamera(CameraUpdateFactory.newLatLngZoom(latitud,zoom));

        if(!titulo.equals("Mi localizacion")){
            MarkerOptions opciones = new MarkerOptions().position(latitud).title(titulo);
            mapa.addMarker(opciones);
        }
        ocultarTeclado();
    }

    private  void ocultarTeclado(){
        this.getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);
    }
}
