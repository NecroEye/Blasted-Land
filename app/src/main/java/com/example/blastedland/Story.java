package com.example.blastedland;

import android.view.View;

import com.example.blastedland.dungeon.CursedDungeon;
import com.example.blastedland.kingdom.places.Square;
import com.example.blastedland.mountain.AshenMountain;
import com.example.blastedland.player.UI;
import com.example.blastedland.village.Town;

public class Story {


    private GameScreen gs;
    private CursedDungeon cursedDungeon;
    private Square square;
    private Town town;
    private UI ui;
    private AshenMountain ashenM;
    public String nextPosition1, nextPosition2, nextPosition3, nextPosition4;

    public Story(GameScreen gs) {

        this.ui = UI.getInstance();
        this.gs = gs;
        this.cursedDungeon = new CursedDungeon(gs,this);
        this.square = new Square(this,gs);
        this.ashenM = new AshenMountain(gs,this);
        this.town = new Town(gs,this);

    }

    public void selectPosition(String position){

        switch (position){

            case "startingPoint": startingPoint(); break;
            case "ashen": ashenM.ashen(); break;
            case "kingdom": if(square.isFirstApproach()) square.firstApproach(); else square.ApproachCasually(); break;
            case "village": town.firstApproach(); break;
            case "dungeon": if(ui.key > 0) cursedDungeon.withKey(); else cursedDungeon.withoutKey(); break;


        }

    }


    public void startingPoint(){

        showAllButtons();

        gs.gameImage.setImageResource(R.drawable.map);
        gs.gameText.setText("You're lost in the such a decayed land. \n What will you do?");

        gs.button1.setText("Go to north");
        gs.button2.setText("Go to west");
        gs.button3.setText("Go to east");
        gs.button4.setText("Go to south");


        nextPosition1 = "ashen"; // dragon, cold, chest
        nextPosition2 = "kingdom"; // castle, assasin, blacksmith, elf, tavern
        nextPosition3 = "village"; // village, kraken, giant
        nextPosition4 = "dungeon"; // goblet, troll, santelmo, door, book, minotaur





    }

public void showAllButtons(){

    gs.button1.setVisibility(View.VISIBLE);
    gs.button2.setVisibility(View.VISIBLE);
    gs.button3.setVisibility(View.VISIBLE);
    gs.button4.setVisibility(View.VISIBLE);

}

}
