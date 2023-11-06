package com.example.gato;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        new CountDownTimer(5000, 1000) {
            public void onTick(long millisUntilFinished) {

            }
            public void onFinish() {
                paginaprincipalir();
            }
        }.start();

    }
    private void paginaprincipalir(){
        Intent intent = new Intent(this, MainActivity2.class);
        startActivity(intent);
    }
}