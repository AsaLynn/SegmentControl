package com.zxn.segmentcontrol.sample;

import com.zxn.segmentcontrol.ISegmentInfo;

/**
 * Created by zxn on 2019/7/6.
 */
public class FoodInfo implements ISegmentInfo {

    public String name;

    @Override
    public String getSegmentName() {
        return name;
    }
}
