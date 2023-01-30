package com.example.blastedland;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.blastedland.monsters.Dragon;
import com.example.blastedland.monsters.Kraken;
import com.example.blastedland.monsters.MonsterAction;

public class BattleArea extends AppCompatActivity {


    public ImageView heroView, monsterView;
    public TextView monsterName, monsterHealth, descriptionText, heroHealth, heroName;
    public Button choose1, choose2, choose3, choose4;
    private MonsterAction monsterAction;
    private MediaPlayer player;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_battle_area);

        monsterView = findViewById(R.id.enemyView);
        heroView = findViewById(R.id.heroView);

        monsterName = findViewById(R.id.enemyName);
        monsterHealth = findViewById(R.id.enemyHealth);
        descriptionText = findViewById(R.id.battleText);

        heroHealth = findViewById(R.id.heroHealth1);
        heroName = findViewById(R.id.heroName);


        choose1 = findViewById(R.id.battleButton1);
        choose2 = findViewById(R.id.battleButton2);
        choose3 = findViewById(R.id.battleButton3);
        choose4 = findViewById(R.id.battleButton4);


        player = MediaPlayer.create(this,R.raw.battlesong);
        player.setLooping(true);
        player.start();


        String monster = getIntent().getStringExtra("monster");

        switch (monster) {

            case "kraken":
                monsterAction = new Kraken(this);
                break;
            case "dragon":
                monsterAction = new Dragon(this);
                break;

        }


    }

    @Override
    protected void onPause() {
        super.onPause();
        player.stop();
    }

    public void battleButton1(View v) {

    }

    public void battleButton2(View v) {

    }

    public void battleButton3(View v) {

    }

    public void battleButton4(View v) {

        monsterAction.battleChoose(this, choose4.getText().toString());


    }


}