package com.dd.numberpick;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    private NumberPick mNp;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mNp = (NumberPick) findViewById(R.id.np);

        mNp.setNumber(10);

        mNp.setOnNumberPickListener(new NumberPick.OnNumberPickListener() {
            @Override
            public void onSub(int number) {
                //do something
            }

            @Override
            public void onAdd(int number) {
                //do something
            }
        });
    }
}
