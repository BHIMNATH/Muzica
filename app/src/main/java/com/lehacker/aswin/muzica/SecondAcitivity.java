package com.lehacker.aswin.muzica;

import android.content.Intent;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class SecondAcitivity extends AppCompatActivity {
    private MediaPlayer mPlayer;
    private int currentSong=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second_acitivity);
        Intent intent=this.getIntent();
        int number= intent.getIntExtra("BUTTON NUMBER", 1);
        TextView tv=(TextView)findViewById(R.id.textView);
        tv.setText(String.valueOf(number));
        switch (number){
            case 1:mPlayer=MediaPlayer.create(SecondAcitivity.this,R.raw.song1);currentSong=1;break;
            case 2:mPlayer=MediaPlayer.create(SecondAcitivity.this,R.raw.song2);currentSong=2;break;
            case 3:mPlayer=MediaPlayer.create(SecondAcitivity.this,R.raw.song3);currentSong=3;break;
            case 4:mPlayer=MediaPlayer.create(SecondAcitivity.this,R.raw.song4);currentSong=4;break;
            default:mPlayer=MediaPlayer.create(SecondAcitivity.this,R.raw.song1);currentSong=R.raw.song1;
        }
        mPlayer.start();
        createEListeners();
    }

    public void createEListeners() {
        Button b1 = (Button) findViewById(R.id.button6);
        Button b2 = (Button) findViewById(R.id.button5);
        Button b3 = (Button) findViewById(R.id.button7);
        Button b4 = (Button) findViewById(R.id.button8);

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onPause();
                //b2.setVisibility(View.INVISIBLE);
            }
        });
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onResume();
                //b1.setVisibility(View.INVISIBLE);
            }
        });
        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onStop();
                //b1.setVisibility(View.VISIBLE);
                //b2.setVisibility(View.VISIBLE);
            }
        });
        b4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent returnBtn = new Intent("android.intent.action.MAIN");
                startActivity(returnBtn);
            }
        });
    }

    @Override
    protected void onPause() {
        super.onPause();
            if(mPlayer.isPlaying())
                mPlayer.pause();
    }
    
    @Override
    protected void onResume() {
        super.onResume();
        if(mPlayer==null)
            mPlayer=MediaPlayer.create(SecondAcitivity.this,currentSong);
        mPlayer.start();
    }

}