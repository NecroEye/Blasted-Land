package com.example.blastedland.monsters;

import com.example.blastedland.BattleArea;
import com.example.blastedland.GameScreen;
import com.example.blastedland.R;
import com.example.blastedland.player.UI;

public class Dragon implements MonsterAction {

    public Dragon(BattleArea battleArea) {

        battleArea.monsterName.setText("Ice Dragon");
        battleArea.monsterView.setImageResource(R.drawable.dragon);
        battleArea.monsterHealth.setText("30 Health");

    }


    @Override
    public void attack(UI ui) {

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
}
