package adr.strata.frida;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.EditText;
import android.widget.TextView;

import adr.strata.frida.actores.Usuario;

public class InfoUser extends AppCompatActivity {

    private Usuario user;
    private TextView nombre, apellidoP, apellidoM, edad, telefono, tpoSangre, calle, municipio, cp;

    @Override
    public void onCreate(Bundle b){
        super.onCreate(b);
        setContentView(R.layout.info_user);

        Bundle d = getIntent().getExtras();
        user = (Usuario)d.get("Usuario");

        initComponents();


    }

    private void initComponents(){
        nombre = this.findViewById(R.id.show_nombre);
        nombre.setText("Nombre: " + user.getNombre());

        apellidoP = this.findViewById(R.id.show_apellidoP);
        apellidoP.setText("Apellido paterno: " + user.getApellido_paterno());

        apellidoM = this.findViewById(R.id.show_apellidoM);
        apellidoM.setText("Apellido materno: " + user.getApellido_materno());

        edad = this.findViewById(R.id.show_Edad);
        edad.setText("Edad: " + user.getEdad());

        telefono = this.findViewById(R.id.show_Telefono);
        telefono.setText("Teléfono: " + user.getTelefono());

        tpoSangre = this.findViewById(R.id.show_tpoSangre);
        tpoSangre.setText("Tipo de sangre: : " + user.getTpo_sangre());

        calle = this.findViewById(R.id.show_calle);
        calle.setText(user.getCalle() + " No." + user.getCasa_no());

        municipio = this.findViewById(R.id.show_municipio);
        municipio.setText(user.getColonia() + ", " + user.getDelegacion() + " " + user.getEstado());

        cp = this.findViewById(R.id.show_cp);
        cp.setText("C.P.: " + user.getCp());
    }
}
