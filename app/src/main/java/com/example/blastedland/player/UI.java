package com.example.blastedland.player;

import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.blastedland.BattleArea;
import com.example.blastedland.GameScreen;
import com.example.blastedland.R;
import com.example.blastedland.monsters.Dragon;
import com.example.blastedland.monsters.MonsterEntity;

public class UI {


    public double health = 20.00;
    public double basicDamage = 3.25;
    public int silver = 0;
    public byte key = 0;
    public byte reincarnation = 0;
    private static UI ui;


    private UI() {

    }

    public static UI getInstance() {


        if (ui == null) ui = new UI();

        return ui;
    }

    public void heroAttack(MonsterEntity mainVariables, BattleArea battleArea) {

        Animation bounce = AnimationUtils.loadAnimation(battleArea, R.anim.bounce);
        Animation newBounce = AnimationUtils.loadAnimation(battleArea, R.anim.diffshake);


        if (mainVariables.getMonsterHealth() > 0 && health > 0) {

            mainVariables.setMonsterHealth(mainVariables.getMonsterHealth() - this.basicDamage);
            battleArea.monsterHealth.setText(mainVariables.getMonsterHealth() + " Health");
            battleArea.monsterHealth.startAnimation(bounce);
            battleArea.monsterView.startAnimation(newBounce);

            battleArea.heroTurnView.setVisibility(View.INVISIBLE);
            battleArea.monsterTurnView.setVisibility(View.VISIBLE);



        }


    }


    public void phaseTransformation(GameScreen gameScreen) {

        //ImageView da bounce eklenecek fakat imageView tanımlanmadı ve isimlenmedi onu kontrol et

        if (health >= 20) {

            gameScreen.healthImg.setImageResource(R.drawable.phase3);


        } else if (health >= 10) {

            gameScreen.healthImg.setImageResource(R.drawable.phase2);

        } else {

            gameScreen.healthImg.setImageResource(R.drawable.phase1);

        }


    }

    public void increaseMoney(int money, GameScreen gameScreen) {

        Animation bounce = AnimationUtils.loadAnimation(gameScreen, R.anim.bounce);

        silver += money;
        gameScreen.moneyTx.setText("= " + silver);
        gameScreen.moneyTx.startAnimation(bounce);

    }

    public void descreaseMoney(int money, GameScreen gameScreen) {

        Animation bounce = AnimationUtils.loadAnimation(gameScreen, R.anim.bounce);

        if (money < 0) {

            this.silver = 0;
            gameScreen.moneyTx.setText("= " + silver);

            gameScreen.moneyTx.startAnimation(bounce);
        } else {
            silver -= money;
            gameScreen.moneyTx.setText("= " + silver);
            gameScreen.moneyTx.startAnimation(bounce);
        }

    }

    public void increaseHealth(double heal, GameScreen gameScreen) {

        Animation bounce = AnimationUtils.loadAnimation(gameScreen, R.anim.bounce);


        if (this.health >= 20) {

            this.health = 20;
            gameScreen.healthTx.setText("= " + (int) health);
            gameScreen.healthTx.startAnimation(bounce);
            phaseTransformation(gameScreen);
        } else {


            // potion class oluşturulacak içerisinde eksik cana göre healı düzenleyecek
            // strength potionu olacak kahramanın basic attağını güçlendirecek bir defaya mahsus
            //20 yi geçebiliyor aldığı heal miktarına göre kontrol et
            this.health += heal;
            gameScreen.healthTx.setText("= " + (int) health);
            gameScreen.healthTx.startAnimation(bounce);
            phaseTransformation(gameScreen);
        }


    }

    public void descreaseHealth(double damage, GameScreen gameScreen) {

        this.health -= damage;
        gameScreen.healthTx.setText("= " + health);
        phaseTransformation(gameScreen);

    }

    public void increaseKey(byte key, GameScreen gameScreen) {

        if (126 > key) {

            this.key += key;
            gameScreen.keyTx.setText("X" + key);
        }

    }

    public void descreaseKey(byte key, GameScreen gameScreen) {

        if (key > 0) {

            this.key -= key;
            gameScreen.keyTx.setText("X" + key);

        }

    }

}
