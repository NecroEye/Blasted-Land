package com.example.blastedland.kingdom.places;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.blastedland.Conversation;
import com.example.blastedland.GameScreen;
import com.example.blastedland.R;
import com.example.blastedland.Story;
import com.example.blastedland.player.UI;

public class Square {


    private Story story;
    private GameScreen gs;
    public final byte beerPrice = 2;


    private static boolean FirstApproach = true;


    public Square(Story story, GameScreen gs) {


        this.story = story;
        this.gs = gs;


    }


    public void firstApproach() {

        FirstApproach = false;

        showAllButtons();


        UI ui = UI.getInstance();

        ui.increaseMoney(2,gs);

        gs.gameImage.setImageResource(R.drawable.castle);
        gs.gameText.setText("You're in the Capital City and shadow of the giant capital city wall upon you. There are couple of places. luckily you found two silver on the floor \n What will you do?");

        gs.button1.setText("Dead Rat Inn");
        gs.button2.setText("Blacksmith's Shop");
        gs.button3.setText("King's Castle");
        gs.button4.setText("Leave the Capital City");


        story.nextPosition1 = "inn";
        story.nextPosition2 = "blacksmithPlace";
        story.nextPosition3 = "king";
        story.nextPosition4 = "startingPoint";


    }

    public void ApproachCasually() {

        showAllButtons();

        gs.gameImage.setImageResource(R.drawable.castle);
        gs.gameText.setText("You're in the Capital City and Everything looks like normal. There are couple of places. \n What will you do?");

        gs.button1.setText("Dead Rat Inn");
        gs.button2.setText("Blacksmith's Shop");
        gs.button3.setText("King's Castle");
        gs.button4.setText("Leave the Capital City");


        story.nextPosition1 = "inn";
        story.nextPosition2 = "blacksmithPlace";
        story.nextPosition3 = "king";
        story.nextPosition4 = "startingPoint";


    }

    public void DeadRat() {


        gs.gameImage.setImageResource(R.drawable.tavern);
        gs.gameText.setText("You're in the Dead Rat Inn, it isn't very crowd. you found a empty place yourself. \n What will you do?");

        gs.button1.setText("Order a beer (2)");
        gs.button2.setText("Talk to Stranger");
        gs.button3.setText("Look at the shadows");
        gs.button4.setText("Leave from inn");


        story.nextPosition1 = "healing"; // a pop up comes and ask you to buying beer if it is yes money lose and health increase
        story.nextPosition2 = "stranger"; //intent with string
        story.nextPosition3 = "assassin"; // intent with string
        story.nextPosition4 = "kingdom"; //backs


    }

    public void Blacksmith() {


        gs.gameImage.setImageResource(R.drawable.blacksmith);
        gs.gameText.setText("You're in Blacksmith's Shop, everywhere surrounded shiny crafts. \n What will you do?");

        gs.button1.setText("Talk to blacksmith");
        gs.button2.setText("Look at goods");
        gs.button3.setText("Ask for any job");
        gs.button4.setText("Leave from inn");


        story.nextPosition1 = "blacksmith";
        story.nextPosition2 = "shinyArmor";
        story.nextPosition3 = "armorerJob";
        story.nextPosition4 = "kingdom";


    }

    @SuppressLint("SetTextI18n")
    public void KingCastle() {

        gs.gameImage.setImageResource(R.drawable.knight);
        gs.gameText.setText("you don't have permission to confort the king!");

        gs.button1.setVisibility(View.INVISIBLE);
        gs.button3.setVisibility(View.INVISIBLE);
        gs.button4.setVisibility(View.INVISIBLE);


        gs.button1.setText("");
        gs.button2.setText("Leave");
        gs.button3.setText("");
        gs.button4.setText("");


        story.nextPosition1 = "";
        story.nextPosition2 = "kingdom";
        story.nextPosition3 = "";
        story.nextPosition4 = "";
    }

    public void toBlacksmith() {
        String npc = "bob";

        Intent chatScreen = new Intent(gs, Conversation.class);
        chatScreen.putExtra("npc", npc);
        gs.startActivity(chatScreen);
        gs.overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);

    }
    public void toBlacksmithJob() {
        String npc = "armorerJob";

        Intent chatScreen = new Intent(gs, Conversation.class);
        chatScreen.putExtra("npc", npc);
        gs.startActivity(chatScreen);
        gs.overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);

    }

    public void toStranger() {

        String npc = "stranger";

        Intent chatScreen = new Intent(gs, Conversation.class);
        chatScreen.putExtra("npc", npc);
        gs.startActivity(chatScreen);
        gs.overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
    }

    public void toThief() {
        String npc = "thief";

        Intent chatScreen = new Intent(gs, Conversation.class);
        chatScreen.putExtra("npc", npc);
        gs.startActivity(chatScreen);
        gs.overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
    }

    private void showAllButtons() {

        gs.button1.setVisibility(View.VISIBLE);
        gs.button2.setVisibility(View.VISIBLE);
        gs.button3.setVisibility(View.VISIBLE);
        gs.button4.setVisibility(View.VISIBLE);


    }


    public static boolean isFirstApproach() {
        return FirstApproach;
    }


}
