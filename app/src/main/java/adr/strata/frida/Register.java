package adr.strata.frida;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class Register extends AppCompatActivity {
    Button next;
    @Override
    protected void onCreate(Bundle savedInstances){
        super.onCreate(savedInstances);
        setContentView(R.layout.register);
        next = (Button)this.findViewById(R.id.Register_Next1);
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent k = new Intent(Register.this,Register2.class);
                startActivity(k);
            }
        });
    }

}
