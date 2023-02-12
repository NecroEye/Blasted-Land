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

                case "Why do you need to believe something?":

                    conversation.npcText.setText("Because my fellow, without faith, \n You become empty shell");

                    break;

                case "Bullshit, you are just aberrant!":

                    conversation.npcText.setText("Yeah, you are kinda right but we need thatt!");

                    break;

                case "All Hail the Ctulhu!":

                    conversation.npcText.setText("So, you are one of us huh.");

                    break;

            }
        }

    }


    public String getName() {
        return name;
    }
}
