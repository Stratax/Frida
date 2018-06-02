package adr.strata.frida;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import adr.strata.frida.actores.Usuario;

public class Register3 extends AppCompatActivity implements View.OnClickListener{
    private Button registrar;
    private EditText correo, password1, password2;
    private Usuario usuarioAuxiliar;
    private ArrayList<Usuario> lista;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.register3);

        //Acarreo de datos desde el Bundle
        Bundle d = getIntent().getExtras();
        usuarioAuxiliar = (Usuario)d.get("data");
        //////////////////////////////////

        initComponents();
    }

    private void initComponents(){
        registrar = (Button)this.findViewById(R.id.Register_Finish);
        registrar.setOnClickListener(this);

        correo = (EditText)this.findViewById(R.id.Register_Email);
        password1 = (EditText)this.findViewById(R.id.Register_Password);
        password2 = (EditText)this.findViewById(R.id.Register_PasswordConfirm);
        try{
            FileInputStream fis = openFileInput("Registro");
            ObjectInputStream ois = new ObjectInputStream(fis);
            lista = (ArrayList<Usuario>)ois.readObject();
            ois.close();
        }catch (Exception e){
            Log.println(Log.DEBUG,"--------------->","Error en FIS");
            e.printStackTrace();
            lista = new ArrayList<>();
        }
    }

    @Override
    public  void onClick(View v){

        //TODO Obligar a una contraseña segura
        //TODO Validar datos

        if(password1.getText().toString().equals(password2.getText().toString())){
            usuarioAuxiliar.setContrasenia(password1.getText().toString());
            usuarioAuxiliar.setEmail(correo.getText().toString());
            lista.add(usuarioAuxiliar);
            try{
                FileOutputStream fos = openFileOutput("Registro", Context.MODE_PRIVATE);
                ObjectOutputStream oos = new ObjectOutputStream(fos);
                oos.writeObject(lista);
                oos.close();
            }catch (Exception e){
                Log.println(Log.DEBUG,"--------------->","Error en FOS");
                e.printStackTrace();
            }
            Toast.makeText(this,"Registro completo", Toast.LENGTH_SHORT).show();
            Intent i = new Intent(this,main.class);
            startActivity(i);
            finish();
        }else{
            Toast.makeText(this,"Contraseña no coincide", Toast.LENGTH_SHORT).show();
        }

    }

}
