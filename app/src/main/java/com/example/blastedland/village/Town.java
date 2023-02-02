package com.example.blastedland.village;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.view.View;

import androidx.core.content.ContextCompat;

import com.example.blastedland.BattleArea;
import com.example.blastedland.Conversation;
import com.example.blastedland.GameScreen;
import com.example.blastedland.R;
import com.example.blastedland.Story;

public class Town {


    private GameScreen gameScreen;
    private Story story;


    public Town(GameScreen gameScreen, Story story) {

        this.gameScreen = gameScreen;
        this.story = story;


    }


    public void firstApproach() {

        allButtonsSetThem();
        gameScreen.gameImage.setImageResource(R.drawable.village);
        gameScreen.gameText.setText("You are approaching the town, all eyes on you because no one isn't used to see new face around here");

        gameScreen.button1.setText("Church");
        gameScreen.button2.setText("Southern Village (Demi-destroyed)");
        gameScreen.button3.setText("Coast Side");
        gameScreen.button4.setText("Leave the Town");


        story.nextPosition1 = "church";
        story.nextPosition2 = "stvillage";
        story.nextPosition3 = "kraken";
        story.nextPosition4 = "startingPoint";


    }

    public void casuallyApproach() {

        allButtonsSetThem();


    }

    public void Church() {

        gameScreen.gameImage.setImageResource(R.drawable.church);
        gameScreen.gameText.setText("You are in church, probably something has doing here");

        gameScreen.button1.setText("talk to priest");
        gameScreen.button2.setText("");
        gameScreen.button3.setText("");
        gameScreen.button4.setText("Leave Church");


        story.nextPosition1 = "priest";
        story.nextPosition2 = "";
        story.nextPosition3 = "";
        story.nextPosition4 = "village";

    }

    public void southernVillage() {

        story.showAllButtons();

        gameScreen.gameImage.setImageResource(R.drawable.hut);
        gameScreen.gameText.setText("Looks like this place is ominous");

        gameScreen.button1.setText("Witch's Hut");
        gameScreen.button2.setText("Follow Giant's tracks"); // belki burası witchle konuştuğumuzda açılacak ve tıkladığımızda animasyonla ismi değişecek devin bölgesi veya ini gibi
        gameScreen.button3.setText("Look into well");
        gameScreen.button4.setText("Leave Southern Village");


        story.nextPosition1 = "witchHouse";
        story.nextPosition2 = "";
        story.nextPosition3 = "well";
        story.nextPosition4 = "village";

    }
    public void witchHouse(){

        gameScreen.gameImage.setImageResource(R.drawable.hut);
        gameScreen.gameText.setText("You are nearly Witch's hut, wanna go in?");

        gameScreen.button1.setText("");
        gameScreen.button2.setText("Go in");
        gameScreen.button3.setText("Nah, Go Back");
        gameScreen.button4.setText("");

        gameScreen.button1.setVisibility(View.INVISIBLE);
        gameScreen.button4.setVisibility(View.INVISIBLE);

        story.nextPosition1 = "";
        story.nextPosition2 = "witch";
        story.nextPosition3 = "stvillage";
        story.nextPosition4 = "";

    }

    public void toPriest() {

        String npc = "anton";

        Intent chatScreen = new Intent(gameScreen, Conversation.class);
        chatScreen.putExtra("npc", npc);
        gameScreen.startActivity(chatScreen);
        gameScreen.overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
    }

    public void toWitch() {

        String npc = "annabelle";

        Intent chatScreen = new Intent(gameScreen, Conversation.class);
        chatScreen.putExtra("npc", npc);
        gameScreen.startActivity(chatScreen);
        gameScreen.overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
    }

    public void toKraken() {

        String monster = "kraken";

        Intent chatScreen = new Intent(gameScreen, BattleArea.class);
        chatScreen.putExtra("monster", monster);
        gameScreen.startActivity(chatScreen);
        gameScreen.overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right);

    }

    private void allButtonsSetThem() {

        Drawable img = ContextCompat.getDrawable(gameScreen, R.drawable.villabutton);

        gameScreen.button1.setBackground(img);
        gameScreen.button2.setBackground(img);
        gameScreen.button3.setBackground(img);
        gameScreen.button4.setBackground(img);

    }


}
