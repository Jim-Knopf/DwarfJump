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
        }


    @Override
    public void onClick(View view) {

        Intent scoreboard = new Intent(Home.this, scoreboard.class);

        startActivity(scoreboard);

    }
}
