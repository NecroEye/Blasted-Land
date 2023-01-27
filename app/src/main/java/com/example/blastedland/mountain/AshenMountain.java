package com.example.blastedland.mountain;

import android.view.animation.Animation;
import android.view.animation.AnimationUtils;

import com.example.blastedland.GameScreen;
import com.example.blastedland.R;
import com.example.blastedland.Story;

public class AshenMountain {



    private GameScreen gs;
    private Story story;

    public AshenMountain(GameScreen gs, Story story){

        this.gs = gs;
        this.story = story;

    }
    public void ashen(){


        gs.gameImage.setImageResource(R.drawable.mountains);
        gs.gameText.setText("You're at the Ashen Mountain. \n What will you do?");

        gs.button1.setText("forward");
        gs.button2.setText("take a look");
        gs.button3.setText("read the sign");
        gs.button4.setText("back");


        story.nextPosition1 = "";
        story.nextPosition2 = "";
        story.nextPosition3 = "";
        story.nextPosition4 = "startingPoint";

    }


}
