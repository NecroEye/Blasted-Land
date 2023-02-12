package com.example.blastedland.monsters;

import android.content.res.ColorStateList;
import android.graphics.Color;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;

import com.example.blastedland.BattleArea;
import com.example.blastedland.GameScreen;
import com.example.blastedland.R;
import com.example.blastedland.player.UI;

import java.util.ArrayList;
import java.util.Random;

public class Giant extends MonsterEntity implements MonsterAction{


    public static boolean isGainedItsHead = false, isGiantFounded = false;




    public Giant(BattleArea battleArea){

        monsterName = "Giant";
        monsterHealth = 35;

        RandomizeDamage.add(1.0);
        RandomizeDamage.add(1.25);
        RandomizeDamage.add(1.50);
        RandomizeDamage.add(1.75);



        battleArea.monsterName.setText(monsterName);
        battleArea.monsterView.setImageResource(R.drawable.giant);
        battleArea.monsterHealth.setText(monsterHealth + " Health");

    }




    @Override
    public void attack(UI ui, BattleArea area) {

        Random randomDamageSelector = new Random();

        int selected = randomDamageSelector.nextInt(4);


        Animation bounce = AnimationUtils.loadAnimation(area, R.anim.bounce);
        Animation newBounce = AnimationUtils.loadAnimation(area, R.anim.diffshake);


        if (ui.health > 0 && monsterHealth > 0) {

            ui.health -= RandomizeDamage.get(selected);
            area.heroHealth.setText(ui.health + " Health");
            area.heroHealth.startAnimation(bounce);
            area.monsterTurnView.setVisibility(View.INVISIBLE);
            area.heroTurnView.setVisibility(View.VISIBLE);
            GameScreen.healthTx.setText("=" + ui.health);
            area.heroView.startAnimation(newBounce);
            ui.phaseTransformation(GameScreen.HealthImg);
            area.battleText.setText("You were got " + RandomizeDamage.get(selected) + " \n damage by " + monsterName);
            area.battleText.setTextColor(Color.parseColor("#E97451"));



        }

        area.choose1.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#7b7b7b")));
        area.choose2.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#7b7b7b")));
        area.choose3.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#7b7b7b")));
        area.choose4.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#7b7b7b")));

    }

    @Override
    public void battleChoose(BattleArea battleArea, String choose) {

        switch (choose) {

            case "Run Away":

                int chanceOfEscaping = new Random().nextInt(3);
                System.out.println("Chance: " + chanceOfEscaping);

                if (chanceOfEscaping == 2) {

                    UI.powerfulAmount = 2;
                    battleArea.finish();
                    GameScreen.maingamesong.setLooping(true);
                    GameScreen.maingamesong.start();
                    battleArea.overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);

                    break;
                } else {

                    Animation shake = AnimationUtils.loadAnimation(battleArea, R.anim.shake);

                    battleArea.monsterAttack();
                    battleArea.allButtonLocked();
                    battleArea.choose4.startAnimation(shake);
                    battleArea.battleText.setText("You were failed escaping");
                    battleArea.battleText.setTextColor(Color.GREEN);


                    battleArea.heroTurnView.setVisibility(View.INVISIBLE);
                    battleArea.monsterTurnView.setVisibility(View.VISIBLE);

                    break;
                }
        }

    }
}
