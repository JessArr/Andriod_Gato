package com.example.gato;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity3 extends AppCompatActivity {

    private TextView text1;
    private TextView text2;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        text1=findViewById(R.id.text1x2);
        text2=findViewById(R.id.text202);
        Bundle bundle =getIntent().getExtras();
        int g0=bundle.getInt("0G");
        int gx=bundle.getInt("0X");
        text1.setText(String.valueOf(gx));
        text2.setText(String.valueOf(g0));
        Button botonregresar=(Button) findViewById(R.id.botonregresar);

        botonregresar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                paginaprincipalir();
            }
        });
    }
    private void paginaprincipalir(){
        onBackPressed();
    }
}