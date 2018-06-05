package adr.strata.frida;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.util.ArrayList;

import adr.strata.frida.actores.Usuario;

public class main extends AppCompatActivity implements View.OnClickListener{

    private TextView signUp,k;
    private Button iniciar_sesion;
    private EditText password,email;
    private Usuario readUsuario;
    private ArrayList<Usuario> lista;
    private ImageView frida;
    private int counter = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initComponents();

    }

    private void initComponents(){
        signUp = (TextView) this.findViewById(R.id.Login_Register);
        signUp.setOnClickListener(this);
        k = (TextView)this.findViewById(R.id.Login_Recovery);
        k.setOnClickListener(this);
        iniciar_sesion = (Button)this.findViewById(R.id.Login_Button);
        iniciar_sesion.setOnClickListener(this);

        email = (EditText)this.findViewById(R.id.Login_User);
        password = (EditText)this.findViewById(R.id.Login_Password);
        frida = (ImageView)this.findViewById(R.id.imagenFrida);
        frida.setOnClickListener(this);

        try{
            FileInputStream fis = openFileInput("Registro");
            ObjectInputStream ois = new ObjectInputStream(fis);
            lista = (ArrayList<Usuario>)ois.readObject();
            ois.close();
        }catch (Exception e){
            Toast.makeText(this,"No hay Registro!!!",Toast.LENGTH_SHORT).show();
            Log.println(Log.DEBUG,"--------------->","Error en FIS");
            e.printStackTrace();
            lista = new ArrayList<>();
        }

   }
    @Override
    public void onClick(View v){
        switch (v.getId()){
            case R.id.Login_Register:
                Intent iRegister = new Intent(this,Register.class);
                startActivity(iRegister);
                break;
            case R.id.Login_Recovery:
                k.setText("Are u stupid?"); //TODO Hay que cambiar esto XD
                break;
            case R.id.Login_Button:
                if(validatePassword()){
                    Intent iLobby = new Intent(this,Lobby.class);
                    iLobby.putExtra("Usuario",readUsuario);
                    startActivity(iLobby);
                    finish();
                }else{
                    Toast.makeText(this,"Correo o contraseña no validos",Toast.LENGTH_LONG).show();
                }
                break;
            case R.id.imagenFrida:
                counter++;
                if(counter == 5){
                    Toast.makeText(this,"Que onda George", Toast.LENGTH_SHORT).show();
                }
                if(counter == 10){
                    Toast.makeText(this,"Gibran alias crotolamo", Toast.LENGTH_SHORT).show();
                    counter = 0;
                }
                break;
        }
    }

    public boolean validatePassword(){

        String correo = email.getText().toString();
        String pass = password.getText().toString();
        for(int i = 0;i < lista.size(); i ++){
            if(lista.get(i).getEmail().equals(correo)){
                if(lista.get(i).getContrasenia().equals(pass)){
                    readUsuario = lista.get(i);
                    return true;
                }else
                    break;
            }
        }
        return false;
    }
}
