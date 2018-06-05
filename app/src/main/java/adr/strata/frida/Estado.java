package adr.strata.frida;

import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.telephony.SmsManager;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;
import android.Manifest;
import android.content.Context;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationManager;
import android.support.v4.app.ActivityCompat;
import android.widget.Toast;

public class Estado extends AppCompatActivity implements View.OnClickListener,
        ActivityCompat.OnRequestPermissionsResultCallback{

    private ImageButton a, b;
    private LocationManager locManager;
    private Location loc;
    private String longit,latit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.estado);

        a = this.findViewById(R.id.btn_aux);
        b = this.findViewById(R.id.btn_bien);

        RecuperarLocalizacion();

        a.setOnClickListener(this);
        b.setOnClickListener(this);
    }

    public void RecuperarLocalizacion(){
        ActivityCompat.requestPermissions(Estado.this,new String[]{Manifest.permission.ACCESS_FINE_LOCATION}, 1);

        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            Toast.makeText(this,"Verifica que tengas los permisos requeridos", Toast.LENGTH_SHORT).show();
            return;
        }else{
            locManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
            loc = locManager.getLastKnownLocation(LocationManager.GPS_PROVIDER);
        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_aux:
                longit = String.valueOf(loc.getLongitude());
                latit = String.valueOf(loc.getLatitude());
                enviarMensajeAux("5533130065","Adrián López",longit,latit);
            break;

            case R.id.btn_bien:
                enviarMensajeBien("5533130065","Adrián López");
            break;
        }
    }

    public void enviarMensajeAux(String numero, String nombre, String longitud, String latitud){
        String datosDelMensaje = "Soy "+nombre+"\n Necesito ayuda, estoy en: "+latitud+", "+longitud;
        try{
            int permissionCheck = ContextCompat.checkSelfPermission(this, Manifest.permission.SEND_SMS);
            if(permissionCheck != PackageManager.PERMISSION_GRANTED){
                Toast.makeText(getApplicationContext(),"No se tiene permiso para enviar SMS",
                        Toast.LENGTH_LONG).show();
                ActivityCompat.requestPermissions(this,new String[]{Manifest.permission.SEND_SMS},225);
            }else{
                Log.i("Mensaje","Se tienen los permisos");
            }
            SmsManager sms = SmsManager.getDefault();
            sms.sendTextMessage(numero,null,datosDelMensaje,null,null);
            Toast.makeText(getApplicationContext(),"Mensaje enviado",Toast.LENGTH_SHORT).show();
        }catch (Exception e){
            Toast.makeText(getApplicationContext(),"Mensaje no enviado",Toast.LENGTH_SHORT).show();
            e.printStackTrace();
        }
    }

    public void enviarMensajeBien(String numero, String nombre){
        String datosDelMensaje = "Soy "+nombre+". Me encuentro bien después del sismo.";
        try{
            int permissionCheck = ContextCompat.checkSelfPermission(this, Manifest.permission.SEND_SMS);
            if(permissionCheck != PackageManager.PERMISSION_GRANTED){
                Toast.makeText(getApplicationContext(),"No se tiene permiso para enviar SMS",
                        Toast.LENGTH_LONG).show();
                ActivityCompat.requestPermissions(this,new String[]{Manifest.permission.SEND_SMS},225);
            }else{
                Log.i("Mensaje","Se tienen los permisos");
            }
            SmsManager sms = SmsManager.getDefault();
            sms.sendTextMessage(numero,null,datosDelMensaje,null,null);
            Toast.makeText(getApplicationContext(),"Mensaje enviado",Toast.LENGTH_SHORT).show();
        }catch (Exception e){
            Toast.makeText(getApplicationContext(),"Mensaje no enviado",Toast.LENGTH_SHORT).show();
            e.printStackTrace();
        }
    }
}
