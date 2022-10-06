package com.example.demo1;

import java.time.LocalTime;

public class test {
    public static void main(String[] args) {
//        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
//        String date = "2019-32-27 20:13:04";
//	    LocalDateTime dateTime = LocalDateTime.parse(date,formatter);
        String time = "012:13:04";
        LocalTime myObj = LocalTime.parse(time);
        System.out.println(myObj);
    }
}
