package com.example.chefschoice;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.widget.VideoView;

import com.example.chefschoice.Register.MainRegisterScreen;
import com.google.firebase.auth.FirebaseAuth;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);





        VideoView videoView=findViewById(R.id.video);
        String videoPath=new StringBuilder("android.resource://").append(getPackageName())
                .append("/raw/splashmovieb").toString();
        videoView.setVideoPath(videoPath);

        FirebaseAuth firebaseAuth = FirebaseAuth.getInstance();

        videoView.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mediaPlayer) {
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        startActivity(new Intent(MainActivity.this, MainRegisterScreen.class));
                        finish();
                    }
                },1000);
            }
        });
        videoView.start();
    }
}