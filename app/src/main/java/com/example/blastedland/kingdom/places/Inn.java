package com.example.blastedland.kingdom.places;

import com.example.blastedland.GameScreen;
import com.example.blastedland.kingdom.Npcs.Stranger;
import com.example.blastedland.kingdom.Npcs.Thief;

public class Inn {


    private Thief thief;
    private Stranger stranger;
    private GameScreen gs;


    public Inn(GameScreen gs){


        this.thief = new Thief();
        this.stranger = new Stranger();
        this.gs = gs;

    }





}
