package com.example.firstprogram;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    // Method to debug program
    public static final String TAG = MainActivity.class.getSimpleName();

    Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (savedInstanceState == null) {
            Log.e(TAG, "This is bug");
        } else {
            Log.e(TAG, "Welcome to my program");
        }

        setContentView(R.layout.activity_main);
        button = new Button(this);
        button.setText("This is a button");
    }
}
