package com.example.a01020.Switcher;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

public class ReservationActivity extends AppCompatActivity
{
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_reservation);
        final String[] day31_data = getResources().getStringArray(R.array.Days31);
        final String[] day28_data = getResources().getStringArray(R.array.Days28);
        final String[] day30_data = getResources().getStringArray(R.array.Days30);
        final Spinner day_spinner = (Spinner)findViewById(R.id.DaySpinner);

        final ArrayAdapter<String> day30_adapter = new ArrayAdapter<String>(this,android.R.layout.simple_dropdown_item_1line,day30_data);
        final ArrayAdapter<String> day31_adapter = new ArrayAdapter<String>(this,android.R.layout.simple_dropdown_item_1line,day31_data);
        final ArrayAdapter<String> day28_adapter = new ArrayAdapter<String>(this,android.R.layout.simple_dropdown_item_1line,day28_data);
        ArrayAdapter<String> selected_adapter;


        selected_adapter = day28_adapter;
        final Container container= new Container(1);

        final String[] month_data = getResources().getStringArray(R.array.Months);
        ArrayAdapter<String> month_adapter = new ArrayAdapter<String>(this,android.R.layout.simple_dropdown_item_1line,month_data);
        final Spinner month_spinner = (Spinner)findViewById(R.id.MonthSpinner);
        month_spinner.setAdapter(month_adapter);
        month_spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener()
        {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l)
            {
                container.setVal(adapterView.getSelectedItemPosition());
                int num = container.getVal();
                if((num==0)||(num==2)||(num==4)||(num==6)||(num==7)||(num==9)||(num==11)){
                    container.setAdapter(day31_adapter);

                }
                else if(num==1){
                    container.setAdapter(day28_adapter);
                }
                else{
                    container.setAdapter(day30_adapter);
                }
                day_spinner.setAdapter(container.getAdapter());
                day_spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                    @Override
                    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

                    }
                    @Override
                    public void onNothingSelected(AdapterView<?> adapterView) {}
                });
            }
            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {}
        });

        final String[] time_data = getResources().getStringArray(R.array.Times);
        ArrayAdapter<String> time_adapter = new ArrayAdapter<String>(this,android.R.layout.simple_dropdown_item_1line,time_data);
        final Spinner time_spinner = (Spinner)findViewById(R.id.TimeSpinner);
        time_spinner.setAdapter(time_adapter);
        time_spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener()
        {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l)
            {

            }
            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {}
        });

        final String[] hour_data = getResources().getStringArray(R.array.Hours);
        ArrayAdapter<String> hour_adapter = new ArrayAdapter<String>(this,android.R.layout.simple_dropdown_item_1line,hour_data);
        final Spinner hour_spinner = (Spinner)findViewById(R.id.HourSpinner);
        hour_spinner.setAdapter(hour_adapter);
        hour_spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener()
        {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l)
            {

            }
            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {}
        });

        final String[] minute_data = getResources().getStringArray(R.array.Minutes);
        ArrayAdapter<String> minute_adapter = new ArrayAdapter<String>(this,android.R.layout.simple_dropdown_item_1line,minute_data);
        final Spinner minute_spinner = (Spinner)findViewById(R.id.MinuteSpinner);
        minute_spinner.setAdapter(minute_adapter);
        minute_spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener()
        {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l)
            {

            }
            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {}
        });

        findViewById(R.id.SendButton).setOnClickListener(
                new Button.OnClickListener(){
                    public void onClick(View v){
                        String month_value=month_spinner.getSelectedItem().toString();
                        String day_value=day_spinner.getSelectedItem().toString();
                        String time_value=time_spinner.getSelectedItem().toString();
                        String hour_value=hour_spinner.getSelectedItem().toString();
                        String minute_value=minute_spinner.getSelectedItem().toString();

                        Toast.makeText(getApplicationContext(),month_value+"월"+day_value+"일"+time_value+hour_value+"시"+minute_value+"분으로 예약 되셨습니다.",Toast.LENGTH_LONG).show();
                }
            });
    }
}

