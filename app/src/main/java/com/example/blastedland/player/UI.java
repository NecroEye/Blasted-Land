package com.example.blastedland.player;

import android.content.res.ColorStateList;
import android.graphics.Color;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

import com.daimajia.androidanimations.library.Techniques;
import com.daimajia.androidanimations.library.YoYo;
import com.example.blastedland.BattleArea;
import com.example.blastedland.GameScreen;
import com.example.blastedland.R;
import com.example.blastedland.monsters.Dragon;
import com.example.blastedland.monsters.MonsterEntity;

import java.util.ArrayList;
import java.util.Random;

public class UI {


    public double health = 20.00;
    public static int powerfulAmount = 2;
    public int silver = 0;
    public int potionAmount = 1;
    public byte key = 0;
    public byte reincarnation = 0;
    private static UI ui;
    private static final ArrayList<Double> basicDamage = new ArrayList<>();


    private UI() {

    }

    public static UI getInstance() {

        basicDamage.add(3.0);
        basicDamage.add(3.25);
        basicDamage.add(3.50);
        basicDamage.add(3.75);


        if (ui == null) ui = new UI();

        return ui;
    }

    public void heroAttack(MonsterEntity mainVariables, BattleArea battleArea) {

        Random randomDamageSelector = new Random();

        int selected = randomDamageSelector.nextInt(4);


        Animation bounce = AnimationUtils.loadAnimation(battleArea, R.anim.bounce);
        Animation newBounce = AnimationUtils.loadAnimation(battleArea, R.anim.diffshake);


        if (mainVariables.getMonsterHealth() > 0 && health > 0) {

            mainVariables.setMonsterHealth(mainVariables.getMonsterHealth() - basicDamage.get(selected));
            battleArea.monsterHealth.setText(mainVariables.getMonsterHealth() + " Health");
            battleArea.monsterHealth.startAnimation(bounce);
            battleArea.monsterView.startAnimation(newBounce);
            battleArea.battleText.setText(mainVariables.getMonsterName() + " was got " + basicDamage.get(selected) + " \n damage by you");
            battleArea.battleText.setTextColor(Color.GREEN);
            YoYo.with(Techniques.RubberBand).delay(50).duration(150).playOn(battleArea.choose2);




            battleArea.heroTurnView.setVisibility(View.INVISIBLE);
            battleArea.monsterTurnView.setVisibility(View.VISIBLE);


        }


    }


    public void CritHeroAttack(MonsterEntity mainVariables, BattleArea battleArea) {

        Random randomDamageSelector = new Random();

        int selected = randomDamageSelector.nextInt(4);

        Animation bounce = AnimationUtils.loadAnimation(battleArea, R.anim.bounce);
        Animation newBounce = AnimationUtils.loadAnimation(battleArea, R.anim.diffshake);


        if (mainVariables.getMonsterHealth() > 0 && health > 0 && powerfulAmount > 0) {

            powerfulAmount -= 1;
            battleArea.choose3.setText("Power " + "(" + powerfulAmount + ")");

            mainVariables.setMonsterHealth(mainVariables.getMonsterHealth() - (basicDamage.get(selected) * 2));
            battleArea.monsterHealth.setText(mainVariables.getMonsterHealth() + " Health");
            battleArea.monsterHealth.startAnimation(bounce);
            battleArea.monsterView.startAnimation(newBounce);
            battleArea.battleText.setText(mainVariables.getMonsterName() + " was got " + (basicDamage.get(selected) * 2) + " \n damage by you");
            battleArea.battleText.setTextColor(Color.GREEN);
            battleArea.allButtonLocked();
            YoYo.with(Techniques.RubberBand).delay(50).duration(150).playOn(battleArea.choose2);



            battleArea.heroTurnView.setVisibility(View.INVISIBLE);
            battleArea.monsterTurnView.setVisibility(View.VISIBLE);


        } else {

            battleArea.battleText.setText("You aren't able to powerful attack anymore.");
            battleArea.battleText.setTextColor(Color.GREEN);
            battleArea.allButtonLocked();



            Animation shake = AnimationUtils.loadAnimation(battleArea, R.anim.shake);
            battleArea.choose3.startAnimation(shake);

            battleArea.heroTurnView.setVisibility(View.INVISIBLE);
            battleArea.monsterTurnView.setVisibility(View.VISIBLE);

        }


    }


    public void phaseTransformation(ImageView imageView) {

        //ImageView da bounce eklenecek fakat imageView tanımlanmadı ve isimlenmedi onu kontrol et

        if (health >= 20) {

            imageView.setImageResource(R.drawable.phase3);


        } else if (health >= 10) {

            imageView.setImageResource(R.drawable.phase2);

        } else {

            imageView.setImageResource(R.drawable.phase1);

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

    public void increaseHealth(double heal, GameScreen gameScreen, ImageView image) {

        Animation bounce = AnimationUtils.loadAnimation(gameScreen, R.anim.bounce);


        if (this.health >= 20) {

            this.health = 20;
            gameScreen.healthTx.setText("= " + (int) health);
            gameScreen.healthTx.startAnimation(bounce);
            phaseTransformation(image);
        } else {


            // potion class oluşturulacak içerisinde eksik cana göre healı düzenleyecek
            // strength potionu olacak kahramanın basic attağını güçlendirecek bir defaya mahsus
            //20 yi geçebiliyor aldığı heal miktarına göre kontrol et
            this.health += heal;
            gameScreen.healthTx.setText("= " + (int) health);
            gameScreen.healthTx.startAnimation(bounce);
            phaseTransformation(image);
        }


    }

    public void descreaseHealth(double damage, GameScreen gameScreen, ImageView image) {

        this.health -= damage;
        gameScreen.healthTx.setText("= " + health);
        phaseTransformation(image);

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
