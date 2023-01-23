package com.example.blastedland;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Typeface;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.blastedland.kingdom.places.Square;

public class GameScreen extends AppCompatActivity {

    public TextView gameText;
    public ImageView gameImage, healthImg;
    public Button button1, button2, button3, button4;
    private Story story;
    public TextView healthTx, moneyTx, anvilTx, keyTx, reincarnationTx;
    private MediaPlayer player;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_screen);

        player = MediaPlayer.create(this, R.raw.gamesong);
        player.setLooping(true);
        player.start();



        gameText = findViewById(R.id.gameTextView);
        healthImg = findViewById(R.id.HealthImg);
        healthTx = findViewById(R.id.health);
        moneyTx = findViewById(R.id.money);
        anvilTx = findViewById(R.id.Anvil);
        keyTx = findViewById(R.id.Key);
        reincarnationTx = findViewById(R.id.Reincarnation);
        gameImage = findViewById(R.id.gameImageView);
        button1 = findViewById(R.id.choiceButton1);
        button2 = findViewById(R.id.choiceButton2);
        button3 = findViewById(R.id.choiceButton3);
        button4 = findViewById(R.id.choiceButton4);

        this.story = new Story(this);

        button1.setTransformationMethod(null);
        button2.setTransformationMethod(null);
        button3.setTransformationMethod(null);
        button4.setTransformationMethod(null);

        story.startingPoint();


       /*
       Typeface tf = Typeface.createFromAsset(getAssets(),"res/font/unt");

         gameText.setTypeface(tf);

        */

    }


    @Override
    public void onBackPressed() {

        Intent screen = new Intent(this, TitleScreen.class);

        new AlertDialog.Builder(this).setMessage("Are you sure you want to leave current game?")
                .setCancelable(false)
                .setNegativeButton("No", (dialogInterface, i) -> {

                }).setPositiveButton("Yes", (dialogInterface, i) -> {

                    startActivity(screen);
                    player.stop();
                    finish();

                }).show();
    }

    public void button1(View v) {

        story.selectPosition(story.nextPosition1);

    }

    public void button2(View v) {
        story.selectPosition(story.nextPosition2);

    }

    public void button3(View v) {
        story.selectPosition(story.nextPosition3);

    }

    public void button4(View v) {
        story.selectPosition(story.nextPosition4);

    }


}