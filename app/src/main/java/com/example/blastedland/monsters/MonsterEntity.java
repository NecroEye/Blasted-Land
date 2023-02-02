package com.example.blastedland.monsters;

import com.example.blastedland.BattleArea;
import com.example.blastedland.GameScreen;
import com.example.blastedland.player.UI;

public abstract class MonsterEntity {


    protected String monsterName;
    protected double monsterHealth;
    protected double monsterDamage;


    public double getMonsterHealth() {
        return monsterHealth;
    }

    public void setMonsterHealth(double monsterHealth) {
        this.monsterHealth = monsterHealth;
    }

    public double getMonsterDamage() {
        return monsterDamage;
    }

    public void setMonsterDamage(double monsterDamage) {
        this.monsterDamage = monsterDamage;
    }

    public String getMonsterName() {
        return monsterName;
    }
}



