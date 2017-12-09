package com.chc.criminalintent.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * DESC:
 * Author: CHC
 * Date: 2017/12/8
 */

public class TimeUtils {
    public static final int SECONDS_IN_DAY = 60 * 60 * 24;
    public static final long MILLIS_IN_DAY = 1000L * SECONDS_IN_DAY;

    public static final String date2Date(Date date, String formatType){
        return new SimpleDateFormat(formatType).format(date);
    }
}
