package adr.strata.frida;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class main extends AppCompatActivity implements View.OnClickListener{

    private TextView signUp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        signUp = (TextView) this.findViewById(R.id.Login_Register);

        signUp.setOnClickListener(this);
    }

    @Override
    public void onClick(View v){
        TextView register = (TextView)this.findViewById(R.id.Login_Recovery);
        register.setText("You've clicked");
    }
}
