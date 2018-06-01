package adr.strata.frida;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Lobby extends AppCompatActivity implements View.OnClickListener{
    private Button a, b;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.loby);
        a = (Button)this.findViewById(R.id.btn_estado);
        b = (Button)this.findViewById(R.id.btn_danio);

        a.setOnClickListener(this);
        b.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_estado:
                Intent danio = new Intent(this,Danio.class);
                startActivity(danio);
                break;
            case R.id.btn_danio:
                Intent estado = new Intent(this,Estado.class);
                startActivity(estado);
                break;
        }
    }
}
