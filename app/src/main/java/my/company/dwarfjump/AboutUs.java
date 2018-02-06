package my.company.dwarfjump;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class AboutUs extends AppCompatActivity implements View.OnTouchListener{

    Button b1;
    RelativeLayout r1;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about_us);

        b1 = (Button) findViewById(R.id.drinklittledwarf);
        r1 = (RelativeLayout) findViewById(R.id.aboutus);

        b1.setOnTouchListener(new View.OnTouchListener(){




            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {


                switch (motionEvent.getAction()){
                    case MotionEvent.ACTION_DOWN:
                        r1.setBackgroundResource(R.drawable.drinkindwarf);
                        break;
                    case MotionEvent.ACTION_UP:
                        r1.setBackgroundResource(R.drawable.drunkendwarf_withbackground);
                        break;


                }





                return false;
            }
        });




    }

    @Override
    public boolean onTouch(View view, MotionEvent motionEvent) {
        return false;
    }
}



