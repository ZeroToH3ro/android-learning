package com.example.fragmentlesson;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements DemoFragmentInterface{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction transaction = fragmentManager.beginTransaction();

        FirstFragment firstFragment = new FirstFragment();
        transaction.add(R.id.containerTop, firstFragment);

        SecondFragment secondFragment = new SecondFragment();
        transaction.add(R.id.containerBottom, secondFragment);
        transaction.commit();
    }

    @Override
    public void sendData(String name, String age) {
        SecondFragment secondFragment = (SecondFragment) getSupportFragmentManager().findFragmentById(R.id.containerBottom);
        if (secondFragment != null || secondFragment.isInLayout()){
            secondFragment.showInfor(name,age);
        }else {
            Toast.makeText(getApplicationContext(),"???",Toast.LENGTH_LONG).show();
        }
    }
}