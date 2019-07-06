package com.zxn.segmentcontrol.sample;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.zxn.segmentcontrol.ISegmentInfo;
import com.zxn.segmentcontrol.SegmentControl;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends Activity {
    private static final String TAG = "MainActivity";

    private SegmentControl mSegmentHorzontal;
    private SegmentControl mSegmentVertical;
    private SegmentControl sc_vertical;
    private List<ISegmentInfo> segmentInfoList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mSegmentHorzontal = (SegmentControl) findViewById(R.id.segment_control);
        mSegmentVertical = (SegmentControl) findViewById(R.id.segment_control2);
        sc_vertical = (SegmentControl) findViewById(R.id.sc_vertical);
        mSegmentHorzontal.setOnSegmentControlClickListener(new SegmentControl.OnSegmentControlClickListener() {
            @Override
            public void onSegmentControlClick(int index) {
                Log.i(TAG, "onSegmentControlClick: index = " + index);
            }
        });
        mSegmentVertical.setOnSegmentControlClickListener(new SegmentControl.OnSegmentControlClickListener() {
            @Override
            public void onSegmentControlClick(int index) {
                Log.i(TAG, "onSegmentControlClick: index" + index);
            }
        });
        mSegmentVertical.setText("AAA", "BBB", "CCC");


        sc_vertical.setOnSegmentControlClickListener(new SegmentControl.OnSegmentControlClickListener() {
            @Override
            public void onSegmentControlClick(int index) {
                Toast.makeText(MainActivity.this, "index:" + index + segmentInfoList.get(index).getSegmentName(), Toast.LENGTH_SHORT).show();
            }
        });

        //app:texts="富贵厅|吉祥厅|状元厅|安宁厅|双喜厅|状元厅"
        String[] names = {"富贵厅", "吉祥厅", "状元厅", "安宁厅", "双喜厅", "状元厅"};
        segmentInfoList = new ArrayList<>();
        for (int i = 0; i < names.length; i++) {
            FoodInfo foodInfo = new FoodInfo();
            foodInfo.name = names[i];
            segmentInfoList.add(foodInfo);
        }

        sc_vertical.setSegmentInfo(segmentInfoList);
        sc_vertical.setSelectedIndex(0);
    }
}
