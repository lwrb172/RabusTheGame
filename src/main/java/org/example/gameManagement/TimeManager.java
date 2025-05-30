package org.example.gameManagement;

public class TimeManager {
    private int day;
    private int hour;
    private int minute;

    public TimeManager() {
        this.day = 1;
        this.hour = 22;
        this.minute = 30;
    }

    public void update() {
        minute += 30;
        if (minute >= 60) {
            minute = 0;
            hour++;
            if (hour >= 24) {
                hour = 0;
                day++;
            }
        }
    }

    public String getFormattedTime() {
        return String.format("Day %d, %02d:%02d", day, hour, minute);
    }

    public void setHour(int hour) {
        this.hour = hour;
    }

    public int getDay() {
        return day;
    }

    public int getHour() {
        return hour;
    }
}
