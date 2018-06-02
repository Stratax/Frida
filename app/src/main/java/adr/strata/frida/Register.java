package adr.strata.frida;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import adr.strata.frida.actores.Usuario;

public class Register extends AppCompatActivity implements View.OnClickListener{

    private Button next;
    private EditText nombre, apellidoP, apellidoM, telefono, edad, tpoSangre;
    private Usuario usuarioAuxiliar;

    @Override
    protected void onCreate(Bundle savedInstances){
        super.onCreate(savedInstances);
        setContentView(R.layout.register);
        initComponents();

    }

    private void initComponents(){
        next = (Button)this.findViewById(R.id.Register_Next);
        next.setOnClickListener(this);

        nombre = (EditText)this.findViewById(R.id.Register_Name);
        apellidoP = (EditText)this.findViewById(R.id.Register_ApellidoP);
        apellidoM = (EditText)this.findViewById(R.id.Register_ApellidoM);
        telefono = (EditText)this.findViewById(R.id.Register_Phone);
        edad = (EditText)this.findViewById(R.id.Register_Age);
        tpoSangre = (EditText)this.findViewById(R.id.Register_BloodType);
        usuarioAuxiliar= new Usuario();
    }


    @Override
    public void onClick(View v) {
        //TODO Validar datos

        usuarioAuxiliar.setNombre(nombre.getText().toString());
        usuarioAuxiliar.setApellido_paterno(apellidoP.getText().toString());
        usuarioAuxiliar.setApellido_materno(apellidoM.getText().toString());
        usuarioAuxiliar.setTelefono(telefono.getText().toString());
        usuarioAuxiliar.setEdad(Integer.parseInt(edad.getText().toString()));
        usuarioAuxiliar.setTpo_sangre(tpoSangre.getText().toString());

        Intent i = new Intent(Register.this,Register2.class);
        i.putExtra("data",usuarioAuxiliar);
        startActivity(i);
        finish();
    }

}
