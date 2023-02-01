package com.example.blastedland.mountain;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;

import androidx.core.content.ContextCompat;

import com.example.blastedland.BattleArea;
import com.example.blastedland.GameScreen;
import com.example.blastedland.R;
import com.example.blastedland.Story;

public class AshenMountain {


    private GameScreen gs;
    private Story story;
    public static String place1 = "", place2 = "", place3 = "";
    public static boolean isSeen = false;

    public AshenMountain(GameScreen gs, Story story) {

        this.gs = gs;
        this.story = story;

    }


    public void ashen() {


        allButtonsSetThem();
        gs.gameImage.setImageResource(R.drawable.mountains);
        gs.gameText.setText("You're at the Ashen Mountain. \n What will you do?");

        if (place1.matches("Northern Town") && place2.matches("Frozen Cave")) {

            if(isSeen == true)  gs.button3.setVisibility(View.GONE); else gs.button3.setVisibility(View.VISIBLE);

            gs.button1.setText("Northern Town"); // Frozen Town
            gs.button2.setText("Frozen Cave"); // Ice dragon's place
            gs.button3.setText("Read the sign"); // suddenly disappear
            gs.button4.setText("Back");


            story.nextPosition1 = "";
            story.nextPosition2 = "dragon";
            story.nextPosition3 = "MountainSign";
            story.nextPosition4 = "startingPoint";

        } else if (!place1.isEmpty() || place2.matches("Frozen Cave")) {

            if(isSeen == true)  gs.button3.setVisibility(View.GONE); else gs.button3.setVisibility(View.VISIBLE);

            gs.button1.setText("Forward"); // Frozen Town
            gs.button2.setText("Frozen Cave"); // Ice dragon's place
            gs.button3.setText("Read the sign"); // suddenly disappear
            gs.button4.setText("Back");

         /*    savaş button iconu
           Drawable img = ContextCompat.getDrawable(gs, R.drawable.warlock);
           img.setBounds(10,10,20,20);
           gs.button2.setCompoundDrawablesWithIntrinsicBounds(img.getLevel(),0,img.getLevel(),0);
         */

            story.nextPosition1 = "";
            story.nextPosition2 = "dragon";
            story.nextPosition3 = "MountainSign";
            story.nextPosition4 = "startingPoint";
        } else if (place1.matches("Northern Town") && !place2.isEmpty()) {

              if(isSeen == true)  gs.button3.setVisibility(View.GONE); else gs.button3.setVisibility(View.VISIBLE);

            gs.button1.setText("Northern Town");
            gs.button2.setText("Take a look");
            gs.button3.setText("Read the sign");
            gs.button4.setText("Back");


            story.nextPosition1 = "";
            story.nextPosition2 = "";
            story.nextPosition3 = "MountainSign";
            story.nextPosition4 = "startingPoint";
        } else {
            gs.button1.setText("Forward");
            gs.button2.setText("Take a look");
            gs.button3.setText("Read the sign");
            gs.button4.setText("Back");


            story.nextPosition1 = "";
            story.nextPosition2 = gs.button2.getText().toString();
            story.nextPosition3 = "MountainSign";
            story.nextPosition4 = "startingPoint";

            gs.button3.setVisibility(View.VISIBLE);
        }

    }

    public void toDragon(){

        String monster = "dragon";

        Intent chatScreen = new Intent(gs, BattleArea.class);
        chatScreen.putExtra("monster", monster);
        gs.startActivity(chatScreen);
        gs.overridePendingTransition(R.anim.slide_in_left,R.anim.slide_out_right);
    }

    private void allButtonsSetThem(){

        Drawable img = ContextCompat.getDrawable(gs, R.drawable.mountainbutton);

        gs.button1.setBackground(img);
        gs.button2.setBackground(img);
        gs.button3.setBackground(img);
        gs.button4.setBackground(img);

    }


}
