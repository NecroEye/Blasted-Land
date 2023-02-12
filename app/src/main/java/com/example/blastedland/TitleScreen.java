package com.example.blastedland;

import static com.google.android.material.internal.ContextUtils.getActivity;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.daimajia.androidanimations.library.Techniques;
import com.daimajia.androidanimations.library.YoYo;
import com.example.blastedland.monsters.Dragon;
import com.example.blastedland.monsters.Giant;
import com.example.blastedland.mountain.AshenMountain;
import com.example.blastedland.player.UI;
import com.google.android.gms.games.GamesSignInClient;
import com.google.android.gms.games.PlayGames;
import com.google.android.gms.games.PlayGamesSdk;

public class TitleScreen extends AppCompatActivity {


    private ImageView titleImage;
    private TextView screenTitle, version;
    private Button start;
    private MediaPlayer player;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_title_screen);

        PlayGamesSdk.initialize(this);

        titleImage = findViewById(R.id.titleImageView);
        screenTitle = findViewById(R.id.titleTextView);
        version = findViewById(R.id.versionTitle);
        start = findViewById(R.id.startButton);

        YoYo.with(Techniques.Tada).duration(1000).delay(1000).repeat(1).playOn(start);


        player = MediaPlayer.create(this, R.raw.mainsong);
        player.setLooping(true);
        player.start();


    }

    @Override
    protected void onPause() {
        super.onPause();
        player.stop();
    }

    public void toGameScreen(View v) {

        UI.powerfulAmount = 2;
        Giant.isGiantFounded = false;
        Giant.isGainedItsHead = false;
        Dragon.isKilledBefore = false;
        GameScreen.setIsOpen(false);
        AshenMountain.isSeen = false;
        AshenMountain.place1 = "";
        AshenMountain.place2 = "";
        AshenMountain.place3 = "";

        Intent gameScreen = new Intent(this, GameScreen.class);
        player.stop();
        startActivity(gameScreen);
        overridePendingTransition(R.anim.slide_in_right,R.anim.slide_out_left);

    }

    public void credits(View v) {

        Toast.makeText(this, "Developed by Muratcan Gözüm", Toast.LENGTH_LONG).show();

    }

    public void signInPlayService(){

        @SuppressLint("RestrictedApi") GamesSignInClient gamesSignInClient = PlayGames.getGamesSignInClient(getActivity(this));


        gamesSignInClient.isAuthenticated().addOnCompleteListener(isAuthenticatedTask -> {
            boolean isAuthenticated =
                    (isAuthenticatedTask.isSuccessful() &&
                            isAuthenticatedTask.getResult().isAuthenticated());

            if (isAuthenticated) {

                PlayGames.getPlayersClient(this).getCurrentPlayer().addOnCompleteListener(mTask -> {
                            // Get PlayerID with mTask.getResult().getPlayerId()
                        }
                );

            } else {
               return;
            }
        });

    }


}