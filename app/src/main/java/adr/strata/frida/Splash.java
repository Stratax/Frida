package adr.strata.frida;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;

public class Splash extends AppCompatActivity {
    private final int delay = 4000;

    @Override
    protected void  onCreate(Bundle b1){
        super.onCreate(b1);
        setContentView(R.layout.splasher);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(Splash.this,main.class);
                startActivity(intent);
                finish();
            }
        },delay);
    }


}
