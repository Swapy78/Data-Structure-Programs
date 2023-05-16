//Java program to print calendar

package demo;

public class Calendar {
    public static void main(String[] args) {
        int[][] calendar = new int[6][7];
       
        // Set the total number of days in the month of May
        int daysInMonth = 31;
        // Set the starting day of the week to be Sunday (index 0)
        int dayOfWeek = 1;
        // Set the starting day of the month to be the first (index 1)
        int dayOfMonth = 1;

        // Fill in the calendar with days of the month
        for (int row = 0; row < 6; row++) {
            for (int col = 0; col < 7; col++) {
                // If the current day is within the month, fill it in the array
                if (dayOfWeek <= col && dayOfMonth <= daysInMonth) {
                    calendar[row][col] = dayOfMonth;
                    dayOfMonth++;
                }
            }
            // After filling in a row, reset the starting day of the week to Sunday
            dayOfWeek = 0;
        }

        // Print the calendar header
        System.out.println("May 2023");
        System.out.println(" Su Mo Tu We Th Fr Sa");

        // Print the calendar body
        for (int[] week : calendar) {
            for (int day : week) {
                // If the day is not in the month, print blank spaces
                if (day == 0) {
                    System.out.print("   ");
                } else {
                    // Otherwise, print the day number with leading zeros if needed
                    System.out.printf("%2d ", day);
                }
            }
            // After printing a row, move to the next line
            System.out.println();
        }
    }
}