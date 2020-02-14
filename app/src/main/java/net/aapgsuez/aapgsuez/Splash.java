package net.aapgsuez.aapgsuez;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;

public class Splash extends AppCompatActivity {

    final int SPLASH_DISPLAY_LENGTH = 2000;

    @Override
    protected void onStart() {
        super.onStart();

    }

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash);
        Bundle bundle = getIntent().getExtras();
        if (bundle != null && bundle.get("url") != null) {
            //here can get notification message
            String url = bundle.get("url").toString();
            Uri uri = Uri.parse(url);
            Intent intent = new Intent(Intent.ACTION_VIEW, uri);
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            startActivity(intent);
            finish();
        }else {
            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    Intent mainIntent = new Intent(Splash.this, MainActivity.class);
                    Splash.this.startActivity(mainIntent);
                    Splash.this.finish();
                }
            }, SPLASH_DISPLAY_LENGTH);

        }

}
        /*
        Handler h = new Handler();
        h.postDelayed(new Runnable() {
            @Override
            public void run() {
                ConnectionDetector det = new ConnectionDetector(Splash.this);
                if (det.isConnectingToInternet()) {
                    startActivity(new Intent(Splash.this, MainActivity.class));
                } else {
                    Toast.makeText(Splash.this, "Please check your internet connection", Toast.LENGTH_LONG).show();
                }
                finish();
            }
        }, 2000);
        */
    }
