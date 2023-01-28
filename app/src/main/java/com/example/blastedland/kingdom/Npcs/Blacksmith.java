package com.example.blastedland.kingdom.Npcs;

import com.example.blastedland.Conversation;
import com.example.blastedland.R;

public class Blacksmith implements Npc {


    private final String name = "Bob";
    private static boolean anvil = false;
    private final Conversation conversation;

    public Blacksmith(Conversation conversation) {

        this.conversation = conversation;

    }

    @Override
    public void talking(String buttonText) {

        if (!buttonText.isEmpty()) {
            switch (buttonText) {

                case "Leave":
                    conversation.finish();
                    conversation.overridePendingTransition(R.anim.slide_in_left,R.anim.slide_out_right);
                    break;

            }
        }

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
