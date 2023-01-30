package com.example.blastedland.kingdom.Npcs;

import com.example.blastedland.Conversation;
import com.example.blastedland.GameScreen;
import com.example.blastedland.R;

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


}
