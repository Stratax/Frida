package adr.strata.frida;

import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import adr.strata.frida.actores.Usuario;

public class Lobby extends AppCompatActivity implements View.OnClickListener{
    private ImageButton a, b;

    private Usuario user; //Clase del usuario


    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.loby);

        //----------------------------------------------------------------------------------------------------------------------------------------//
        //////////////////////////// Aquí paso los datos de usuario que inicia sesión. Checar la clase actores.Usuario//////////////////////////////
            Bundle d = getIntent().getExtras();
            user = (Usuario) d.get("Usuario");
            Toast.makeText(this,user.getNombre() + user.getApellido_paterno() + user.getApellido_materno(), Toast.LENGTH_SHORT).show();
        ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        //_______________________________________________________________________________________________________________________________________//

        a = this.findViewById(R.id.btn_estado);
        b = this.findViewById(R.id.btn_danio);

        a.setOnClickListener(this);
        b.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_danio:
                Intent danio = new Intent(this,Danio.class);
                startActivity(danio);
                break;
            case R.id.btn_estado:
                Intent estado = new Intent(this,Estado.class);
                startActivity(estado);
                break;
        }
    }
}
