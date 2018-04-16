package com.example.myfirstapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    private final String LOG_TAG = "Main Activity";
    public static final String EXTRA_MESSAGE = "com.example.myfirstapp.MESSAGE";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.i(LOG_TAG, "onCreate main Method");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    /** Called when the user taps the Send button */
    public void sendMessage(View view) {
        Intent intent = new Intent(this, DisplayMessageActivity.class);
        EditText editText = (EditText) findViewById(R.id.editText);
        String message = editText.getText().toString();
        intent.putExtra(EXTRA_MESSAGE, message);
        startActivity(intent);
    }

    public void singleTopMode(View view) {
        Intent intent = new Intent(this, DifferentLaunchMode.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP);
        startActivity(intent);
    }
    public void standardMode(View view) {
        Log.i(LOG_TAG, "standard Method");
        Intent intent = new Intent(this, DifferentLaunchMode.class);
        Log.i(LOG_TAG, "intent Created");
        startActivity(intent);
    }
    public void singleTaskMode(View view) {
        Intent intent = new Intent(this, DifferentLaunchMode.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);
    }
    public void singleInstanceMode(View view) {
        Intent intent = new Intent(this, DifferentLaunchMode.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(intent);
    }
    /** Called when the user taps the recycleView button */
    public void recycleView(View view) {
        Intent intent = new Intent(this, ReclycleViewExample.class);
        startActivity(intent);
    }
    /** Called when the user taps the recycleView button */
    public void weatherApp(View view) {
        Intent intent = new Intent(this, WeatherApp.class);
        startActivity(intent);
    }

}
