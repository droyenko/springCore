package com.yet.spring.core.beans;

import java.text.DateFormat;
import java.time.LocalTime;
import java.util.Date;
import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;

public class Event {

    private static final AtomicInteger AUTO_ID = new AtomicInteger(0);

    private int id;
    private String msg;
    private Date date;
    private DateFormat df;

    public Event(Date date, DateFormat df) {

        this.id = new Random().nextInt(10) + 1;
        this.date = date;
        this.df = df;
    }

    public Event(int id, Date date, String msg) {
        this.id = id;
        this.date = date;
        this.msg = msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public static boolean isDay() {
        int hour = LocalTime.now().getHour();
        return hour >= 8 && hour < 17;
    }

    public int getId() {
        return id;
    }

    public static void initAutoId(int id) {
        AUTO_ID.set(id);
    }

    @Override
    public String toString() {
        return "Event{" +
                "id=" + id +
                ", msg='" + msg + '\'' +
                ", date=" + df.format(date) +
                '}' +
                '\n';
    }
}
