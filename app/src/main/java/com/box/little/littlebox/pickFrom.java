package com.box.little.littlebox;

import android.app.Activity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.TimePicker;

public class pickFrom extends Activity{
    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);

        setContentView(R.layout.pickfrom);

        DisplayMetrics dm = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(dm);

        int width = dm.widthPixels;
        int height = dm.heightPixels;

        getWindow().setLayout((int)(width*0.9),(int) (height*0.8));

        Button setFromHours = (Button) findViewById(R.id.setBtnFrom);

        setFromHours.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                TimePicker tPicker = (TimePicker) findViewById(R.id.timePickerFrom);
                int hour = tPicker.getHour();
                int min = tPicker.getMinute();
                String time = Integer.toString(hour) + ":" + Integer.toString(min);

                MainActivity.txtView2.setText(time);
                finish();
            }
        });
    }

}
