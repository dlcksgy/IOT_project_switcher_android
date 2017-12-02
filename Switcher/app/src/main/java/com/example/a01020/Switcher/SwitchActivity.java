package com.example.a01020.Switcher;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.ToggleButton;

public class SwitchActivity extends AppCompatActivity {
    public ImageView bulb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_switch);
        bulb = findViewById(R.id.buttonOn);
        final ToggleButton tb = findViewById(R.id.toggleButton);
        tb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("onClick", "here~");
                if (tb.isChecked()) {
                    tb.setTextColor(Color.BLACK);
                    bulb.setImageResource(R.mipmap.plug_on);


                } else {
                    tb.setTextColor(Color.RED);
                    bulb.setImageResource(R.mipmap.plug_off);
                }
            }
        });
    }
}
