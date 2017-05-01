package com.example.gokul.myapplication;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;

public class SplashActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        Thread timer =new Thread(){
            public void run(){
                try {
                    sleep(2000);
                    Intent i = new Intent(SplashActivity.this,MainActivity.class);
                    startActivity(i);
                    overridePendingTransition(R.anim.activityfadein,
                            R.anim.splashfadeout);
                } catch (InterruptedException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }


                finally{
                    finish();

                }



            }
        };
        timer.start();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_splash, menu);
        return true;
    }

}
