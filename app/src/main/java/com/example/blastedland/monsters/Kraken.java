package com.example.blastedland.monsters;

import com.example.blastedland.BattleArea;
import com.example.blastedland.GameScreen;
import com.example.blastedland.R;
import com.example.blastedland.player.UI;

public class Kraken implements MonsterAction {


    public Kraken(BattleArea battleArea){

        battleArea.monsterName.setText("Kraken");
        battleArea.monsterView.setImageResource(R.drawable.kraken);
        battleArea.monsterHealth.setText("20 Health");
    }

    @Override
    public void attack(UI ui) {

    }

    @Override
    public void battleChoose(BattleArea battleArea, String choose) {

        // view ve textler ayarlanacak

        switch (choose){

            case "Run Away":

                battleArea.finish();
                GameScreen.maingamesong.setLooping(true);
                GameScreen.maingamesong.start();
                battleArea.overridePendingTransition(R.anim.slide_in_right,R.anim.slide_out_left);

                break;

        }

    }
}
