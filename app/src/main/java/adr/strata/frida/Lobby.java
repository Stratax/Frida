package adr.strata.frida;

import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import adr.strata.frida.actores.Usuario;

public class Lobby extends AppCompatActivity implements View.OnClickListener{
    private ImageView a, b, c,g ,e ,f,h,j,k;
    private Usuario user; //Clase del usuario
    private int counter = 0;


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
        c = this.findViewById(R.id.logo);
        g = this.findViewById(R.id.SinSismo);
        e = this.findViewById(R.id.SismoBajo);
        f = this.findViewById(R.id.SismoMedio);
        h = this.findViewById(R.id.SinContacto);
        j = this.findViewById(R.id.btn_addContact);
        k = this.findViewById(R.id.btn_infoContacto);

        a.setOnClickListener(this);
        b.setOnClickListener(this);
        c.setOnClickListener(this);
        j.setOnClickListener(this);
        k.setOnClickListener(this);

        if(user.getContacts().size()!=0){
            h.setVisibility(View.INVISIBLE);
        }
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
            case R.id.logo:
                counter++;
                if(counter == 4) {
                    g.setVisibility(View.VISIBLE);
                    e.setVisibility(View.INVISIBLE);
                    f.setVisibility(View.INVISIBLE);
                    counter = 0;
                }else if(counter == 1){
                    g.setVisibility(View.INVISIBLE);
                    e.setVisibility(View.VISIBLE);
                    f.setVisibility(View.INVISIBLE);
                }else if(counter == 2){
                    g.setVisibility(View.INVISIBLE);
                    e.setVisibility(View.INVISIBLE);
                    f.setVisibility(View.VISIBLE);
                }else if(counter == 3){
                    g.setVisibility(View.INVISIBLE);
                    e.setVisibility(View.INVISIBLE);
                    f.setVisibility(View.INVISIBLE);
                }
                break;
            case R.id.btn_addContact:
                Intent intentAddContact = new Intent(this,AddContact.class);
                intentAddContact.putExtra("Usuario",user);
                startActivity(intentAddContact);
                finish();
                break;
            case  R.id.btn_infoContacto:
                Intent intentInfoUser = new Intent(this,InfoUser.class);
                intentInfoUser.putExtra("Usuario",user);
                startActivity(intentInfoUser);

                break;
        }
    }

    @Override
    public void onBackPressed() {
        finish();
    }
}
