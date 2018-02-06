package my.company.dwarfjump;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class StartGameActivity extends AppCompatActivity implements View.OnClickListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start_game);

        Button start_countdown = (Button) findViewById(R.id.start_game_button);
        start_countdown.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {

        Intent start_timer = new Intent(StartGameActivity.this, MainActivity.class);
        startActivity(start_timer);

    }
}
