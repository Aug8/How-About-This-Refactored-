package com.HUFS19.backend.common.util;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class DateConvertUtils {
    public static String getDate(Timestamp timestamp){
        String timeFormat = new SimpleDateFormat("yyyy MM dd").format(timestamp);

        String[] timeArray = timeFormat.split(" ");
        List<String> timeList= new ArrayList<>(Arrays.asList(timeArray));

        timeList.replaceAll(s->Integer.toString(Integer.parseInt(s)));
        timeList.add(1, "년 ");
        timeList.add(3, "월 ");
        timeList.add( "일");

        String dateString = String.join("", timeList);
        return dateString;
    }
    public static String getTime(Timestamp timestamp){
        String timeFormat = new SimpleDateFormat("a hh mm").format(timestamp);

        String[] timeArray = timeFormat.split(" ");
        List<String> timeList= new ArrayList<>(Arrays.asList(timeArray));

        timeList.set(1, Integer.parseInt(timeList.get(1)) +"시");
        timeList.set(2, timeList.get(2) + "분");

        String timeString = String.join(" ", timeList);
        return timeString;
    }

}
