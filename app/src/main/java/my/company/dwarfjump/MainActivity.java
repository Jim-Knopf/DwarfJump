package my.company.dwarfjump;

import android.graphics.Color;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.util.Random;

public class MainActivity extends AppCompatActivity implements View.OnTouchListener {


    protected View touchpad1;
    protected View touchpad2;
    protected View touchpad3;
    protected View touchpad4;
    public int counter = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().hide();

        final TextView label = (TextView) findViewById(R.id.countdown);

        Random random = new Random();
        final int time = (random.nextInt(40000 - 5000) + 5000);


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
                label.setText(String.valueOf(counter));
                counter++;
            }
            public void onFinish(){
                
            }
        }.start();

    }

    @Override
    public boolean onTouch(View view, MotionEvent motionEvent) {

        switch(motionEvent.getAction())
        {
            case MotionEvent.ACTION_DOWN:
                view.setBackgroundColor(Color.RED);
                break;
        }

        return true;
    }
}
