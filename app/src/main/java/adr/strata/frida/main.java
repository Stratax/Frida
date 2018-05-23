package adr.strata.frida;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class main extends AppCompatActivity implements View.OnClickListener{

    private TextView signUp,k;
    private Button a;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        signUp = (TextView) this.findViewById(R.id.Login_Register);
        k = (TextView)this.findViewById(R.id.Login_Recovery);
        a = (Button)this.findViewById(R.id.Login_Button);

        k.setOnClickListener(this);
        a.setOnClickListener(this);
        signUp.setOnClickListener(this);
    }

    @Override
    public void onClick(View v){
        switch (v.getId()){
            case R.id.Login_Register:
                Intent iRegister = new Intent(this,Register.class);
                startActivity(iRegister);
                break;
            case R.id.Login_Recovery:
                k.setText("Forgot your password?");
                break;
            case R.id.Login_Button:
                Intent iLobby = new Intent(this,Lobby.class);
                startActivity(iLobby);
                break;
        }
    }
}
