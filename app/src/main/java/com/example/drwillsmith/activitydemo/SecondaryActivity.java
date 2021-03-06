package com.example.drwillsmith.activitydemo;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class SecondaryActivity extends AppCompatActivity {

    public final static String RESPONSE_MESSAGE="com.example.drwillsmith.MESSAGE";
    TextView receiver;
    Button acknowledgeButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_secondary);

        receiver = (TextView) findViewById(R.id.textView);
        acknowledgeButton = (Button) findViewById(R.id.button2);

        Intent intent=getIntent();
        String message = intent.getStringExtra(MainActivity.EXTRA_MESSAGE);
        receiver.setText("Caught: "+message);


        acknowledgeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent returnIntent = getIntent();
                returnIntent.putExtra(RESPONSE_MESSAGE,"Acknowlegement for Activity");
                setResult(RESULT_OK,returnIntent);
                finish();
            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_secondary, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
