package com.example.blastedland.player;

import android.graphics.Color;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;

import com.example.blastedland.BattleArea;
import com.example.blastedland.R;

public class Potion {


    private final double potionHeal = 7.5;
    private BattleArea battleArea;
    private UI ui;


    public Potion(BattleArea battleArea) {

        ui = UI.getInstance();
        this.battleArea = battleArea;

    }


    public void HealingByPotion() {

      if(potionCheck()){

          ui.potionAmount -= 1;
          battleArea.choose1.setText("Potion " + "(" + ui.potionAmount + ")");


          ui.health += potionHeal;

          if (ui.health > 20) ui.health = 20;


          Animation bounce = AnimationUtils.loadAnimation(battleArea, R.anim.bounce);
          battleArea.heroHealth.startAnimation(bounce);
          battleArea.heroHealth.setText(ui.health + " Health");
          battleArea.battleText.setText("You used a potion, \n it has raised your health " + potionHeal);
          battleArea.battleText.setTextColor(Color.GREEN);

          battleArea.heroTurnView.setVisibility(View.INVISIBLE);
          battleArea.monsterTurnView.setVisibility(View.VISIBLE);

      }
      else{

          Animation shake = AnimationUtils.loadAnimation(battleArea, R.anim.shake);
          battleArea.choose1.startAnimation(shake);

          battleArea.battleText.setText("You don't possess a potion");
          battleArea.battleText.setTextColor(Color.GREEN);

          battleArea.heroTurnView.setVisibility(View.INVISIBLE);
          battleArea.monsterTurnView.setVisibility(View.VISIBLE);

      }


    }

    private void potionUsed() {

    }

    private boolean potionCheck() {

        if (ui.potionAmount > 0) {

            return true;
        } else {
            return false;
        }


    }


}
