/*
* Name: Phillip Rojkov
* Date: October 11, 2020
* Assignment Name: (1012) U5 - Programming Assignment: Creating a CIRCLE Class
* Description: Create a circle class and create an interactive program that outputs area, diameter, circumference based on user input
* Inputs: Q A C S D = Quit Area Circumference SetRadius Diameter respectively
* Outputs: Quit program, area, circumference, diameter
 */

import java.util.*;

public class PRPA3PartAClasses {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in); //Create a scanner object

        System.out.println("Enter a radius for your circle: ");
        double radius = scanner.nextDouble(); //Declare a radius variable for the new circle
        scanner.nextLine(); //Scanner.nextDouble() doesn't read \n so we need to call nextLine()

        Circle circle1 = new Circle(radius); //Create a new circle object

        /* Not used
        //Print the area, circumference, and diameter of circle1
        printArea(circle1);
        printCircumference(circle1);
        printDiameter(circle1);
        */

        //Possible user inputs
        String SENTINEL = "Q";
        String inputArea = "A";
        String inputCircumference = "C";
        String inputSetRadius = "S";
        String inputDiameter = "D";
        while (true) {
            System.out.println("Choose an option: Q : quit, A : area, C : circumference, S : set radius, D : diameter");

            String input = scanner.nextLine();

            if (input.equals(inputArea)) { //User wants to know the area
                printArea(circle1);
            }
            else if (input.equals(inputSetRadius)) { //User wants to set radius
                System.out.println("Enter a radius: ");
                radius = scanner.nextDouble(); //Set radius equal to user input double
                scanner.nextLine(); //Scanner.nextDouble() doesn't read \n so we need to call nextLine()

                circle1.setRadius(radius); //Call setRadius method of circle1 object
            }
            else if (input.equals(inputDiameter)) { //User wants to know the diameter
                printDiameter(circle1);
            }
            else if (input.equals(inputCircumference)) { //User wants to know the circumference
                printCircumference(circle1);
            }
            else if (input.equals(SENTINEL)) { //User wants to quit the program
                break; //Exit the loop
            }
            else { //User enters an invalid inputQ
                System.out.println("Please enter a valid input: Q, A, C, S, D");
            }
        }
    }

    public static void printRadius(Circle c) { //Print the rounded radius of circle c. NOT USED
        System.out.println("Radius = " + Math.round(c.getRadius() * 100) / 100);
        //In order to round to two decimal places, the formula: Math.round(doubleToRound * 100.0) / 100.0 is used
    }

    public static void printArea(Circle c) { //Print the rounded area of circle c
        System.out.println("Area = " + Math.round(c.area() * 100.0) / 100.0);
    }

    public static void printCircumference(Circle c) { //Print the rounded circumference of circle c
        System.out.println("Circumference = " + Math.round(c.circumference() * 100.0) / 100.0);
    }

    public static void printDiameter(Circle c) { //Print the diameter of circle c
        System.out.println("Diameter = " + Math.round(c.diameter() * 100.0) / 100.0);
    }
}
