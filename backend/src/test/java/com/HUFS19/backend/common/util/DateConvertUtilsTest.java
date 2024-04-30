package com.HUFS19.backend.common.util;

import org.junit.jupiter.api.Test;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

class DateConvertUtilsTest {
    Timestamp StringToTimestamp(String stringDate){
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        Timestamp sampleTimestamp = null;
        try {
            Date stringToDate = dateFormat.parse(stringDate);
            sampleTimestamp = new Timestamp(stringToDate.getTime());
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return sampleTimestamp;
    }

    @Test
    void getDate() {
        String sampleDateString = "2024/2/23 13:01:54";
        Timestamp timestamp = this.StringToTimestamp(sampleDateString);
        assertEquals(timestamp != null, true);
        assertEquals(timestamp instanceof Timestamp, true);

        String result = DateConvertUtils.getDate(timestamp);

        assertEquals(result, "2024년 2월 23일");
    }

    @Test
    void getTime_오후() {
        String sampleDateString = "2024/2/23 13:01:54";
        Timestamp timestamp = this.StringToTimestamp(sampleDateString);
        assertEquals(timestamp != null, true);
        assertEquals(timestamp instanceof Timestamp, true);

        String result = DateConvertUtils.getTime(timestamp);
        assertEquals(result, "오후 1시 01분");
    }

    @Test
    void getTime_오전() {
        String sampleDateString = "2024/2/3 5:08:54";
        Timestamp timestamp = this.StringToTimestamp(sampleDateString);
        assertEquals(timestamp != null, true);
        assertEquals(timestamp instanceof Timestamp, true);

        String result = DateConvertUtils.getTime(timestamp);
        assertEquals(result, "오전 5시 08분");
    }
}