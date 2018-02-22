package com.example.a01020.Switcher;

import android.content.ContentValues;
import android.os.AsyncTask;
import android.util.Log;
import android.widget.ToggleButton;

/**
 * Created by Arduino on 2017-12-03.
 */

public class NetworkTask extends AsyncTask<Void, Void, Boolean[]> {

    private String url;
    private ContentValues values;
    private ToggleButton btn1;
    private ToggleButton btn2;
    private ToggleButton btn3;


    public NetworkTask(String url, ContentValues values,ToggleButton btn1,ToggleButton btn2,ToggleButton btn3) {

        this.btn1 = btn1;
        this.btn2 = btn2;
        this.btn3 = btn3;

        this.url = url;
        this.values = values;
    }

    @Override
    protected Boolean[] doInBackground(Void... params) {

        Boolean[] result; // 요청 결과를 저장할 변수.
        RequestHttpURLConnection requestHttpURLConnection = new RequestHttpURLConnection();
        result = requestHttpURLConnection.allSwitchState(); // 해당 URL로 부터 결과물을 얻어온다.


        return result;
    }

    @Override
    protected void onPostExecute(Boolean[] btnStates) {
        super.onPostExecute(btnStates);
        if(btnStates[1]){
            btn1.setChecked(true);
        }else{
            btn1.setChecked(false);
        }

        if(btnStates[2]){
            btn2.setChecked(true);
        }else{
            btn2.setChecked(false);
        }

        if(btnStates[3]){
            btn3.setChecked(true);
        }else{
            btn3.setChecked(false);
        }


    }
}
