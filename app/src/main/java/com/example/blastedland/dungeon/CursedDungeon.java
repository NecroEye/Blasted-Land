package com.example.blastedland.dungeon;

import android.graphics.drawable.Drawable;
import android.view.View;

import androidx.core.content.ContextCompat;

import com.example.blastedland.GameScreen;
import com.example.blastedland.R;
import com.example.blastedland.Story;
import com.example.blastedland.player.UI;

public class CursedDungeon {


    private GameScreen gameScreen;
    private Story story;
    private UI ui;

    public CursedDungeon(GameScreen gameScreen, Story story) {

        this.gameScreen = gameScreen;
        this.story = story;
        this.ui = UI.getInstance();

    }


    public void withoutKey(){

        allButtonsSetThem();
        gameScreen.gameImage.setImageResource(R.drawable.door);
        gameScreen.gameText.setText("You can't enter this dungeon because you haven't any key");

        gameScreen.button1.setVisibility(View.INVISIBLE);
        gameScreen.button3.setVisibility(View.INVISIBLE);
        gameScreen.button4.setVisibility(View.INVISIBLE);

        gameScreen.button1.setText("");
        gameScreen.button2.setText("back");
        gameScreen.button3.setText("");
        gameScreen.button4.setText("");



        story.nextPosition1 = "";
        story.nextPosition2 = "startingPoint";
        story.nextPosition3 = "";
        story.nextPosition4 = "";
    }

    public void withKey(){

        ui.key -= 1;

        allButtonsSetThem();
        gameScreen.gameImage.setImageResource(R.drawable.door);
        gameScreen.gameText.setText("you used a key to enter the dungeon!");


        gameScreen.button1.setText("");
        gameScreen.button2.setText("");
        gameScreen.button3.setText("");
        gameScreen.button4.setText("back");



        story.nextPosition1 = "";
        story.nextPosition2 = "";
        story.nextPosition3 = "";
        story.nextPosition4 = "startingPoint";


    }

    private void allButtonsSetThem() {

        Drawable img = ContextCompat.getDrawable(gameScreen, R.drawable.dungeonbutton);

        gameScreen.button1.setBackground(img);
        gameScreen.button2.setBackground(img);
        gameScreen.button3.setBackground(img);
        gameScreen.button4.setBackground(img);

    }

}
