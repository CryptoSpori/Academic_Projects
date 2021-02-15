
/**
 * @author EMILIA BUTU
 * version 1.0
 * since   2020-07
 *
 * Student name:  John Stelly
 * Completion date: 09/30/2020
 *
 * PlayingNumbers.java
 *
 *
 */
import java.util.Scanner;

public class PlayingNumbers {

    public static void main(String[] args) {

        //Use an array of six elements of type Strings to store students' names that get valid appointments for the time slots.
        String[] students = new String[6];
        Scanner ks = new Scanner(System.in);
        Scanner ki = new Scanner(System.in);

        boolean status = true;
        //Write a loop that iterates as long as the array has free space, meaning there are still appointments available.
        while (status) {

            status = false;

            //Within a try block, allow the user to enter a time and a name. Read the times as simple integers, with values from 1 to 6.
            try {
                System.out.println("Enter a time for your appointment, time from 1-6: ");
                int time = ki.nextInt();

                //If the time is free, meaning it does not have a name in that particular element, put the name in the array.
                // If the time is not free, throw a TimeInUseException.
                if (time > 6 || time < 1) {
                    throw new InvalidTimeException();
                }

                //If the time is not valid, throw an InvalidTimeException.
                if (students[time - 1] != null) {
                    throw new TimeInUseException();
                } else {
                    System.out.print("Enter your name: ");
                    String name = ks.nextLine();
                    students[time - 1] = name;
                }
            }

            //Use a catch block for each different kind of exception.
            catch (TimeInUseException e){
                System.out.println(e.getMessage());
            }
            catch (InvalidTimeException e) {
                System.out.println(e.getMessage());
            }
            for (int i = 0; i < students.length; i++) {

                if(students[i] == null)
                    status = true;
            }
        }

        //Once all appointments are made, display the schedule.
        System.out.println("Schedule is full. No appointments remaining");
        System.out.println("Schedule is:");
        for (int i = 0; i < students.length; i++) {
            System.out.println( (i+1) +  "pm: " + students[i]);
        }
    }
}

