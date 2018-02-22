package com.example.a01020.Switcher;

import android.content.ContentValues;
import android.content.res.Resources;
import android.graphics.Color;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.ToggleButton;

import java.util.Timer;
import java.util.TimerTask;

public class SwitchActivity extends AppCompatActivity {


    //서버값 디버깅용
    static Boolean[] ret = {null, true,
            false,
            true};

    static final String stars = "                                                                          \n" +
                    "   *           *                                                                \n" +
                    "                          *                                                     \n" +
                    "                                      *                       *                   \n" +
                    "                                                                          \n" +
                    "                                          *                                         \n" +
                    "                                                        *                        \n";
    static final String SERVER_CLOSED = "Server not opened";

    Bulb bulb1;
    Bulb bulb2;
    Bulb bulb3;

    ToggleButton switch1;
    ToggleButton switch2;
    ToggleButton switch3;


    RelativeLayout background1;
    RelativeLayout background2;
    RelativeLayout background3;

    ServerStateTask task;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_switch);

        task = new ServerStateTask();

        switch1 = findViewById(R.id.switch1);
        switch2 = findViewById(R.id.switch2);
        switch3 = findViewById(R.id.switch3);


        background1 = findViewById(R.id.switch1Back);
        background2 = findViewById(R.id.switch2Back);
        background3 = findViewById(R.id.switch3Back);
        switch1.setText("");
        switch2.setText("");
        switch3.setText("");

        bulb1 = new Bulb(background1, switch1);
        bulb2 = new Bulb(background2, switch2);
        bulb3 = new Bulb(background3, switch3);

        Timer serverTimer = new Timer();
        TimerTask serverTask = new TimerTask() {
            @Override
            public void run() {
                ServerStateTask serverStateTask = new ServerStateTask();
                serverStateTask.execute();

            }
        };
        serverTimer.schedule(serverTask,0,1000);

        switch1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (switch1.isChecked()) {
                    //서버에 켜는신호를보냄
                    ret[1] = true;
                } else {
                    //서버에 끄는 신호를 보냄
                    ret[1] = false;
                }
            }
        });

        switch2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (switch2.isChecked()) {
                    //서버에 켜는신호를보냄
                    ret[2] = true;
                } else {
                    //서버에 끄는 신호를 보냄
                    ret[2] = false;
                }
            }
        });

        switch3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (switch3.isChecked()) {
                    //서버에 켜는신호를보냄
                    ret[3] = true;
                } else {
                    //서버에 끄는 신호를 보냄
                    ret[3] = false;
                }
            }
        });

    }

    class ServerStateTask extends AsyncTask<Void,Void,Boolean>{

        private Boolean[] states;

        @Override
        protected Boolean doInBackground(Void... voids) {

//            RequestHttpURLConnection requestHttpURLConnection = new RequestHttpURLConnection();
//            states = requestHttpURLConnection.allSwitchState();
            states = ret;
            return null;
        }

        @Override
        protected void onPostExecute(Boolean bool) {
            super.onPostExecute(bool);

            if(states[1]){
                bulb1.on();
            }else{
                bulb1.off();
            }
            if(states[2]){
                bulb2.on();
            }else{
                bulb2.off();
            }
            if(states[3]){
                bulb3.on();
            }else{
                bulb3.off();
            }
        }


    }


    public class Bulb {

        static final String stars = "                                                                          \n" +
                "   *           *                                                                \n" +
                "                          *                                                     \n" +
                "                                      *                       *                   \n" +
                "                                                                          \n" +
                "                                          *                                         \n" +
                "                                                        *                        \n";
        private RelativeLayout background;
        private ToggleButton button;
        public Bulb(RelativeLayout background, ToggleButton button) {
            this.background = background;
            this.button = button;
        }

        public void off(){
            button.setTextColor(Color.YELLOW);
            background.setBackground(getDrawable(R.color.nightGray));
            button.setText(stars);
        }

        public void on(){

            button.setTextColor(Color.WHITE);
            background.setBackground(getDrawable(R.color.dayYellow));
        }
    }

}