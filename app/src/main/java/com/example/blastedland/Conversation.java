package com.example.blastedland;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.res.ResourcesCompat;

import android.content.res.ColorStateList;
import android.graphics.Color;
import android.graphics.Typeface;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.blastedland.Npcs.Blacksmith;
import com.example.blastedland.Npcs.Npc;
import com.example.blastedland.Npcs.Priest;
import com.example.blastedland.Npcs.Stranger;
import com.example.blastedland.Npcs.Thief;
import com.example.blastedland.player.UI;

public class Conversation extends AppCompatActivity {


    public ImageView npcImage, LocationImage, popupImage;
    public TextView npcText, npcTextName, popupText;
    public Button heroButton1, heroButton2, heroButton3, heroButton4, popupButton;
    private String specialWord;
    public Blacksmith blacksmith;
    private Npc actions;
    private LinearLayout layout;
    private View popUpView;
    private RelativeLayout layoutpop;
    private MediaPlayer player;
    private UI ui;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_conversation);

        blacksmith = new Blacksmith(this);
        this.ui = UI.getInstance();

        player = MediaPlayer.create(this, R.raw.chatsong);
        player.setLooping(true);
        player.start();

        layout = findViewById(R.id.linearLayout2);

        npcImage = findViewById(R.id.npcImage);
        LocationImage = findViewById(R.id.locationImage);
        npcText = findViewById(R.id.npcText);
        npcTextName = findViewById(R.id.npcName);
        heroButton1 = findViewById(R.id.heroButton1);
        heroButton2 = findViewById(R.id.heroButton2);
        heroButton3 = findViewById(R.id.heroButton3);
        heroButton4 = findViewById(R.id.heroButton4);

        LayoutInflater inflater = (LayoutInflater) getSystemService(LAYOUT_INFLATER_SERVICE);
        popUpView = inflater.inflate(R.layout.gamepopup, null);

        popupImage = popUpView.findViewById(R.id.popupImage);
        popupText = popUpView.findViewById(R.id.popupText);
        popupButton = popUpView.findViewById(R.id.popupButton);
        layoutpop = popUpView.findViewById(R.id.popuplayout);


        String npc = getIntent().getStringExtra("npc");

        switch (npc) {
            case "bob":

                Typeface typeface = ResourcesCompat.getFont(this, R.font.punk);
                npcText.setTypeface(typeface);

                actions = new Blacksmith(this);

                npcImage.setImageResource(R.drawable.elf);
                npcTextName.setText("Blacksmith");
                npcText.setText("Welcome to my gorgeous store!");
                heroButton1.setText("Hey");
                heroButton2.setText("i am looking for job");
                heroButton3.setText("have you any advice?");
                heroButton4.setText("Back");
                LocationImage.setImageResource(R.drawable.blacksmith);
                break;

            case "stranger":

                actions = new Stranger(this);


                if (Stranger.scroll == false) {

                    typeface = ResourcesCompat.getFont(this, R.font.untold);
                    npcText.setTypeface(typeface);

                    popupImage.setImageResource(R.drawable.parchment);
                    popupText.setText("Without the scroll, you can't understand his words.");

                    createPopUpWindow();

                    heroButton1.setVisibility(View.INVISIBLE);
                    heroButton3.setVisibility(View.INVISIBLE);
                    heroButton4.setVisibility(View.INVISIBLE);


                    npcImage.setImageResource(R.drawable.stranger);
                    npcTextName.setText("Stranger");
                    npcText.setText("Do you want something");
                    heroButton1.setText("");
                    heroButton2.setText("Back");
                    heroButton3.setText("");
                    heroButton4.setText("");
                    LocationImage.setImageResource(R.drawable.tavern);
                    break;
                } else {
                    typeface = ResourcesCompat.getFont(this, R.font.punk);
                    npcText.setTypeface(typeface);
                    showAllButtons();

                    npcImage.setImageResource(R.drawable.stranger);
                    npcTextName.setText("Stranger");
                    npcText.setText("Do you want something?");
                    heroButton1.setText("Finally i am able to understand you!");
                    heroButton2.setText("You look like a sorcerer");
                    heroButton3.setText("What is that dress weirdo?");
                    heroButton4.setText("Back");
                    LocationImage.setImageResource(R.drawable.tavern);

                    break;
                }


            case "thief":

                actions = new Thief(this);


                typeface = ResourcesCompat.getFont(this, R.font.punk);
                npcText.setTypeface(typeface);

                if (ui.silver >= 10) {

                    heroButton3.setText("give it some silver (10)");
                    heroButton3.setClickable(true);
                    heroButton3.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#7b7b7b")));

                } else {

                    Animation shake = AnimationUtils.loadAnimation(this, R.anim.shake);
                    heroButton3.setText("give it some silver (10)");
                    heroButton3.setBackgroundTintList(ColorStateList.valueOf(Color.RED));
                    heroButton3.setClickable(false);

                }

                npcImage.setImageResource(R.drawable.assasin);
                npcTextName.setText("Assassin");
                npcText.setText("HeHeHe lookin' for some trouble bastard!");
                heroButton1.setText("N-No, i am just chilling");
                heroButton2.setText("Do you know who i am?");
                heroButton4.setText("Back"); // Run away ile değiştir square atsın direkt
                LocationImage.setImageResource(R.drawable.tavern);
                break;

            case "armorerJob":

                actions = new Blacksmith(this);

                heroButton1.setVisibility(View.INVISIBLE);
                heroButton2.setVisibility(View.INVISIBLE);
                heroButton3.setVisibility(View.INVISIBLE);



                npcImage.setImageResource(R.drawable.elf);
                npcTextName.setText("Blacksmith");
                npcText.setText("I don't have job for you now, come back later.");
                heroButton1.setText("");
                heroButton2.setText("");
                heroButton3.setText("");
                heroButton4.setText("Back");
                LocationImage.setImageResource(R.drawable.blacksmith);
                break;

            case "anton":

                actions = new Priest(this);


                npcImage.setImageResource(R.drawable.priest);
                npcTextName.setText("Priest");
                npcText.setText("The God blesses all of us.");
                heroButton1.setText("");
                heroButton2.setText("");
                heroButton3.setText("");
                heroButton4.setText("Back");
                LocationImage.setImageResource(R.drawable.church);

                heroButton1.setVisibility(View.INVISIBLE);
                heroButton2.setVisibility(View.INVISIBLE);
                heroButton3.setVisibility(View.INVISIBLE);

                break;

            case "annabelle":

                actions = new Priest(this);


                npcImage.setImageResource(R.drawable.witch);
                npcTextName.setText("Witch");
                npcText.setText("Soo, you are looking for some curse or not?.");
                heroButton1.setText("");
                heroButton2.setText("");
                heroButton3.setText("");
                heroButton4.setText("Back");
                LocationImage.setImageResource(R.drawable.hut);

                heroButton1.setVisibility(View.INVISIBLE);
                heroButton2.setVisibility(View.INVISIBLE);
                heroButton3.setVisibility(View.INVISIBLE);

                break;

        }


    }

    @Override
    protected void onPause() {
        super.onPause();
        player.stop();

    }

    public void hButton1(View v) {

        specialWord = heroButton1.getText().toString();
        actions.talking(specialWord);
        animateAllButtons();

    }

    public void hButton2(View v) {

        specialWord = heroButton2.getText().toString();
        actions.talking(specialWord);
        animateAllButtons();

    }

    public void hButton3(View v) {

        specialWord = heroButton3.getText().toString();
        actions.talking(specialWord);
        animateAllButtons();

    }

    public void hButton4(View v) {

        specialWord = heroButton4.getText().toString();
        actions.talking(specialWord);
        Animation moveAni = AnimationUtils.loadAnimation(this, R.anim.movebutton);
        heroButton4.startAnimation(moveAni);


    }

    private void showAllButtons() {

        heroButton1.setVisibility(View.VISIBLE);
        heroButton2.setVisibility(View.VISIBLE);
        heroButton3.setVisibility(View.VISIBLE);
        heroButton4.setVisibility(View.VISIBLE);

    }

    private void animateAllButtons() {

        Animation moveAni = AnimationUtils.loadAnimation(this, R.anim.movebutton);
        heroButton1.startAnimation(moveAni);
        heroButton2.startAnimation(moveAni);
        heroButton3.startAnimation(moveAni);


    }

    public String getSpecialWord() {
        return specialWord;

    }

    private void createPopUpWindow() {


        int width = ViewGroup.LayoutParams.MATCH_PARENT;
        int height = ViewGroup.LayoutParams.WRAP_CONTENT;
        boolean focusable = true;
        layoutpop.setBackgroundColor(0);

        PopupWindow popupWindow = new PopupWindow(popUpView, width, height, focusable);
        layout.post(() -> popupWindow.showAtLocation(layout, Gravity.CENTER, 0, 0));


        popupButton.setOnClickListener(view -> popupWindow.dismiss());

    }
}