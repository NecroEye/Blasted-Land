package com.example.blastedland.kingdom.Npcs;

import com.example.blastedland.Conversation;

public class Thief implements Npc{


    private final String name = "Vigil";
    private boolean firstApproach = true;
    private final Conversation conversation;


    public Thief(Conversation conversation) {

        this.conversation = conversation;

    }


    public String getName() {
        return name;
    }

    public void firstEncounter() {


    }


    @Override
    public void talking(String buttonText) {

    }


}
