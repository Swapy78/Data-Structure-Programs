//Java program to create Week object having list of weekday and finally display calendar

package demo;

import java.util.LinkedList;
import java.util.Queue;

class WeekDay {
    private String day;
    private String date;

    public WeekDay(String day, String date) {
        this.day = day;
        this.date = date;
    }

    public String getDay() {
        return day;
    }

    public String getDate() {
        return date;
    }
}

public class Week {
    private Queue<WeekDay> weekDays;

    public Week() {
        weekDays = new LinkedList<>();
    }

    public void addWeekDay(WeekDay weekDay) {
        weekDays.add(weekDay);
    }

    public void displayCalendar() {
        System.out.println("Calendar:");
        for (WeekDay weekDay : weekDays) {
            System.out.println(weekDay.getDay() + ": " + weekDay.getDate());
        }
    }

    public static void main(String[] args) {
        // Creating Week object
        Week week = new Week();

        // Creating WeekDay objects and add them to the Week object
        week.addWeekDay(new WeekDay("Sunday", ""));
        week.addWeekDay(new WeekDay("Monday", "1"));
        week.addWeekDay(new WeekDay("Tuesday", "2"));
        week.addWeekDay(new WeekDay("Wednesday", "3"));
        week.addWeekDay(new WeekDay("Thursday", ""));
        week.addWeekDay(new WeekDay("Friday", "4"));
        week.addWeekDay(new WeekDay("Saturday", "5"));

        // Displaying the calendar
        week.displayCalendar();
    }
}
