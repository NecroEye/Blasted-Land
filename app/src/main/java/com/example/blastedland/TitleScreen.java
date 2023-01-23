package com.example.blastedland;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class TitleScreen extends AppCompatActivity {


    private ImageView titleImage;
    private TextView screenTitle, version;
    private MediaPlayer player;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_title_screen);


        titleImage = findViewById(R.id.titleImageView);
        screenTitle = findViewById(R.id.titleTextView);
        version = findViewById(R.id.versionTitle);

        player = MediaPlayer.create(this, R.raw.mainsong);
        player.setLooping(true);
        player.start();


    }


    @Override
    protected void onResume() {
        super.onResume();


        //The song will be added
    }

    public void toGameScreen(View v) {

        Intent gameScreen = new Intent(this, GameScreen.class);
        player.stop();
        startActivity(gameScreen);

    }

    public void credits(View v) {

        Toast.makeText(this, "Developed by Muratcan Gözüm", Toast.LENGTH_LONG).show();

    }


}