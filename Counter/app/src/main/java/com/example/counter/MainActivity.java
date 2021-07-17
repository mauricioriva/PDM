package com.example.counter;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView mShowCount;
    int mCount;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mShowCount = (TextView) findViewById(R.id.counter);
        // ---->
        Button increaseButton = (Button) findViewById(R.id.increase);
        increaseButton.setOnClickListener(increaseListener);
        // ---->
        Button resetButton = (Button) findViewById(R.id.reset);
        resetButton.setOnClickListener(resetListener);
    }

    private View.OnClickListener increaseListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            ++mCount;
            if (mShowCount != null){
                mShowCount.setText(Integer.toString(mCount));
            }
        }
    };

    private View.OnClickListener resetListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            mCount = 0;
            if (mShowCount != null){
                mShowCount.setText(Integer.toString(mCount));
            }
        }
    };
}
