package my.company.dwarfjump;

import android.content.Intent;
import android.graphics.Color;
import android.media.MediaPlayer;
import android.os.CountDownTimer;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.util.Random;

public class MainActivity extends AppCompatActivity implements View.OnTouchListener, View.OnClickListener {


    protected View touchpad1;
    protected View touchpad2;
    protected View touchpad3;
    protected View touchpad4;
    public int counter = 0;
    protected String looserTime;

    protected int time1;
    protected int time2;
    protected int time3;
    protected int time4;
    RelativeLayout r3;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().hide();

        final MediaPlayer mp = MediaPlayer.create(MainActivity.this, R.raw.drunkendwarf
        );
        mp.start();

        final TextView countdownTimer = (TextView) findViewById(R.id.countdown);
        final TextView looserPlayer = (TextView) findViewById(R.id.looser);
        r3 = (RelativeLayout) findViewById(R.id.screenchangemain);

        final Button reset = (Button) findViewById(R.id.reset);
        reset.setOnClickListener(this);

        Random random = new Random();
        final int time = (random.nextInt(40000 - 5000) + 5000);
        final int halftime = time / 2 - 143;
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Toast.makeText(MainActivity.this, "TIME'S RUNNING OUT!!!", Toast.LENGTH_SHORT).show();
                r3.setBackgroundResource(R.drawable.drunkendwarfdifferent);

            }
        }, halftime);

        touchpad1 = findViewById(R.id.touchpad1);
        touchpad2 = findViewById(R.id.touchpad2);
        touchpad3 = findViewById(R.id.touchpad3);
        touchpad4 = findViewById(R.id.touchpad4);

        touchpad1.setOnTouchListener(this);
        touchpad2.setOnTouchListener(this);
        touchpad3.setOnTouchListener(this);
        touchpad4.setOnTouchListener(this);

        new CountDownTimer(time, 100){

            public void onTick(long millisUntilFinished){
                countdownTimer.setText(String.valueOf(counter));
                highestTime();
                counter++;

            }
            public void onFinish(){
                reset.setVisibility(View.VISIBLE);
                countdownTimer.setVisibility(View.INVISIBLE);
                looserPlayer.setVisibility(View.VISIBLE);
                mp.stop();
            }

        }.start();

    }

    @Override
    public boolean onTouch(View view, MotionEvent motionEvent) {

        final TextView player1Time = findViewById(R.id.player1_text);
        final TextView player2Time = findViewById(R.id.player2_text);
        final TextView player3Time = findViewById(R.id.player3_text);
        final TextView player4Time = findViewById(R.id.player4_text);

        switch(motionEvent.getAction())
        {
            case MotionEvent.ACTION_DOWN:

                view.setBackgroundColor(Color.RED);

                if (view.getId() == R.id.touchpad1){

                    player1Time.setVisibility(View.VISIBLE);
                    player1Time.setText(String.valueOf(counter));
                    time1 = counter;
                    //highestTime();

                } else if (view.getId() == R.id.touchpad2){

                    player2Time.setVisibility(View.VISIBLE);
                    player2Time.setText(String.valueOf(counter));
                    time2 = counter;
                    //highestTime();

                } else if (view.getId() == R.id.touchpad3){

                    player3Time.setVisibility(View.VISIBLE);
                    player3Time.setText(String.valueOf(counter));
                    time3 = counter;
                    //highestTime();

                } else if (view.getId() == R.id.touchpad4){

                    player4Time.setVisibility(View.VISIBLE);
                    player4Time.setText(String.valueOf(counter));
                    time4 = counter;
                    //highestTime();

                }

                break;
        }

        return true;
    }

    @Override
    public void onClick(View view) {

        Intent backStartGame = new Intent(MainActivity.this, StartGameActivity.class);
        startActivity(backStartGame);
    }

    public void highestTime(){

        /*int time1 = Integer.parseInt(String.valueOf(R.id.player1_text));
        int time2 = Integer.parseInt(String.valueOf(R.id.player2_text));
        int time3 = Integer.parseInt(String.valueOf(R.id.player3_text));
        int time4 = Integer.parseInt(String.valueOf(R.id.player4_text));*/

        final TextView looserPlayer = (TextView) findViewById(R.id.looser);

        if ((time1 < time2) && (time1 < time3) && (time1 < time4)){

            looserTime = "Player 1";

        } else if ((time2 < time1) && (time2 < time3) && (time2 < time4)){

            looserTime = "Player 2";

        } else if ((time3 < time1) && (time3 < time2) && (time3 < time4)){

            looserTime = "Player 3";

        } else if ((time4 < time1) && (time4 < time2) && (time4 < time3)){

            looserTime = "Player 4";

        } else if ((time1 == 0) && (time2 == 0) && (time3 == 0) && (time4 == 0)){

            looserTime = "all";
        }

        looserPlayer.setText("Looser: "+looserTime);
    }


}
