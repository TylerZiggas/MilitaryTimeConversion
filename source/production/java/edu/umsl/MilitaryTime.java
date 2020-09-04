package edu.umsl;
import java.util.InputMismatchException;
import java.util.Scanner;

public class MilitaryTime {
    public static void main(String[] args) {
        int hours = 0;
        int minutes = 0;
        boolean retry = false;

            do {
                do {
                    try {
                        Scanner input = new Scanner(System.in);
                        retry = false;
                        System.out.println("Please enter hours between 0 and 23, and minutes between 0 and 59.  I will subtract 45 minutes from it.");
                        hours = input.nextInt();
                        minutes = input.nextInt();
                    } catch (InputMismatchException ex) {
                        retry = true;
                        System.out.println("One or more of these inputs is not an integer.");
                    } catch (Exception ex) {
                        retry = true;
                        System.out.println("Error.");
                    }
                } while (retry);
            }  while (hours > 23 || hours < 0 || minutes < 0 || minutes > 59);

        if (minutes < 45) { // Need to mess with the hours if minutes is less than 45
            minutes = 45 - minutes;
            minutes = 60 - minutes;
            if (hours == 0) {
                hours = 23;
            } else {
                hours = hours - 1;
            }

        } else {
            minutes = minutes - 45;
        }

        if (minutes < 10 && hours < 10) { //Adding zeroes to the front if they are only single digit in hours or minutes after the math
            System.out.println("Your new time is 0" + hours + ":0" + minutes);
        } else if (minutes < 10) {
            System.out.println("Your new time is " + hours + ":0" + minutes);
        } else if (hours < 10) {
            System.out.println("Your new time is 0" + hours + ":" + minutes);
        } else {
            System.out.println("Your new time is " + hours + ":" + minutes);
        }
    }
}
