package com.example.esercitazione1;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    Button incremento, decremento, somma, sottrazione, reset;
    EditText input;
    //EditText nice;
    //SeekBar seekbar;
    //MediaPlayer player;
    int minval = 0;
    int maxval = 100;
    int modelvalue = 50;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        incremento = findViewById(R.id.incremento);
        decremento = findViewById(R.id.decremento);
        somma = findViewById(R.id.somma);
        sottrazione = findViewById(R.id.sottrazione);
        reset = findViewById(R.id.reset);
        input = findViewById(R.id.input);
//      nice = findViewById(R.id.nice);
//      seekbar = findViewById(R.id.seekbar);


        updatevalue(modelvalue);

        incremento.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //input.setText("+1");
                updatevalue(++modelvalue);
            }
        });
        decremento.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //input.setText("-1");
                updatevalue(--modelvalue);
            }
        });
        somma.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //input.setText("-1");
                updatevalue(modelvalue+5);
            }
        });
        sottrazione.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //input.setText("-1");
                updatevalue(modelvalue-5);
            }
        });

        reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                updatevalue(0);
            }
        });
        /*
        seekbar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                updatevalue(seekBar.getProgress());
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                updatevalue(seekBar.getProgress());

            }
        });*/
    }

    protected void updatevalue(int newvalue){
        /*
        player = MediaPlayer.create(MainActivity.this,R.raw.nice_sound);
        if(this.seekbar.getProgress() != this.modelvalue){
            this.seekbar.setProgress(this.modelvalue);
        }
        */
        newvalue = newvalue > maxval ? maxval : newvalue;
        newvalue = newvalue < minval ? minval : newvalue;
        this.modelvalue = newvalue;
        input.setText(""+this.modelvalue);
        /*
        if(modelvalue == 69){
            nice.setText("NICE");
            player.start();

        } else{
            nice.setText("");
            player.pause();
        }
        */
    }


}