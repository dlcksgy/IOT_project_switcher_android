package com.example.a01020.Switcher;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;

public class ReservationListActivity extends AppCompatActivity {

    private ListView mListView;
    public String[] data = {"2017.12.02.15.30","2017.12.02.14.00","2017.12.03.13.30","2017.12.02.15.30","2017.12.02.14.00","2017.12.03.13.30"
    ,"2017.12.02.15.30","2017.12.02.14.00","2017.12.03.13.30","2017.12.03.13.30"}; //임시로 넣는 시간 데이터

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_reservation_list);
        /* 위젯과 멤버변수 참조 획득 */
        mListView = (ListView)findViewById(R.id.listView);

        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent=new Intent(getApplicationContext(),PopupActivity.class);
                startActivity(intent);

            }
        });
        /* 아이템 추가 및 어댑터 등록 */
        dataSetting();

        Button reservationButton = findViewById(R.id.button_reservation);
        reservationButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent intent = new Intent(getApplicationContext(),ReservationActivity.class);
                startActivity(intent);
            }
        });
    }

    private void dataSetting(){

        MyAdapter mMyAdapter = new MyAdapter();


        for (int i=0; i<10; i++) {
            mMyAdapter.addItem(data[i],i+1);
        }

        /* 리스트뷰에 어댑터 등록 */
        mListView.setAdapter(mMyAdapter);
    }

}