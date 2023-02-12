package com.example.blastedland.monsters;

import android.content.res.ColorStateList;
import android.graphics.Color;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;

import com.example.blastedland.BattleArea;
import com.example.blastedland.Conversation;
import com.example.blastedland.GameScreen;
import com.example.blastedland.R;
import com.example.blastedland.Story;
import com.example.blastedland.player.UI;

import java.util.ArrayList;
import java.util.Random;

public class Kraken extends MonsterEntity implements MonsterAction {




    public Kraken(BattleArea battleArea) {

        monsterName = "Kraken";
        monsterHealth = 20;

        RandomizeDamage.add(1.50);
        RandomizeDamage.add(1.75);
        RandomizeDamage.add(2.00);
        RandomizeDamage.add(2.25);


        battleArea.monsterName.setText(monsterName);
        battleArea.monsterView.setImageResource(R.drawable.kraken);
        battleArea.monsterHealth.setText(this.monsterHealth + " Health");
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
            area.battleText.setText("You were got " + RandomizeDamage.get(selected) + "\n damage by " + monsterName);
            area.battleText.setTextColor(Color.parseColor("#E97451"));

           // conversation.moneyText.setText("= " + ui.silver);
           // ui.phaseTransformation(conversation.healthImg);
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
