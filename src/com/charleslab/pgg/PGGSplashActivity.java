package com.charleslab.pgg;

import android.os.Bundle;
import android.os.Handler;
import android.app.Activity;
import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.view.Menu;
import android.widget.ImageView;

public class PGGSplashActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash);  
     // finish splash and start the login screen.
        new Handler().postDelayed(new Runnable() {
            public void run() {
            	finish();
              Intent i = new Intent();
              i.setClass(PGGSplashActivity.this,
            		  PGGLoginActivity.class);
              startActivity(i);
            }
        }, 5000);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.pggsplash, menu);
        return true;
    }
    
}
