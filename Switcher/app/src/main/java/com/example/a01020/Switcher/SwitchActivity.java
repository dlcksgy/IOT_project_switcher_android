package com.example.a01020.Switcher;

import android.content.res.Resources;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.ToggleButton;

public class SwitchActivity extends AppCompatActivity {

    String stars = "                                                                          \n" +
                    "   *           *                                                                \n" +
                    "                          *                                                     \n" +
                    "                                      *                       *                   \n" +
                    "                                                                          \n" +
                    "                                          *                                         \n" +
                    "                                                        *                        \n";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_switch);
        final ToggleButton switch1 = findViewById(R.id.switch1);
        final ToggleButton switch2 = findViewById(R.id.switch2);
        final ToggleButton switch3 = findViewById(R.id.switch3);

        final RelativeLayout background1 = findViewById(R.id.switch1Back);
        final RelativeLayout background2 = findViewById(R.id.switch2Back);
        final RelativeLayout background3 = findViewById(R.id.switch3Back);

        switch1.setText("");
        switch2.setText("");
        switch3.setText("");


        switch1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (switch1.isChecked()) {
                    switch1.setTextColor(Color.WHITE);
                    background1.setBackground(getDrawable(R.color.dayYellow));

                } else {
                    switch1.setTextColor(Color.YELLOW);
                    background1.setBackground(getDrawable(R.color.nightGray));
                    switch1.setText(stars);
                }
            }
        });

        switch2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (switch2.isChecked()) {
                    switch2.setTextColor(Color.WHITE);
                    background2.setBackground(getDrawable(R.color.dayYellow));

                } else {
                    switch2.setTextColor(Color.YELLOW);
                    background2.setBackground(getDrawable(R.color.nightGray));
                    switch2.setText(stars);
                }
            }
        });

        switch3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (switch3.isChecked()) {
                    switch3.setTextColor(Color.WHITE);
                    background3.setBackground(getDrawable(R.color.dayYellow));

                } else {
                    switch3.setTextColor(Color.YELLOW);
                    background3.setBackground(getDrawable(R.color.nightGray));
                    switch3.setText(stars);
                }
            }
        });
    }
}
