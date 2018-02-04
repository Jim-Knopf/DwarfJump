package my.company.dwarfjump;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;


public class Home extends AppCompatActivity implements View.OnClickListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        Button score=(Button)findViewById(R.id.scorebutton);
        score.setOnClickListener(this);

        Button game=(Button)findViewById(R.id.startbutton);
        game.setOnClickListener(this);

        Button aboutUS=(Button)findViewById(R.id.aboutus);
        aboutUS.setOnClickListener(this);
        }


    @Override
    public void onClick(View view) {

        switch (view.getId()) {

            case R.id.scorebutton:
                Intent scoreboard = new Intent(Home.this, scoreboard.class);
                startActivity(scoreboard);
                break;
            case R.id.startbutton:
                Intent startgame = new Intent(Home.this, MainActivity.class);
                startActivity(startgame);
                break;
            case R.id.aboutus:
                Intent aboutus = new Intent(Home.this, AboutUs.class);
                startActivity(aboutus);
                break;

            default:
                break;
        }

    }
}
