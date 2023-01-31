package com.example.blastedland.monsters;

import com.example.blastedland.BattleArea;
import com.example.blastedland.GameScreen;
import com.example.blastedland.player.UI;

public interface MonsterAction {


    void attack(UI ui, BattleArea area);

    void battleChoose(BattleArea battleArea, String choose);

}
