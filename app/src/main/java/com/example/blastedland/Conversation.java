package com.example.blastedland;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.blastedland.kingdom.Npcs.Blacksmith;
import com.example.blastedland.kingdom.Npcs.Npc;
import com.example.blastedland.kingdom.Npcs.Stranger;
import com.example.blastedland.kingdom.Npcs.Thief;

public class Conversation extends AppCompatActivity {


    public ImageView npcImage, LocationImage;
    public TextView npcText, npcTextName;
    public Button heroButton1, heroButton2, heroButton3, heroButton4;
    private String specialWord;
    public Blacksmith blacksmith;
    private Npc actions;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_conversation);

        blacksmith = new Blacksmith(this);

        npcImage = findViewById(R.id.npcImage);
        LocationImage = findViewById(R.id.locationImage);
        npcText = findViewById(R.id.npcText);
        npcTextName = findViewById(R.id.npcName);
        heroButton1 = findViewById(R.id.heroButton1);
        heroButton2 = findViewById(R.id.heroButton2);
        heroButton3 = findViewById(R.id.heroButton3);
        heroButton4 = findViewById(R.id.heroButton4);

        String npc = getIntent().getStringExtra("npc");

        switch (npc){
            case "bob":

                actions = new Blacksmith(this);

                npcImage.setImageResource(R.drawable.elf);
                npcTextName.setText("Blacksmith");
                npcText.setText("Welcome to my gorgeous store!");
                heroButton1.setText("Hey");
                heroButton2.setText("i am looking for job");
                heroButton3.setText("have you any advice?");
                heroButton4.setText("Leave");
                LocationImage.setImageResource(R.drawable.blacksmith); break;

            case "stranger":

                actions = new Stranger(this);

                npcImage.setImageResource(R.drawable.stranger);
                npcTextName.setText("Stranger");
                npcText.setText("Do you want something?");
                heroButton1.setText("'Sup");
                heroButton2.setText("You look like a sorcerer");
                heroButton3.setText("What is that dress weirdo?");
                heroButton4.setText("Leave");
                LocationImage.setImageResource(R.drawable.tavern); break;

            case "thief":

                actions = new Thief(this);

                npcImage.setImageResource(R.drawable.assasin);
                npcTextName.setText("Assassin");
                npcText.setText("HeHeHe lookin' for some trouble bastard!");
                heroButton1.setText("N-No, i am just chilling");
                heroButton2.setText("Do you know who i am?");
                heroButton3.setText("give it some silver (10)");
                heroButton4.setText("Leave"); // Run away ile değiştir square atsın direkt
                LocationImage.setImageResource(R.drawable.tavern); break;
        }



    }





    public void hButton1(View v) {

        specialWord = heroButton1.getText().toString();
        actions.talking(specialWord);


    }

    public void hButton2(View v) {

        specialWord = heroButton2.getText().toString();
        actions.talking(specialWord);



    }

    public void hButton3(View v) {

        specialWord = heroButton3.getText().toString();
        actions.talking(specialWord);


    }

    public void hButton4(View v) {

        specialWord = heroButton4.getText().toString();
        actions.talking(specialWord);


    }

    public String getSpecialWord() {
        return specialWord;

    }
}