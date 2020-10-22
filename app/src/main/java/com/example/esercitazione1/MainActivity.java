package com.example.esercitazione1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    Button incremento, decremento;
    EditText input;
    EditText nice;
    SeekBar seekbar;
    int minval = 0;
    int maxval = 100;
    int modelvalue = 50;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        incremento = findViewById(R.id.incremento);
        decremento = findViewById(R.id.decremento);
        input = findViewById(R.id.input);
        nice = findViewById(R.id.nice);
        seekbar = findViewById(R.id.seekbar);

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
        });
    }

    protected void updatevalue(int newvalue){
        if(this.seekbar.getProgress() != this.modelvalue){
            this.seekbar.setProgress(this.modelvalue);
        }
        newvalue = newvalue > maxval ? maxval : newvalue;
        newvalue = newvalue < minval ? minval : newvalue;
        this.modelvalue = newvalue;
        input.setText(""+this.modelvalue);
        if(modelvalue == 69){
            nice.setText("NICE");
        } else{
            nice.setText("");
        }
    }

 /*
    @Override
    protected void onStop(){
        super.onStop();
        TextView helloworld = findViewById(R.id.helloworld);
        helloworld.setText("on stop");

    }

  */
}