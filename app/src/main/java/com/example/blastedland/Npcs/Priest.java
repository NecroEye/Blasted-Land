package com.example.blastedland.Npcs;

import com.example.blastedland.Conversation;
import com.example.blastedland.GameScreen;
import com.example.blastedland.R;

public class Priest implements Npc {


    private final Conversation conversation;
    private final String name = "Anton";


    public Priest(Conversation conversation) {

        this.conversation = conversation;

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
