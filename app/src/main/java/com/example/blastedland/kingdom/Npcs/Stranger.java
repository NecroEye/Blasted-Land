package com.example.blastedland.kingdom.Npcs;

import com.example.blastedland.Conversation;

public class Stranger implements Npc {


    private final Conversation conversation;
    private String name = "Stranger";
    private static boolean scroll = false;


    public Stranger(Conversation conversation){
        this.conversation = conversation;

    }


    @Override
    public void talking(String buttonText) {

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public static boolean isScroll() {
        return scroll;
    }

    public static void setScroll(boolean scroll) {
        Stranger.scroll = scroll;
    }


}
