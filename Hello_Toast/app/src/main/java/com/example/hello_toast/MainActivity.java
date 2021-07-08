package com.example.hello_toast;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    TextView mShowCount;
    int mCount;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mShowCount = (TextView) findViewById(R.id.center_text);
    }

    public void showToast(View view){
        Toast toast = Toast.makeText(this, R.string.text_center_label_toast, Toast.LENGTH_LONG);
        toast.show();
    }

    public void countUp(View view){
        ++mCount;
        if (mShowCount != null){
            mShowCount.setText(Integer.toString(mCount));
        }
    }

    public void countDown(View view){
        --mCount;
        if (mShowCount != null){
            mShowCount.setText(Integer.toString(mCount));
        }
    }
}