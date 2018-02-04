package my.company.dwarfjump;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;

public class MainActivity extends AppCompatActivity implements View.OnTouchListener {

    protected Pad pad;
    protected FrameLayout game;
    protected View touchpad;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().hide();

        pad = new Pad(this);

        game = (FrameLayout) findViewById(R.id.game);
        touchpad = findViewById(R.id.touchpad);

        touchpad.setOnTouchListener(this);
        game.addView(pad);
    }

    @Override
    public boolean onTouch(View view, MotionEvent motionEvent){

        float nextX = motionEvent.getX();
        float nextY = motionEvent.getY();

        if (nextX <= game.getWidth() - pad.getWidth()){
            pad.setX(motionEvent.getX());
        }
        if (nextY <= game.getHeight() - pad.getHeight()){
            pad.setY(motionEvent.getY());
        }

        return true;
    }
}
