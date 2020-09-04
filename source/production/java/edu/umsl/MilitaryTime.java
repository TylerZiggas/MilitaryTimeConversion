package edu.umsl;
import java.util.InputMismatchException;
import java.util.Scanner;

public class MilitaryTime {
    public static void main (String[] args) {

        boolean retry = false;
        System.out.println("In military time, please enter a number of hours followed by a number of minutes, I will subtract 45 minutes from it.");
        Scanner input = new Scanner(System.in);
        retry = false;
        try {
            int hours = input.nextInt(); // Input number of hours
            int minutes = input.nextInt(); // Input number of minutes
        } catch(InputMismatchException ex){
                retry = true;
                System.out.println("That is not an integer\n");
        }
        while (hours > 23 || hours < 0 || minutes < 0 || minutes > 59) { // If the input is outside of the range needed
            retry = false;
            try {
                System.out.println("Please enter hours between 0 and 23, and minutes between 0 and 59.");
                hours = input.nextInt();
                minutes = input.nextInt();
            } catch (InputMismatchException ex) {
                retry = true;
                System.out.println("That is not an integer\n");
            }
        }

        if (minutes < 45) { // Need to mess with the hours if minutes is less than 45
            minutes = 45 - minutes;
            minutes = 60 - minutes;
           if (hours == 0) {
               hours = 24;
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
