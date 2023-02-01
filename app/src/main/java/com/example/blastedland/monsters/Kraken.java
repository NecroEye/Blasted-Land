package com.example.blastedland.monsters;

import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;

import com.example.blastedland.BattleArea;
import com.example.blastedland.GameScreen;
import com.example.blastedland.R;
import com.example.blastedland.player.UI;

import java.util.Random;

public class Kraken extends MonsterEntity implements MonsterAction {



    public Kraken(BattleArea battleArea){


        monsterHealth = 20;
        monsterDamage = 2;

        battleArea.monsterName.setText("Kraken");
        battleArea.monsterView.setImageResource(R.drawable.kraken);
        battleArea.monsterHealth.setText(this.monsterHealth + " Health");
    }

    @Override
    public void attack(UI ui, BattleArea area) {

        Animation bounce = AnimationUtils.loadAnimation(area, R.anim.bounce);
        Animation newBounce = AnimationUtils.loadAnimation(area, R.anim.diffshake);


        if(ui.health > 0 && monsterHealth > 0){

            ui.health -= monsterDamage;
            area.heroHealth.setText(ui.health + " Health");
            area.heroHealth.startAnimation(bounce);
            area.monsterTurnView.setVisibility(View.INVISIBLE);
            area.heroTurnView.setVisibility(View.VISIBLE);
            GameScreen.healthTx.setText("= " + ui.health);
            area.heroView.startAnimation(newBounce);


        }


    }

    @Override
    public void battleChoose(BattleArea battleArea, String choose) {


        switch (choose) {

            case "Run Away":

                int chanceOfEscaping = new Random().nextInt(3);
                System.out.println("Chance: " + chanceOfEscaping);

                if(chanceOfEscaping == 2){

                    battleArea.finish();
                    GameScreen.maingamesong.setLooping(true);
                    GameScreen.maingamesong.start();
                    battleArea.overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);

                    break;
                }
                else{

                    Animation shake = AnimationUtils.loadAnimation(battleArea,R.anim.shake);

                    battleArea.monsterAttack();
                    battleArea.allButtonLocked();
                    battleArea.choose4.startAnimation(shake);


                    break;
                }
        }

    }

}
