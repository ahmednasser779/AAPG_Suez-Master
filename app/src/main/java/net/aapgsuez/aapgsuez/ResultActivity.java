package net.aapgsuez.aapgsuez;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


public class ResultActivity extends AppCompatActivity {

    TextView result , desc;
    Button finish , again;
    int score;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        toolbar.setTitle("IQ Test");

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        result = findViewById(R.id.result_txt);
        desc = findViewById(R.id.desc_txt);
        finish = findViewById(R.id.finish_btn);
        again  = findViewById(R.id.again_btn);

        finish.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent mainIntent = new Intent(ResultActivity.this , MainActivity.class);
                startActivity(mainIntent);
                finish();
            }
        });

        again.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent testIntent = new Intent(ResultActivity.this ,TestActivity.class);
                startActivity(testIntent);
                finish();
            }
        });

        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            score = extras.getInt("result");
        }
        result.setText("Result : "+score + " / 10");

        if(score == 0 || score == 1 || score == 2){
            desc.setText("Your IQ is very low");
        }
        else if(score == 3 || score == 4){
            desc.setText("Your IQ is low");
        }
        else if(score == 5 || score == 6){
            desc.setText("Your IQ is medium");
        }
        else if(score == 7 || score == 8){
            desc.setText("Your IQ is high");
        }
        else if(score == 9){
            desc.setText("Your IQ is very high");
        }
        else if(score == 10){
            desc.setText("Your IQ is outstanding");
        }
        else {
            desc.setText(" ");
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            // Respond to the action bar's Up/Home button
            case android.R.id.home:
                onBackPressed();
                return true;
            default:
                recreate();

        }
        return super.onOptionsItemSelected(item);
    }
}
