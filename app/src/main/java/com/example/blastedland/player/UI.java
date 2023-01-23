package com.example.blastedland.player;

import android.widget.ImageView;
import android.widget.TextView;

import com.example.blastedland.GameScreen;
import com.example.blastedland.R;

public class UI {


    public double health = 20.00;
    public int silver = 0;
    public byte key = 0;
    private static UI ui;


    private UI(){

    }
    public static UI getInstance(){

        if (ui == null) ui = new UI();

        return ui;
    }


    public void phaseTransformation(GameScreen gameScreen) {


        if (health >= 20) {

            gameScreen.healthImg.setImageResource(R.drawable.phase3);


        } else if (health >= 10) {

            gameScreen.healthImg.setImageResource(R.drawable.phase2);

        } else {

            gameScreen.healthImg.setImageResource(R.drawable.phase1);

        }


    }

    public void increaseMoney(int money) {

        silver += money;


    }

    public void descreaseMoney(int money) {

        silver -= money;


        if (money < 0) {

            this.silver = 0;
        }

    }

    public void increaseHealth(double heal) {

        this.health += heal;

        if (this.health > 20) {

            health = 20;
        }


    }

    public void descreaseHealth(double damage) {

        this.health -= damage;


    }

    public void increaseKey(byte key) {

        if (126 > key) {

            this.key += key;

        }

    }

    public void descreaseKey(byte key) {

        if (key > 0) {

            this.key -= key;

        }

    }

}
