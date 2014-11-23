package com.example.jaiveerkothari.wildhacks_01;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.content.Intent;
import android.widget.RelativeLayout;
import android.widget.TextView;


public class ResultActivity extends Activity {



    private TextView tv1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Get the message from the intent
        Intent intent = getIntent();
        String message = intent.getStringExtra(MainActivity.EXTRA_MESSAGE);
        RelativeLayout rl = new RelativeLayout(this);


        //Create the text view
        TextView textView1 = new TextView(this);
        TextView textView2 = new TextView(this);
        float layoutHeight = rl.getHeight() / 20;
        float layoutWidth = rl.getWidth() / 20;

        //Log.d(" "+ Float.toString(layoutHeight) + "  " + Float.toString(layoutWidth));




        textView1.setTextSize(40);
        textView1.setText("Simon says: ");
        textView2.setTextSize(40);
        textView2.setText(message);

        rl.addView(textView1);

        rl.addView(textView2);




//        tv1.setTextSize(40);
//        tv1.setText(message);
        //Set the text view as the activity layout
        setContentView(rl);
        //setContentView(textView2);

        //setContentView(R.layout.activity_result);

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_result, menu);
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
