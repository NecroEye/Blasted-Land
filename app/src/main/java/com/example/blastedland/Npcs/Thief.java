package com.example.blastedland.Npcs;

import android.view.animation.Animation;
import android.view.animation.AnimationUtils;

import com.example.blastedland.Conversation;
import com.example.blastedland.GameScreen;
import com.example.blastedland.R;
import com.example.blastedland.player.UI;

public class Thief implements Npc{


    private final String name = "Vigil";
    private boolean firstApproach = true;
    private final Conversation conversation;
    private UI ui;
    private GameScreen gameScreen;


    public Thief(Conversation conversation) {

        this.gameScreen = new GameScreen();
        this.ui = UI.getInstance();
        this.conversation = conversation;

    }


    public void firstEncounter() {


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

                case "N-No, i am just chilling":

                         conversation.npcText.setText("Better do!");

                    break;
                case "Do you know who i am?":

                    conversation.npcText.setText("I don't give a shit, whoever you are still \n I hold my blade on your neck");

                    break;

                case "give it some silver (10)":

                    Animation animation = AnimationUtils.loadAnimation(conversation,R.anim.bounce);

                    conversation.npcText.setText("Yeah, you thought wisely!");

                    ui.silver -= 10;
                    conversation.moneyText.startAnimation(animation);
                    conversation.moneyText.setText("=" + ui.silver);
                    gameScreen.moneyTx.setText("=" + ui.silver);


                    break;

            }
        }

    }

    public String getName() {
        return name;
    }


}
