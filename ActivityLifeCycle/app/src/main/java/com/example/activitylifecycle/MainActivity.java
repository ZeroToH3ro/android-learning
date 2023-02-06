package com.example.activitylifecycle;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
//    private static final String TAG = MainActivity.class.getSimpleName();
    private static final String TAG = "Status ";
    EditText etFirstNumber, etSecondNumber;
    TextView tvResult;
    Button sum;

    int firstNumber;
    int secondNumber;
    int result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etFirstNumber = findViewById(R.id.etFirstNumber);
        etSecondNumber = findViewById(R.id.etSecondNumber);
        tvResult = findViewById(R.id.tvResult);
        sum = findViewById(R.id.sum);

        sum.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(view == sum) {
                    if(etFirstNumber.getText().toString().isEmpty() || etSecondNumber.getText().toString().isEmpty()) {
                        Toast.makeText(getBaseContext(), "Please enter your number!!!   ", Toast.LENGTH_LONG).show();
                    } else {
                        firstNumber = Integer.parseInt(etFirstNumber.getText().toString());
                        secondNumber = Integer.parseInt(etSecondNumber.getText().toString());
                        result = firstNumber + secondNumber;
                        tvResult.setText(String.valueOf(result));
                    }
                }
            }
        });
        if(savedInstanceState != null) {
            etFirstNumber.setText(String.valueOf(savedInstanceState.getInt("firstNumber")));
            etSecondNumber.setText(String.valueOf(savedInstanceState.getInt("secondNumber")));
            tvResult.setText(String.valueOf(savedInstanceState.getInt("result")));
        }
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d(TAG, "on restart");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(TAG, "on stop");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d(TAG, "on pause");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d(TAG, "on start");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "on destroy");
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        if(!tvResult.getText().toString().isEmpty()) {
            outState.putInt("firstNumber", Integer.parseInt(etFirstNumber.getText().toString()));
            outState.putInt("secondNumber", Integer.parseInt(etSecondNumber.getText().toString()));
            outState.putInt("result", Integer.parseInt(tvResult.getText().toString()));
        }
        Log.d(TAG, "onSavedInstanceState: ");
        super.onSaveInstanceState(outState);
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        Log.d(TAG, "onRestoreInstanceState: ");
    }
}