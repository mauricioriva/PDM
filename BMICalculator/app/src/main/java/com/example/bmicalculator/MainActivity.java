package com.example.bmicalculator;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {

    EditText editHeight;
    EditText editWeight;
    TextView showBMI;
    TextView showCategory;
    String category;
    double height = 1.80;
    double weight = 80;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        showBMI = (TextView) findViewById(R.id.bmi_result);
        showCategory = (TextView) findViewById(R.id.category);
        // ----->
        editWeight = (EditText) findViewById(R.id.weight_input);
        editWeight.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                boolean handled = false;
                if (actionId == EditorInfo.IME_ACTION_NEXT){
                    weight = Double.parseDouble(editWeight.getText().toString());
                    InputMethodManager inputMethodManager = (InputMethodManager) v.getContext().getSystemService(Context.INPUT_METHOD_SERVICE);
                    inputMethodManager.hideSoftInputFromWindow(v.getWindowToken(), 0);
                    handled = true;
                }
                return handled;
            }
        });
        // ----->
        editHeight = (EditText) findViewById(R.id.height_input);
        editHeight.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                boolean handled = false;
                if (actionId == EditorInfo.IME_ACTION_NEXT){
                    height = Double.parseDouble(editHeight.getText().toString());
                    InputMethodManager inputMethodManager = (InputMethodManager) v.getContext().getSystemService(Context.INPUT_METHOD_SERVICE);
                    inputMethodManager.hideSoftInputFromWindow(v.getWindowToken(), 0);
                    handled = true;
                }
                return handled;
            }
        });
        // ----->
        Button calculateIBM = (Button) findViewById(R.id.calculate_button);
        calculateIBM.setOnClickListener(calculateIBMListener);
    }

    private View.OnClickListener calculateIBMListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            double bmi = weight / (height * height);
            DecimalFormat df = new DecimalFormat("#.#");
            double BMI_trimmed = Double.parseDouble(df.format(bmi));
            showBMI.setText(Double.toString(BMI_trimmed));
            setCategory(BMI_trimmed);
            showCategory.setText(category);
        }
    };

    private void setCategory(double bmi) {
        if (bmi < 15){
            category = getString(R.string.very_severely_underweight);
        } else if (15 <= bmi && bmi < 16){
            category = getString(R.string.severely_underweight);
        } else if (16 <= bmi && bmi < 18.5){
            category = getString(R.string.underweight);
        } else if (18.5 <= bmi && bmi < 25){
            category = getString(R.string.normal);
        } else if (25 <= bmi && bmi < 30){
            category = getString(R.string.overweight);
        } else if (30 <= bmi && bmi < 35){
            category = getString(R.string.obese_class_1);
        } else if (35 <= bmi && bmi < 40){
            category = getString(R.string.obese_class_2);
        } else {
            category = getString(R.string.obese_class_3);
        }
    }

    private static final String LOG_TAG = MainActivity.class.getSimpleName();
}