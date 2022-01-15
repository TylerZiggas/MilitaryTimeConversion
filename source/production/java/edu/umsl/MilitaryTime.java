package edu.umsl;
import java.util.InputMismatchException;
import java.util.Scanner;

public class MilitaryTime {
    public static void main(String[] args) {
        int hours = 0;
        int minutes = 0;
        boolean retry = false;

        do {
            do { // Want to get past both of these without any input
                try {
                    Scanner input = new Scanner(System.in);
                    retry = false;
                    System.out.println("Please enter an amount of hours between 0 and 23, and an amount of minutes between 0 and 59.  I will subtract 45 minutes from it.");
                    hours = input.nextInt();
                    minutes = input.nextInt();
                } catch (InputMismatchException ex) {
                    retry = true;
                    System.out.println("One or more of these inputs is not an integer.");
                } catch (Exception ex) {
                    retry = true;
                    System.out.println("Error.");
                }
            } while (retry); // make sure the inputs are numbers
        }  while (hours > 23 || hours < 0 || minutes < 0 || minutes > 59); // make sure the number input is correct

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