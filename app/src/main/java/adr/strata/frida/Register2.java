package adr.strata.frida;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import adr.strata.frida.actores.Usuario;

public class Register2 extends AppCompatActivity implements View.OnClickListener{

    private Button next;
    private EditText calle, noCasa, colonia, municipio, cp, estado;
    private Usuario usuarioAuxiliar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.register2);

        //Acarreo de datos desde el Bundle
            Bundle d = getIntent().getExtras();
            usuarioAuxiliar = (Usuario)d.get("data");
        //////////////////////////////////
        initComponents();


    }

    private void initComponents(){


        next = (android.widget.Button)this.findViewById(R.id.Register_Next);
        next.setOnClickListener(this);

        calle = (EditText)this.findViewById(R.id.Register_Calle);
        noCasa = (EditText)this.findViewById(R.id.Register_NoCasa);
        colonia = (EditText)this.findViewById(R.id.Register_Colonia);
        municipio = (EditText)this.findViewById(R.id.Register_Municipio);
        cp = (EditText)this.findViewById(R.id.Register_CP);
        estado = (EditText)this.findViewById(R.id.Register_Estado);
    }

    @Override
    public void onClick(View v) {

        //TODO validar datos
        //TODO Resolver Ambigüedad entre Delagacion o municipio

        usuarioAuxiliar.setCalle(calle.getText().toString());
        usuarioAuxiliar.setCasa_no(noCasa.getText().toString());
        usuarioAuxiliar.setColonia(colonia.getText().toString());
        usuarioAuxiliar.setDelegacion(municipio.getText().toString());
        usuarioAuxiliar.setCp(cp.getText().toString());
        usuarioAuxiliar.setEstado(estado.getText().toString());


        Intent i = new Intent(Register2.this,Register3.class);
        i.putExtra("data",usuarioAuxiliar);
        startActivity(i);
        finish();
    }

}
