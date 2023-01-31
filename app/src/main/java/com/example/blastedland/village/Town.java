package com.example.blastedland.village;

import android.content.Intent;

import com.example.blastedland.BattleArea;
import com.example.blastedland.Conversation;
import com.example.blastedland.GameScreen;
import com.example.blastedland.R;
import com.example.blastedland.Story;

public class Town {


    private GameScreen gameScreen;
    private Story story;



    public Town(GameScreen gameScreen, Story story){

        this.gameScreen = gameScreen;
        this.story = story;


    }



    public void firstApproach(){


        gameScreen.gameImage.setImageResource(R.drawable.village);
        gameScreen.gameText.setText("You are approaching the town, all eyes on you because no one isn't used to see new face around here");

        gameScreen.button1.setText("Tavern");
        gameScreen.button2.setText("Southern Village (Demi-destroyed)");
        gameScreen.button3.setText("Coast Side");
        gameScreen.button4.setText("Leave the Town");


        story.nextPosition1 = "";
        story.nextPosition2 = "";
        story.nextPosition3 = "kraken";
        story.nextPosition4 = "startingPoint";


    }

    public void casuallyApproach(){

    }

    public void toKraken(){

        String monster = "kraken";

        Intent chatScreen = new Intent(gameScreen, BattleArea.class);
        chatScreen.putExtra("monster", monster);
        gameScreen.startActivity(chatScreen);
        gameScreen.overridePendingTransition(R.anim.slide_in_left,R.anim.slide_out_right);

    }


}
