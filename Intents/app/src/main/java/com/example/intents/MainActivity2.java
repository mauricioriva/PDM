package com.example.intents;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        // Get the Intent that started this activity and extract the string
        Intent intent = getIntent();
        String message = intent.getStringExtra(MainActivity.MESSAGE_ENTERED);

        // Capture the layout's TextView and set the string as its text
        TextView textView = findViewById(R.id.text_entered);
        textView.setText(message);
    }

    public void openMaps(View view){
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("geo:19.32469982350001,-99.17896073863236"));
        intent.setFlags(Intent.FLAG_ACTIVITY_NO_HISTORY|Intent.FLAG_DEBUG_LOG_RESOLUTION);
        startActivity(intent);
    }

    public void openWeb(View view){
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.fciencias.unam.mx/"));
        intent.setFlags(Intent.FLAG_ACTIVITY_NO_HISTORY|Intent.FLAG_DEBUG_LOG_RESOLUTION);
        startActivity(intent);
    }

}