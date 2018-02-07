package my.company.dwarfjump;

import android.content.Intent;
import android.media.Image;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.Timer;
import java.util.TimerTask;

public class LoadingScreen extends AppCompatActivity {

    private TextView start;
    private ImageView dwarf;
    public static int count=0;
    RelativeLayout r2;
    int[] drawablearray=new int[]{R.drawable.drinkindwarf,R.drawable.drunkendwarf_withbackground};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loading_screen);
        getSupportActionBar().hide();

        r2 = (RelativeLayout) findViewById(R.id.loadingpage2);
        Timer t = new Timer();
        t.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {

                runOnUiThread(new Runnable() // run on ui thread
                {
                    public void run() {
                        if (count < drawablearray.length) {

                            r2.setBackgroundResource(drawablearray[count]);
                            count += (count+1)%drawablearray.length;
                        }
                    }
                });
            }
        }, 1000, 1500);

        int secondsDelayed = 1;
        new Handler().postDelayed(new Runnable() {
            public void run() {
                startActivity(new Intent(LoadingScreen.this, Home.class));
                finish();
            }
        }, secondsDelayed * 3000);




    }
}
