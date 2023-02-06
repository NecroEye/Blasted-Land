package com.example.blastedland.Npcs;

import com.example.blastedland.Conversation;
import com.example.blastedland.GameScreen;
import com.example.blastedland.R;

public class WorshiperVillager implements Npc{


    private final String name = "Worshiper Villager";
    private Conversation conversation;



    public WorshiperVillager(Conversation conversation){

        this.conversation =  conversation;

    }



    @Override
    public void talking(String buttonText, Conversation conversation) {

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
}
