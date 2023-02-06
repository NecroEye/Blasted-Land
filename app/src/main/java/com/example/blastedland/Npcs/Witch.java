package com.example.blastedland.Npcs;

import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;

import com.example.blastedland.Conversation;
import com.example.blastedland.GameScreen;
import com.example.blastedland.R;
import com.example.blastedland.Story;
import com.example.blastedland.player.UI;
import com.example.blastedland.village.Town;

public class Witch implements Npc {


    private final String name = "Annabelle";
    private UI ui;
    private Conversation conversation;
    private GameScreen gameScreen;

    public Witch(Conversation conversation) {

        this.conversation = conversation;
        this.gameScreen = new GameScreen();

        ui = UI.getInstance();

    }


    @Override
    public void talking(String buttonText, Conversation conversation) {


        if (!buttonText.isEmpty()) {
            switch (buttonText) {

                case "Back":
                    conversation.finish();
                    GameScreen.maingamesong.setLooping(true);
                    GameScreen.maingamesong.start();
                    conversation.overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right);
                    break;

                case "Buy a Potion(5)":

                    if (ui.silver >= 5) {

                        Animation animation = AnimationUtils.loadAnimation(conversation,R.anim.bounce);


                        ui.potionAmount += 1;
                        ui.silver -= 5;
                        conversation.moneyText.setText("=" + ui.silver);
                        gameScreen.moneyTx.setText("=" + ui.silver);
                        conversation.moneyText.startAnimation(animation );

                    } else {

                        conversation.popupImage.setImageResource(R.drawable.potion);
                        conversation.popupText.setText("You can't effort this because \n You are poor as fuck.");

                        conversation.createPopUpWindow();


                    }

                    break;

                case "Explain your situation":

                    conversation.npcText.setText("Losing your memory and brought back to life huh, \n Yes, looks like dark magic definitely");
                    conversation.heroButton2.setText("What do i do");


                    break;
                case "What do i do":

                    conversation.npcText.setText("Firstly bring me giant skull, it is around this village side");
                    conversation.heroButton2.setText("Okey");
                    break;

                case "Okey":

                    conversation.popupImage.setImageResource(R.drawable.giantskull);
                    conversation.popupText.setText("The Quest is Accepted! \n Kill the Giant at Southern Village. \n and bring back to its skull to Witch");
                    conversation.createPopUpWindow();

                    conversation.npcText.setText("Then have a good giant hunt!");
                    conversation.heroButton2.setVisibility(View.INVISIBLE);

                    break;


            }
        }

    }

    public String getName() {
        return name;
    }
}
