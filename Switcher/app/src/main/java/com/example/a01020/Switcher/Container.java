package com.example.a01020.Switcher;

import android.widget.ArrayAdapter;

/**
 * Created by Programmer on 2017-11-30.
 */

public class Container
{
    private int val;
    private ArrayAdapter<String> adapter;
    public Container(int i){
        val = i;
    }
    public int getVal(){
        return val;
    }
    public void setVal(int i)
    {
        val = i;
    }
    public void setAdapter(ArrayAdapter<String> adapter){
        this.adapter = adapter;
    }
    public ArrayAdapter<String> getAdapter(){
        return adapter;
    }

}
