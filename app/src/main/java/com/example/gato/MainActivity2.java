package com.example.gato;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.Arrays;

public class MainActivity2 extends AppCompatActivity implements View.OnClickListener {
    private  boolean turno = true;
    private final char[] tablero=new char[9];

    private final boolean[] tableroBlock={false,false,false,false,false,false,false,false,false};

    private final TextView[] Botones=new TextView[9];
    private int VictoriasX;

    private int Victorias0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        Button botonNuevo = findViewById(R.id.BotonNuevo);
        Button botonpantalla3 = findViewById(R.id.pantallamarcador);
        Button botonReiniciar = findViewById(R.id.BotonReiniciar);

        Botones[0]= findViewById(R.id.Cuadro);
        Botones[1]= findViewById(R.id.Cuadro1);
        Botones[2]= findViewById(R.id.Cuadro2);
        Botones[3]= findViewById(R.id.Cuadro3);
        Botones[4]= findViewById(R.id.Cuadro4);
        Botones[5]= findViewById(R.id.Cuadro5);
        Botones[6]= findViewById(R.id.Cuadro6);
        Botones[7]= findViewById(R.id.Cuadro7);
        Botones[8]= findViewById(R.id.Cuadro8);

        botonpantalla3.setOnClickListener(this);
        botonNuevo.setOnClickListener(this);
        botonReiniciar.setOnClickListener(this);

        for (TextView bone : Botones) {
            bone.setOnClickListener(this);
        }
        turnojugador();
    }

    @Override
    public void onClick(View v) {
        if (v.getId()==R.id.BotonNuevo){
            Victorias0=0;
            VictoriasX=0;
            LimpiarTablero();
            DesBloquearTablero();
        } else if (v.getId() == R.id.BotonReiniciar) {
            LimpiarTablero();
            DesBloquearTablero();
        } else if (v.getId()==R.id.pantallamarcador) {

            Intent i=new Intent(this, MainActivity3.class);
            Bundle bundle = new Bundle();
            bundle.putInt("0G",Victorias0);
            bundle.putInt("0X",VictoriasX);
            i.putExtras(bundle);
            startActivity(i);
        }else if (v.getId()==R.id.Cuadro) {
            TextView boton=(TextView) findViewById(v.getId());
            MarcarCasilla(0,boton);
        }
        else if (v.getId()==R.id.Cuadro1) {
            TextView boton=(TextView) findViewById(v.getId());
            MarcarCasilla(1,boton);
        }
        else if (v.getId()==R.id.Cuadro2) {
            TextView boton=(TextView) findViewById(v.getId());
            MarcarCasilla(2,boton);
        }
        else if (v.getId()==R.id.Cuadro3) {
            TextView boton=(TextView) findViewById(v.getId());
            MarcarCasilla(3,boton);
        }
        else if (v.getId()==R.id.Cuadro4) {
            TextView boton=(TextView) findViewById(v.getId());
            MarcarCasilla(4,boton);
        }
        else if (v.getId()==R.id.Cuadro5) {
            TextView boton=(TextView) findViewById(v.getId());
            MarcarCasilla(5,boton);
        }
        else if (v.getId()==R.id.Cuadro6) {
            TextView boton=(TextView) findViewById(v.getId());
            MarcarCasilla(6,boton);
        }
        else if (v.getId()==R.id.Cuadro7) {
            TextView boton=(TextView) findViewById(v.getId());
            MarcarCasilla(7,boton);
        }
        else if (v.getId()==R.id.Cuadro8) {
            TextView boton=(TextView) findViewById(v.getId());
            MarcarCasilla(8,boton);
        }

    }

    private void MarcarCasilla(int i,TextView boton){
        if (!tableroBlock[i]){
            if (turno){
                boton.setTextColor(getResources().getColor(R.color.purple));
                boton.setText("X");
                turno=false;
                tablero[i]='X';
                BuscarGanador(Botones);
            }
            else {
                boton.setTextColor(getResources().getColor(R.color.ros));
                boton.setText("0");
                turno=true;
                tablero[i]='0';
                BuscarGanador(Botones);
            }
        }
        tableroBlock[i]=true;
        turnojugador();
    }

    public void BuscarGanador(TextView[] textViews){
        if (tablero[0]=='X' && tablero[1]=='X' && tablero[2]=='X'){
            TextView[] textViews1 ={textViews[0],textViews[1],textViews[2]};
            lineaHorizontal(textViews1);
            Victoriasx();
        }else if(tablero[0]=='X' && tablero[3]=='X' && tablero[6]=='X'){
            TextView[] textViews1 ={textViews[0],textViews[3],textViews[6]};
            lineaVertical(textViews1);
            Victoriasx();
        }else if(tablero[0]=='X' && tablero[4]=='X' && tablero[8]=='X'){
            TextView[] textViews1 ={textViews[0],textViews[4],textViews[8]};
            lineaVerticalRigth(textViews1);
            Victoriasx();
        }else if(tablero[1]=='X' && tablero[4]=='X' && tablero[7]=='X'){
            TextView[] textViews1 ={textViews[1],textViews[4],textViews[7]};
            lineaVertical(textViews1);
            Victoriasx();
        }else if(tablero[2]=='X' && tablero[5]=='X' && tablero[8]=='X'){
            TextView[] textViews1 ={textViews[2],textViews[5],textViews[8]};
            lineaVertical(textViews1);
            Victoriasx();
        }else if(tablero[3]=='X' && tablero[4]=='X' && tablero[5]=='X'){
            TextView[] textViews1 ={textViews[3],textViews[4],textViews[5]};
            lineaHorizontal(textViews1);
            Victoriasx();
        }else if(tablero[6]=='X' && tablero[7]=='X' && tablero[8]=='X'){
            TextView[] textViews1 ={textViews[6],textViews[7],textViews[8]};
            lineaHorizontal(textViews1);
            Victoriasx();
        }else if(tablero[2]=='X' && tablero[4]=='X' && tablero[6]=='X'){
            TextView[] textViews1 ={textViews[2],textViews[4],textViews[6]};
            lineaVerticalLeft(textViews1);
            Victoriasx();
        }else if (tablero[0]=='0' && tablero[1]=='0' && tablero[2]=='0'){
            TextView[] textViews1 ={textViews[0],textViews[1],textViews[2]};
            lineaHorizontal(textViews1);
            Victorias0();
        }else if(tablero[0]=='0' && tablero[3]=='0' && tablero[6]=='0'){
            TextView[] textViews1 ={textViews[0],textViews[3],textViews[6]};
            lineaVertical(textViews1);
            Victorias0();
        }else if(tablero[0]=='0' && tablero[4]=='0' && tablero[8]=='0'){
            TextView[] textViews1 ={textViews[0],textViews[4],textViews[8]};
            lineaVerticalRigth(textViews1);
            Victorias0();
        }else if(tablero[1]=='0' && tablero[4]=='0' && tablero[7]=='0'){
            TextView[] textViews1 ={textViews[1],textViews[4],textViews[7]};
            lineaVertical(textViews1);
            Victorias0();
        }else if(tablero[2]=='0' && tablero[5]=='0' && tablero[8]=='0'){
            TextView[] textViews1 ={textViews[2],textViews[5],textViews[8]};
            lineaVertical(textViews1);
            Victorias0();
        }else if(tablero[3]=='0' && tablero[4]=='0' && tablero[5]=='0'){
            TextView[] textViews1 ={textViews[3],textViews[4],textViews[5]};
            lineaHorizontal(textViews1);
            Victorias0();
        }else if(tablero[6]=='0' && tablero[7]=='0' && tablero[8]=='0'){
            TextView[] textViews1 ={textViews[6],textViews[7],textViews[8]};
            lineaHorizontal(textViews1);
            Victorias0();
        }else if(tablero[2]=='0' && tablero[4]=='0' && tablero[6]=='0'){
            TextView[] textViews1 ={textViews[2],textViews[4],textViews[6]};
            lineaVerticalLeft(textViews1);
            Victorias0();
        }
    }
    public  void BloquearTablero(){
        Arrays.fill(tableroBlock, true);
    }
    public  void DesBloquearTablero(){
        Arrays.fill(tableroBlock, false);
    }
    public void Victoriasx(){
        VictoriasX++;
        BloquearTablero();
        reiniciar('X');
    }
    public void Victorias0(){
        Victorias0++;
        BloquearTablero();
        reiniciar('0');
    }
    @SuppressLint("UseCompatLoadingForDrawables")
    public  void LimpiarTablero(){

        for (TextView bone : Botones) {
            bone.setText("");
            bone.setBackgroundDrawable(null);
        }
        Arrays.fill(tablero, '-');
    }

    private void turnojugador(){
        if (turno){
            TextView turnojugador0 = (TextView) findViewById(R.id.jugador0);
            turnojugador0.setTextColor(getResources().getColor(R.color.grey));
            TextView turnojugadorx =(TextView) findViewById(R.id.jugadorx);
            turnojugadorx.setTextColor(getResources().getColor(R.color.yellow));
        }
        else{
            TextView turnojugadorx =(TextView) findViewById(R.id.jugadorx);
            turnojugadorx.setTextColor(getResources().getColor(R.color.black));
            TextView turnojugador0 = (TextView) findViewById(R.id.jugador0);
            turnojugador0.setTextColor(getResources().getColor(R.color.yellow));
        }
    }

    @SuppressLint("UseCompatLoadingForDrawables")
    private void lineaVerticalRigth(TextView[] textViews){
        for (TextView bone : textViews) {
            bone.setBackgroundDrawable(getResources().getDrawable(R.drawable.diagonalr_line_png_pic));
        }
    }
    @SuppressLint("UseCompatLoadingForDrawables")
    private void lineaVerticalLeft(TextView[] textViews){
        for (TextView bone : textViews) {
            bone.setBackgroundDrawable(getResources().getDrawable(R.drawable.diagonal_line_png_pic));
        }

    }
    @SuppressLint("UseCompatLoadingForDrawables")
    private void lineaHorizontal(TextView[] textViews){
        for (TextView bone : textViews) {
            bone.setBackgroundDrawable(getResources().getDrawable(R.drawable.horizontal_line_png_pic));
        }


    }
    @SuppressLint("UseCompatLoadingForDrawables")
    private void lineaVertical(TextView[] textViews){
        for (TextView bone : textViews) {
            bone.setBackgroundDrawable(getResources().getDrawable(R.drawable.vertical_line_png_pic));
        }
    }

    private void reiniciar(char ganadorchar){

        new CountDownTimer(1000, 1000){
            public void onTick(long millisUntilFinished) {

            }
            public void onFinish() {
                TextView text = (TextView) findViewById(R.id.contador);
                TextView ganador = (TextView) findViewById(R.id.ganador);

                ganador.setText(String.valueOf(ganadorchar));

                LinearLayout layoutGanador = findViewById(R.id.layoutGanador);
                layoutGanador.setVisibility(View.VISIBLE);
                new CountDownTimer(3000, 1000){
                    public void onTick(long millisUntilFinished) {
                        text.setText("Reiniciando: " + millisUntilFinished / 1000);
                    }
                    public void onFinish() {
                        LimpiarTablero();
                        DesBloquearTablero();
                        LinearLayout layoutGanador = findViewById(R.id.layoutGanador);
                        layoutGanador.setVisibility(View.GONE);

                    }
                }.start();
            }
        }.start();
    }

}