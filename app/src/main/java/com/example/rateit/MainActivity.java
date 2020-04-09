package com.example.rateit;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    int Maxv = 0;
    int Minv = 0;
    sqlhelp mydb;

    protected void onCreate(Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        final EditText Max_rate = (findViewById(R.id.editText));
        final EditText Min_rate = (findViewById(R.id.editText2));


        Button ok = findViewById(R.id.button);
        ok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Maxv = Integer.valueOf(Max_rate.getText().toString());
                Minv = Integer.valueOf(Min_rate.getText().toString());
                if (Maxv < 10 && Maxv > 0 && Minv < 10 && Minv > 0 && Maxv > Minv) {
                    Intent i = new Intent(v.getContext(), Main2Activity.class);
                    i.putExtra("maxseek", Maxv);
                    i.putExtra("minseek", Minv);
                    startActivity(i);
                } else {
                    Toast.makeText(MainActivity.this, "error in val", Toast.LENGTH_SHORT).show();
                }
            }
        });

        Button record = findViewById(R.id.button3);

    }


    public void migrate(View view) {


        Intent j = new Intent(this, Main3Activity.class);

        startActivity(j);


    }


}
