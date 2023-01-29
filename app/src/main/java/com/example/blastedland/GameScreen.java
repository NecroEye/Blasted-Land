package com.example.blastedland;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Typeface;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.blastedland.kingdom.places.Square;

public class GameScreen extends AppCompatActivity {

    public TextView gameText, popupText;
    public ImageView gameImage, healthImg, popupImage;
    public Button button1, button2, button3, button4, popupButton;
    private Story story;
    public TextView healthTx, moneyTx, anvilTx, keyTx, reincarnationTx;
    public static MediaPlayer maingamesong;
    private LinearLayout layout;
    private View popUpView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_screen);

        maingamesong = MediaPlayer.create(this, R.raw.ancient);
        maingamesong.setLooping(true);
        maingamesong.start();

        layout = findViewById(R.id.linearLayout);

        LayoutInflater inflater = (LayoutInflater) getSystemService(LAYOUT_INFLATER_SERVICE);
        popUpView = inflater.inflate(R.layout.gamepopup, null);

        popupText = popUpView.findViewById(R.id.popupText);
        popupImage = popUpView.findViewById(R.id.popupImage);
        popupButton = popUpView.findViewById(R.id.popupButton);

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

        popupImage.setImageResource(R.drawable.necromancer);
        popupText.setText("You have been dead for unknown time, a rotten magic broke it. Right now you are once alive, don't remember anything and lost in this cursed land");

        createPopUpWindow();

    }

    @Override
    protected void onPause() {
        super.onPause();

        maingamesong.pause();

    }


    @Override
    public void onBackPressed() {

        Intent screen = new Intent(this, TitleScreen.class);

        new AlertDialog.Builder(this).setMessage("Are you sure you want to leave current game?")
                .setCancelable(false)
                .setNegativeButton("No", (dialogInterface, i) -> {

                }).setPositiveButton("Yes", (dialogInterface, i) -> {

                    startActivity(screen);
                    maingamesong.stop();
                    finish();
                    overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right);

                }).show();
    }

    public void button1(View v) {

        story.selectPosition(story.nextPosition1);
        animateAllButtons();
        animateImage();
        animateText();


    }

    public void button2(View v) {
        story.selectPosition(story.nextPosition2);
        animateAllButtons();
        animateImage();
        animateText();


    }

    public void button3(View v) {
        story.selectPosition(story.nextPosition3);
        animateAllButtons();
        animateImage();
        animateText();


    }

    public void button4(View v) {
        story.selectPosition(story.nextPosition4);
        animateAllButtons();
        animateImage();
        animateText();

    }


    private void animateAllButtons() {

        Animation moveAni = AnimationUtils.loadAnimation(this, R.anim.movebutton);
        button1.startAnimation(moveAni);
        button2.startAnimation(moveAni);
        button3.startAnimation(moveAni);
        button4.startAnimation(moveAni);

    }

    private void animateImage() {
        Animation fade = AnimationUtils.loadAnimation(this, R.anim.fade);
        gameImage.startAnimation(fade);

    }

    private void animateText() {
        Animation zoom_fader = AnimationUtils.loadAnimation(this, R.anim.zoomfade);
        gameText.startAnimation(zoom_fader);
    }

    public void createPopUpWindow() {


        int width = ViewGroup.LayoutParams.MATCH_PARENT;
        int height = ViewGroup.LayoutParams.WRAP_CONTENT;
        boolean focusable = true;

        PopupWindow popupWindow = new PopupWindow(popUpView, width, height, focusable);
        layout.post(() -> popupWindow.showAtLocation(layout, Gravity.CENTER, 0, 0));

        popupButton.setOnClickListener(view -> popupWindow.dismiss());

    }


}