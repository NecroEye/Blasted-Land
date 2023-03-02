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
import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.LoadAdError;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.initialization.InitializationStatus;
import com.google.android.gms.ads.initialization.OnInitializationCompleteListener;
import com.google.android.gms.games.GamesSignInClient;
import com.google.android.gms.games.PlayGames;
import com.google.android.gms.games.PlayGamesSdk;

public class TitleScreen extends AppCompatActivity {


    private ImageView titleImage;
    private TextView screenTitle, version;
    private Button start;
    private MediaPlayer player;
    private AdView adView, adView2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_title_screen);

        MobileAds.initialize(this, new OnInitializationCompleteListener() {
            @Override
            public void onInitializationComplete(InitializationStatus initializationStatus) {
            }
        });


        PlayGamesSdk.initialize(this);

        adView = findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        adView.loadAd(adRequest);

        adView2 = findViewById(R.id.adView2);
        AdRequest adRequest1 = new AdRequest.Builder().build();
        adView2.loadAd(adRequest1);

        titleImage = findViewById(R.id.titleImageView);
        screenTitle = findViewById(R.id.titleTextView);
        version = findViewById(R.id.versionTitle);
        start = findViewById(R.id.startButton);

        YoYo.with(Techniques.Tada).duration(1000).delay(1000).repeat(1).playOn(start);

        //App Admob ID:
        //ca-app-pub-1436561055108702~6882835448

        player = MediaPlayer.create(this, R.raw.mainsong);
        player.setLooping(true);
        player.start();

        //Real Banner ID Top
        // ca-app-pub-1436561055108702/2902447584

        //Real Banner ID Bottom
        // ca-app-pub-1436561055108702/2890569790


        //Test-Banner Ad ID
        //ca-app-pub-3940256099942544/6300978111



        adView.setAdListener(new AdListener() {
            @Override
            public void onAdClicked() {
                // Code to be executed when the user clicks on an ad.
            }

            @Override
            public void onAdClosed() {
                // Code to be executed when the user is about to return
                // to the app after tapping on an ad.
            }

            @Override
            public void onAdFailedToLoad(LoadAdError adError) {
                // Code to be executed when an ad request fails.

            }

            @Override
            public void onAdImpression() {
                // Code to be executed when an impression is recorded
                // for an ad.

                System.out.println("failed");

            }

            @Override
            public void onAdLoaded() {
                // Code to be executed when an ad finishes loading.

                System.out.println("ad is loaded");
            }

            @Override
            public void onAdOpened() {
                // Code to be executed when an ad opens an overlay that
                // covers the screen.
            }
        });


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
        overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);

    }


    public void credits(View v) {


        Toast.makeText(this, "Developed by Muratcan Gözüm", Toast.LENGTH_LONG).show();

    }

    public void signInPlayService() {

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