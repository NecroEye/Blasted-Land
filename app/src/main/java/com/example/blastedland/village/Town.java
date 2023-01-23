package com.example.blastedland.village;

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
        gameScreen.gameText.setText("You are approaching the town, all eyes on you cuz no one isn't used to see new face around here");

        gameScreen.button1.setText("Tavern");
        gameScreen.button2.setText("Southern Village (Demi-destroyed)");
        gameScreen.button3.setText("Coast Side");
        gameScreen.button4.setText("Leave the Town");


        story.nextPosition1 = "";
        story.nextPosition2 = "";
        story.nextPosition3 = "";
        story.nextPosition4 = "startingPoint";


    }

    public void casuallyApproach(){

    }


}
