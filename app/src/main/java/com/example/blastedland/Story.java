package com.example.blastedland;

import android.content.Context;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;

import androidx.appcompat.app.AppCompatActivity;

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
        this.cursedDungeon = new CursedDungeon(gs, this);
        this.square = new Square(this, gs);
        this.ashenM = new AshenMountain(gs, this);
        this.town = new Town(gs, this);

    }

    public void selectPosition(String position) {

        switch (position) {

            case "startingPoint":
                startingPoint();
                break;
            case "ashen":
                ashenM.ashen();
                break;
            case "kingdom":
                if (square.isFirstApproach()) square.firstApproach();
                else square.ApproachCasually();
                break;
            case "village":
                town.firstApproach();
                break;
            case "dungeon":
                if (ui.key > 0) cursedDungeon.withKey();
                else cursedDungeon.withoutKey();
                break;
            case "inn":
                square.DeadRat();
                break;
            case "blacksmithPlace":
                square.Blacksmith();
                break;
            case "blacksmith":
                square.toBlacksmith();
                break;
            case "stranger":
                square.toStranger();
                break;
            case "assassin":
                square.toThief();
                break;
            case "king":
                square.KingCastle();
                break;
            case "healing":
                if (ui.silver >= square.beerPrice) {

                    ui.descreaseMoney(square.beerPrice,gs);
                    gs.popupImage.setImageResource(R.drawable.heal);
                    gs.popupText.setText("Drinking beer, increase your lost health!");
                    gs.createPopUpWindow();
                    ui.increaseHealth(20,gs);

                } else {
                    gs.popupImage.setImageResource(R.drawable.yenicoin);
                    gs.popupText.setText("You can't effort beer");
                    gs.createPopUpWindow();
                    break;
                }


        }

    }


    public void startingPoint() {

        showAllButtons();

        gs.gameImage.setImageResource(R.drawable.map);
        gs.gameText.setText("Where are you want to go?");

        gs.button1.setText("Go to north");
        gs.button2.setText("Go to west");
        gs.button3.setText("Go to east");
        gs.button4.setText("Go to south");


        nextPosition1 = "ashen"; // dragon, cold, chest
        nextPosition2 = "kingdom"; // castle, assasin, blacksmith, elf, tavern
        nextPosition3 = "village"; // village, kraken, giant
        nextPosition4 = "dungeon"; // goblet, troll, santelmo, door, book, minotaur


    }

    public void showAllButtons() {

        gs.button1.setVisibility(View.VISIBLE);
        gs.button2.setVisibility(View.VISIBLE);
        gs.button3.setVisibility(View.VISIBLE);
        gs.button4.setVisibility(View.VISIBLE);

    }

}
