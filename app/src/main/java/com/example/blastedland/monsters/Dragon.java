package com.example.blastedland.monsters;

import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;

import com.example.blastedland.BattleArea;
import com.example.blastedland.GameScreen;
import com.example.blastedland.R;
import com.example.blastedland.player.UI;

public class Dragon extends MonsterEntity implements MonsterAction {






    public Dragon(BattleArea battleArea) {

        monsterHealth = 30;
        monsterDamage = 4;

        battleArea.monsterName.setText("Ice Dragon");
        battleArea.monsterView.setImageResource(R.drawable.dragon);
        battleArea.monsterHealth.setText(monsterHealth + " Health");

    }


    @Override
    public void attack(UI ui, BattleArea area) {

        Animation bounce = AnimationUtils.loadAnimation(area, R.anim.bounce);


        if(ui.health > 0 && monsterHealth > 0){

            ui.health -= monsterDamage;
            area.heroHealth.setText(ui.health + " Health");
            area.heroHealth.startAnimation(bounce);
            area.monsterTurnView.setVisibility(View.INVISIBLE);
            area.heroTurnView.setVisibility(View.VISIBLE);
            GameScreen.healthTx.setText("= " + ui.health);


        }


    }

    @Override
    public void battleChoose(BattleArea battleArea, String choose) {


        switch (choose) {

            case "Run Away":

                battleArea.finish();
                GameScreen.maingamesong.setLooping(true);
                GameScreen.maingamesong.start();
                battleArea.overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);

                break;

        }
    }

    public double getMonsterHealth() {
        return monsterHealth;
    }

    public void setMonsterHealth(double monsterHealth) {
        this.monsterHealth = monsterHealth;
    }
}
