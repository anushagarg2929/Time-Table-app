package com.example.timetableapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SeekBar;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ListView timesTableListView;

    public void generateTimeTable(int timeTable){
        ArrayList<String> timesTableContent = new ArrayList<String>();
        for(int i = 1; i <= 10; i++){

            timesTableContent.add(Integer.toString(i * timeTable));

        }
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, timesTableContent);
        timesTableListView.setAdapter(arrayAdapter );
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        SeekBar timeTableSeekBar = (SeekBar) findViewById(R.id.seekBar);
        ListView timeTableListView = (ListView) findViewById(R.id.TimeTableListView);

        timeTableSeekBar.setMax(20);
        timeTableSeekBar.setProgress(10);

        timeTableSeekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                int min = 1;
                int timesTable;
                if(i<min){
                    timesTable = min;
                    timeTableSeekBar.setProgress(min);
                }else{
                    timesTable = i;
                }
               // Log.i("Seekbar value", Integer.toString(timeTable));
                generateTimeTable(timesTable);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
       // int timesTable = 10;
        generateTimeTable(10);
    }
}