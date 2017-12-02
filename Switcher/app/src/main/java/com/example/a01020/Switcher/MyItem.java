package com.example.a01020.Switcher;


public class MyItem {


    private String name;
    private String[] hi;
    private  String hello;
    private int index;


    public MyItem(int index)
    {
        this.index = index;
    }




    public String getName() {
        return hello;
    }

    public void setName(String name) {
        this.name = name;
        hello = name;
        //hi = name.split(".");
        //Log.d("hi ", hi[1]);
        //hello = (hi[1] + "월 " + hi[2] + "일 " + hi[3] + "시 " + hi[4] + "분";
    }
    public int getIndex(){return index;}
    public void setIndex(int a){index = a;}


}