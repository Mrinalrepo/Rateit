package com.example.rateit;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Main2Activity extends AppCompatActivity {
    public static TextView t1;
    private static SeekBar s;
    sqlhelp mydb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        mydb = new sqlhelp(this);
        Intent i = getIntent();
        int Max = i.getIntExtra("maxseek", 0);
        int Min = i.getIntExtra("minseek", 0);

        TextView t = findViewById(R.id.textView);
        String get = Integer.toString(Max) + Min;
        t.setText(get);
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        Date date = new Date();
        final String currentdate = formatter.format(date);
        TextView knowdate = findViewById(R.id.editText3);
        knowdate.setText(currentdate);
        seebar(Max, Min);
        Button updaterec = findViewById(R.id.button2);
        updaterec.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                boolean isInserted = mydb.insertData(currentdate);
            }
        });


    }

    public void seebar(int Max, int Min) {
        s = findViewById(R.id.seekBar);
        t1 = findViewById(R.id.textView3);
        s.setMax(Max);
        s.setMin(Min);
        t1.setText("covered" + s.getProgress());

        s.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            int p_val;

            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                p_val = progress;
                t1.setText(progress + "/" + s.getMax());
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                t1.setText(p_val);

            }
        });


    }


}


