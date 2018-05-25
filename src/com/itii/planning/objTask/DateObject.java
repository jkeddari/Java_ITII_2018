package com.itii.planning.objTask;

public class DateObject {
    private String year;
    private String month;
    private String day;
    private String hours;
    private String minute;


    public DateObject(String date){
        year=date.substring(0,4);
        month=date.substring(5,7);
        day=date.substring(8,10);
        hours=date.substring(11,13);
        minute=date.substring(14,16);
    }

    public String getYear(){
        return year;
    }
    public String getMonth(){
        return month;
    }
    public String getDay(){
        return day;
    }



    public String getDate(){
        return year+"-"+month+"-"+day+" "+hours+":"+minute;
    }
    public String getTime(){return hours+":"+minute;}
}
