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
}