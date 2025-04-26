package org.example;

public class TimeManager {
    private int day;
    private int hour;
    private int minute;
    private int speed = 1;

    public TimeManager() {
        this.day = 1;
        this.hour = 8;
        this.minute = 0;
    }

    public void update() {
        minute += speed;

        if (minute >= 60) {
            minute = 0;
            hour++;

            if (hour >= 24) {
                hour = 0;
                day++;
                System.out.println("New Day!: Day " + day);
            }
        }
    }

    public void increaseSpeed() {
        speed = Math.min(speed+1, 10);
    }

    public void decreaseSpeed() {
        speed = Math.max(speed-1, 1);
    }

    public boolean isNight() {
        return hour < 6 || hour >= 22;
    }

    public String getFormattedTime() {
        return String.format("Day %d, %02d:%02d", day, hour, minute);
    }

    public int getDay() {
        return day;
    }

    public int getHour() {
        return hour;
    }

    public int getMinute() {
        return minute;
    }

    public int getSpeed() {
        return speed;
    }

}
