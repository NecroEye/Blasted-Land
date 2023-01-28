package com.example.blastedland.kingdom.places;

import android.content.Intent;

import com.example.blastedland.Conversation;
import com.example.blastedland.GameScreen;
import com.example.blastedland.R;
import com.example.blastedland.Story;
import com.example.blastedland.player.UI;

public class Square {


    private Story story;
    private GameScreen gs;



    private static boolean FirstApproach = true;




    public Square(Story story, GameScreen gs){


        this.story = story;
        this.gs = gs;




    }


    public void firstApproach(){

        FirstApproach = false;

        UI ui = UI.getInstance();

         ui.silver += 2;
         gs.moneyTx.setText("=" +ui.silver);

        gs.gameImage.setImageResource(R.drawable.castle);
        gs.gameText.setText("You're in the Capital City and shadow of the giant capital city wall upon you. There are couple of places. luckily you found two silver on the floor \n What will you do?");

        gs.button1.setText("Dead Rat Inn");
        gs.button2.setText("Blacksmith's Shop");
        gs.button3.setText("King's Castle");
        gs.button4.setText("Leave the Capital City");


        story.nextPosition1 = "inn";
        story.nextPosition2 = "blacksmithPlace";
        story.nextPosition3 = "";
        story.nextPosition4 = "startingPoint";


    }

    public void ApproachCasually(){

        gs.gameImage.setImageResource(R.drawable.castle);
        gs.gameText.setText("You're in the Capital City and Everything looks like normal. There are couple of places. \n What will you do?");

        gs.button1.setText("Dead Rat Inn");
        gs.button2.setText("Blacksmith's Shop");
        gs.button3.setText("King's Castle");
        gs.button4.setText("Leave the Capital City");


        story.nextPosition1 = "inn";
        story.nextPosition2 = "blacksmithPlace";
        story.nextPosition3 = "";
        story.nextPosition4 = "startingPoint";


    }

    public void DeadRat(){


        gs.gameImage.setImageResource(R.drawable.tavern);
        gs.gameText.setText("You're in the Dead Rat Inn, it isn't very crowd. you found a empty place yourself. \n What will you do?");

        gs.button1.setText("Order a beer");
        gs.button2.setText("talk to Stranger");
        gs.button3.setText("Look at the shadows");
        gs.button4.setText("Leave from inn");


        story.nextPosition1 = "healing"; // a pop up comes and ask you to buying beer if it is yes money lose and health increase
        story.nextPosition2 = "stranger"; //intent with string
        story.nextPosition3 = "assassin"; // intent with string
        story.nextPosition4 = "kingdom"; //backs


    }
    public void Blacksmith(){


        gs.gameImage.setImageResource(R.drawable.blacksmith);
        gs.gameText.setText("You're in Blacksmith's Shop, everywhere surrounded shiny crafts. \n What will you do?");

        gs.button1.setText("talk to blacksmith");
        gs.button2.setText("look at goods");
        gs.button3.setText("ask for any job");
        gs.button4.setText("Leave from inn");


        story.nextPosition1 = "blacksmith";
        story.nextPosition2 = "";
        story.nextPosition3 = "";
        story.nextPosition4 = "kingdom";


    }
    public void toBlacksmith(){
        String npc = "bob";

        Intent chatScreen = new Intent(gs,Conversation.class);
        chatScreen.putExtra("npc",npc);
        gs.startActivity(chatScreen);
        gs.overridePendingTransition(R.anim.slide_in_right,R.anim.slide_out_left);

    }
    public void toStranger(){

        String npc = "stranger";

        Intent chatScreen = new Intent(gs,Conversation.class);
        chatScreen.putExtra("npc",npc);
        gs.startActivity(chatScreen);
        gs.overridePendingTransition(R.anim.slide_in_right,R.anim.slide_out_left);
    }

    public void toThief(){
        String npc = "thief";

        Intent chatScreen = new Intent(gs,Conversation.class);
        chatScreen.putExtra("npc",npc);
        gs.startActivity(chatScreen);
        gs.overridePendingTransition(R.anim.slide_in_right,R.anim.slide_out_left);
    }


    public static boolean isFirstApproach() {
        return FirstApproach;
    }


}
