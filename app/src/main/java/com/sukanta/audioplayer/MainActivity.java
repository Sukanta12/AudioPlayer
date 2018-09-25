package com.sukanta.audioplayer;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    Button btnplay,btnpause,btnstop;
    boolean isplaying=false;
    MediaPlayer player;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnplay=findViewById(R.id.btn_play);
        btnpause=findViewById(R.id.btn_pause);
        btnstop=findViewById(R.id.btn_stop);
        player=MediaPlayer.create(MainActivity.this,R.raw.audio);
        btnplay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(isplaying==false)
                {
                    player.start();
                    isplaying=true;
                }
            }
        });
        btnpause.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(isplaying==true)
                {
                    player.pause();
                    isplaying=false;
                }
            }
        });
        btnstop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(isplaying==true)
                {
                    player.stop();
                    isplaying=false;
                }
                MainActivity.this.finish(); //for exit from app
            }
        });


    }

    @Override
    protected void onPause() {
        player.pause();
        isplaying=false;
        super.onPause();
    }
}
