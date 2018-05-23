package adr.strata.frida;

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
                k.setText("You've clicked");
                break;
            case R.id.Login_Recovery:
                k.setText("Forgot your password?");
                break;
            case R.id.Login_Button:
                a.setBackgroundColor(Color.RED);
                break;
        }
    }
}
