package com.example.blastedland;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Build;
import android.os.Bundle;
import android.os.VibrationEffect;
import android.os.Vibrator;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.blastedland.monsters.Dragon;
import com.example.blastedland.monsters.Kraken;
import com.example.blastedland.monsters.MonsterAction;
import com.example.blastedland.monsters.MonsterEntity;
import com.example.blastedland.player.UI;

public class BattleArea extends AppCompatActivity {


    public ImageView heroView, monsterView, heroTurnView, monsterTurnView, popupImage;
    public TextView monsterName, monsterHealth, descriptionText, heroHealth, heroName, popupText;
    public Button choose1, choose2, choose3, choose4, popupButton;
    public MonsterAction monsterAction;
    private MonsterEntity monsterEntity;
    private MediaPlayer player;
    private UI ui;
    public RelativeLayout color;
    private LinearLayout layout;
    private View popUpView;
    public Intent title;
    public Vibrator vibe;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_battle_area);

        ui = UI.getInstance();

        vibe = (Vibrator) BattleArea.this.getSystemService(this.VIBRATOR_SERVICE);

        layout = findViewById(R.id.layout2);


        title = new Intent(this, TitleScreen.class);


        LayoutInflater inflater = (LayoutInflater) getSystemService(LAYOUT_INFLATER_SERVICE);
        popUpView = inflater.inflate(R.layout.gamepopup, null);
        color = popUpView.findViewById(R.id.popuplayout);

        monsterView = findViewById(R.id.enemyView);
        heroView = findViewById(R.id.heroView);
        monsterTurnView = findViewById(R.id.enemyTurn);
        heroTurnView = findViewById(R.id.heroTurn);

        monsterName = findViewById(R.id.enemyName);
        monsterHealth = findViewById(R.id.enemyHealth);
        descriptionText = findViewById(R.id.battleText);

        heroHealth = findViewById(R.id.heroHealth1);
        heroName = findViewById(R.id.heroName);

        heroHealth.setText(ui.health + " Health");

        choose1 = findViewById(R.id.battleButton1);
        choose2 = findViewById(R.id.battleButton2);
        choose3 = findViewById(R.id.battleButton3);
        choose4 = findViewById(R.id.battleButton4);

        popupImage = popUpView.findViewById(R.id.popupImage);
        popupText = popUpView.findViewById(R.id.popupText);
        popupButton = popUpView.findViewById(R.id.popupButton);


        player = MediaPlayer.create(this, R.raw.battlesong);
        player.setLooping(true);
        player.start();


        String monster = getIntent().getStringExtra("monster");

        switch (monster) {

            case "kraken":
                monsterAction = new Kraken(this);
                monsterEntity = new Kraken(this);

                break;
            case "dragon":
                monsterAction = new Dragon(this);
                monsterEntity = new Dragon(this);
                break;

        }


    }

    @Override
    protected void onPause() {
        super.onPause();
        player.stop();
    }


    public void monsterAttack() {
        Runnable monsterAttackTimer = new Runnable() {
            @Override
            public void run() {
                try {
                    synchronized (this) {
                        wait(2000);

                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {

                                if (monsterEntity.getMonsterHealth() > 0) {

                                    monsterAction.attack(ui, BattleArea.this);
                                }

                                allButtonUnlocked();

                                if (ui.health <= 0) {


                                    if(Build.VERSION.SDK_INT >= 26){

                                        VibrationEffect vibrationEffect1 = VibrationEffect.createOneShot(1000, VibrationEffect.DEFAULT_AMPLITUDE);
                                        vibe.vibrate(vibrationEffect1);
                                    }
                                    else{
                                        vibe.vibrate(1000);
                                    }

                                    allButtonLocked();
                                    popupImage.setImageResource(R.drawable.death);
                                    popupText.setText("YOU DIED.");
                                    popupButton.setText("Exit");


                                    createPopUpWindow();
                                } else if (monsterEntity.getMonsterHealth() <= 0) {

                                    allButtonLocked();
                                    popupImage.setImageResource(R.drawable.money_bag);
                                    popupText.setText("You Won! \n You have earned 20 silver!");
                                    popupButton.setText("Take");

                                    createPopUpWindow();
                                }

                            }
                        });
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };
        Thread thread = new Thread(monsterAttackTimer);
        thread.start();
    }


    public void battleButton1(View v) {


    }

    public void battleButton2(View v) {


        monsterAttack();

        allButtonLocked();

        ui.heroAttack(monsterEntity, this);


    }

    public void battleButton3(View v) {

    }

    public void battleButton4(View v) {

        monsterAction.battleChoose(this, choose4.getText().toString());


    }

    protected void createPopUpWindow() {


        int width = ViewGroup.LayoutParams.MATCH_PARENT;
        int height = ViewGroup.LayoutParams.WRAP_CONTENT;
        boolean focusable = false;
        color.setBackgroundColor(0);


        PopupWindow popupWindow = new PopupWindow(popUpView, width, height, focusable);
        layout.post(() -> popupWindow.showAtLocation(layout, Gravity.CENTER, 0, 0));


        if (ui.health <= 0) {

            popupButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {


                    ui.silver = 0;
                    ui.key = 0;
                    ui.health = 20;
                    ui.reincarnation = 0;

                    popupWindow.dismiss();
                    layout.removeView(popUpView);
                    startActivity(title);
                    overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);


                }
            });

        } else if (monsterEntity.getMonsterHealth() <= 0) {

            popupButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    ui.silver += 20;
                    GameScreen.moneyTx.setText("= " + ui.silver);

                    popupWindow.dismiss();
                    layout.removeView(popUpView);
                    finish();
                    overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);


                }
            });

        }


    }

    public void allButtonLocked() {

        choose1.setClickable(false);
        choose2.setClickable(false);
        choose3.setClickable(false);
        choose4.setClickable(false);
    }

    public void allButtonUnlocked() {

        choose1.setClickable(true);
        choose2.setClickable(true);
        choose3.setClickable(true);
        choose4.setClickable(true);

    }

}