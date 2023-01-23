package com.example.blastedland.kingdom.places;

import com.example.blastedland.GameScreen;
import com.example.blastedland.R;
import com.example.blastedland.Story;
import com.example.blastedland.player.UI;

public class Square {


    private Story story;
    private BlacksmithP blacksmithP;
    private Inn inn;
    private GameScreen gs;


    private static boolean FirstApproach = true;




    public Square(Story story, GameScreen gs){


        this.story = story;
        this.blacksmithP = blacksmithP;
        this.inn = inn;
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
        story.nextPosition2 = "blacksmith";
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
        story.nextPosition2 = "blacksmith";
        story.nextPosition3 = "";
        story.nextPosition4 = "startingPoint";

    }


    public static boolean isFirstApproach() {
        return FirstApproach;
    }
}
