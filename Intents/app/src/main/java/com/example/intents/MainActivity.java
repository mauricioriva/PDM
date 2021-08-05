package com.example.intents;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    public static final String MESSAGE_ENTERED = "Name Entered";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /** Called when the user taps the Send button */
    public void sendMessage(View view) {
        Intent intent = new Intent(this, MainActivity2.class);
        EditText editText = (EditText) findViewById(R.id.text_input);
        String message = editText.getText().toString();
        intent.putExtra(MESSAGE_ENTERED, message);
        //intent.setFlags(Intent.FLAG_ACTIVITY_NO_HISTORY|Intent.FLAG_DEBUG_LOG_RESOLUTION);
        startActivity(intent);
    }

}