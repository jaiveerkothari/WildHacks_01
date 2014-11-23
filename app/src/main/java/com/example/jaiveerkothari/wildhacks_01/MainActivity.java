package com.example.jaiveerkothari.wildhacks_01;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import java.util.Random;
import java.util.ArrayList;
import android.content.Intent;

import javax.xml.transform.Result;


public class MainActivity extends Activity {

    public final static String EXTRA_MESSAGE = "com.example.jaiveerkothari.MESSAGE";
    private Button bt;
    private Button bt2;

    private ListView lv;
    private ArrayList<String> strArr;
    private ArrayAdapter<String> adapter;
    private EditText et;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bt=(Button) findViewById(R.id.button1);
        bt2=(Button) findViewById(R.id.button2);

        lv = (ListView) findViewById(R.id.listView1);
        et=(EditText) findViewById(R.id.editText1);

        strArr=new ArrayList<String>();

        adapter= new ArrayAdapter<String>(getApplicationContext(),android.R.layout.simple_list_item_1,strArr);

        lv.setAdapter(adapter);

        bt.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {

                if (et.getText().length() != 0) { // if the text field is empty, we don't wanna add it to the arraylist
                    strArr.add(et.getText().toString());
                } else if (et.getText().equals("Nic")) {
                    // add code to cover entire listView with a Nicolas
                }
                et.setText("");
                adapter.notifyDataSetChanged();
            }
        });




        // We don't want to be able to click when there are no elements in the list; would give us indexoutofrange

        bt2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            if (strArr.size() > 0) {
                int len = strArr.size();
                int simonAns = 0;
                Random rand = new Random();
                simonAns = rand.nextInt(len);

                // Testing if an output result is achieved through
                String simonArg = strArr.get(simonAns);

                Log.d("simon button", "Simon: " + simonArg);
                adapter.notifyDataSetChanged();

                Intent intent = new Intent(MainActivity.this, ResultActivity.class);
                EditText editText = (EditText) findViewById(R.id.editText1);

                String message = simonArg;

                intent.putExtra(EXTRA_MESSAGE, message);
                startActivity(intent);
                }
            }
        });




    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
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
