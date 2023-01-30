package com.example.blastedland.monsters;

import com.example.blastedland.BattleArea;
import com.example.blastedland.player.UI;

public interface MonsterAction {


     void attack(UI ui);
     void battleChoose(BattleArea battleArea, String choose);

}
