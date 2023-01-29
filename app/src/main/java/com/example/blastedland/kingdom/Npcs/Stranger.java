package com.example.blastedland.kingdom.Npcs;

import com.example.blastedland.Conversation;
import com.example.blastedland.GameScreen;
import com.example.blastedland.R;

public class Stranger implements Npc {


    private final Conversation conversation;
    private String name = "Stranger";
    public static boolean scroll = false;


    public Stranger(Conversation conversation){
        this.conversation = conversation;

    }


    @Override
    public void talking(String buttonText) {

        if (!buttonText.isEmpty()) {
            switch (buttonText) {

                case "Back":
                    conversation.finish();
                    GameScreen.maingamesong.setLooping(true);
                    GameScreen.maingamesong.start();
                    conversation.overridePendingTransition(R.anim.slide_in_left,R.anim.slide_out_right);
                    break;

            }
        }

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }



}
