package com.example.blastedland.kingdom.Npcs;

public class Stranger {


    private String name = "Stranger";
    private static boolean scroll = false;


    public Stranger(){


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
