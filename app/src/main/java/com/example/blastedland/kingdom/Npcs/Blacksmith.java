package com.example.blastedland.kingdom.Npcs;

public class Blacksmith {


    private final String name = "Bob";
    private static boolean anvil = false;

    public Blacksmith(){

    }

    public String getName() {
        return name;
    }

    public static boolean isAnvil() {
        return anvil;
    }

    public static void setAnvil(boolean anvil) {
        Blacksmith.anvil = anvil;
    }



}
