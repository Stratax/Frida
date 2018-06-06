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

import adr.strata.frida.actores.Contacto;
import adr.strata.frida.actores.Usuario;

public class AddContact extends AppCompatActivity implements View.OnClickListener {

    private Button agregar;
    private EditText nombre, apellidoP, apellidoM, telefono,parentesco;
    private ArrayList<Usuario> lista;
    private Contacto c1;
    private Usuario u1;

    @Override
    public void onCreate(Bundle b){
        super.onCreate(b);
        setContentView(R.layout.contacto);

        //----------------------------------------------------------------------------------------------------------------------------------------//
        //////////////////////////// Aquí paso los datos de usuario que inicia sesión. Checar la clase actores.Usuario//////////////////////////////
        Bundle d = getIntent().getExtras();
        u1 = (Usuario) d.get("Usuario");
        ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        //_______________________________________________________________________________________________________________________________________//
        initComponents();

    }

    private void initComponents(){

        nombre = this.findViewById(R.id.Contact_Name);
        apellidoP = this.findViewById(R.id.Contact_ApellidoP);
        apellidoM = this.findViewById(R.id.Contact_ApellidoM);
        telefono = this.findViewById(R.id.Contact_Phone);
        parentesco = this.findViewById(R.id.Contact_Relate);
        agregar = this.findViewById(R.id.Contact_add);
        agregar.setOnClickListener(this);
        c1 = new Contacto();

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
    public void onClick(View v){
        if(u1.getContacts().size() == 3){
            Toast.makeText(this, "Registro de contactos llenos", Toast.LENGTH_SHORT).show();
            Intent intentLobby = new Intent(this,Lobby.class);
            intentLobby.putExtra("Usuario",u1);
            startActivity(intentLobby);
            finish();
        }else{
            c1.setNombre(nombre.getText().toString());
            c1.setApellido_paterno(apellidoP.getText().toString());
            c1.setApellido_materno(apellidoM.getText().toString());
            c1.setTelefono(telefono.getText().toString());
            c1.setParentesco(parentesco.getText().toString());

            u1.agregarContacto(c1);
            for(int i = 0; i<lista.size();i++){
                if(u1.getNombre().equals(lista.get(i).getNombre()) && u1.getContrasenia().equals(lista.get(i).getContrasenia())){
                    lista.remove(i);
                    lista.add(i,u1);
                }
            }
            try{
                FileOutputStream fos = openFileOutput("Registro", Context.MODE_PRIVATE);
                ObjectOutputStream oos = new ObjectOutputStream(fos);
                oos.writeObject(lista);
                oos.close();
            }catch (Exception e){
                Log.println(Log.DEBUG,"--------------->","Error en FOS");
                e.printStackTrace();
            }

            Toast.makeText(this,"Contacto agregado",Toast.LENGTH_SHORT).show();
            Intent intentLobby = new Intent(this,Lobby.class);
            intentLobby.putExtra("Usuario",u1);
            startActivity(intentLobby);
            finish();

        }

    }
}
