/*
 * Name: Rojkov Phillip
 * Date: 2020-10-05
 * Assignment Name: (1005) U4A6 - Assignment 6 - Determining the Min/Max of a set of numbers
 * Description: Find the min/max of a user input set of numbers
 */

import java.util.*;

public class RojkovMinMax
{
    public static Scanner scanner = new Scanner(System.in); //Create scanner object with full class scope

    public static void main(String[] args)
    {
        System.out.println("Would you like to find the max or min of a set of integers? MAX / MIN");

        String input = scanner.nextLine();

        if (input.equals("MAX")) //run findMax if the user requests MAX
        {
            findMax();
        } else if (input.equals("MIN")) //run findMin if the user requests MIN
        {
            findMin();
        } else { //end program if user fails to enter a valid input
            System.out.println("Enter a valid input; MAX / MIN");
        }
    }

    public static void findMin() //Find the minimum of an input set of numbers
    {
        System.out.println("How many numbers do you want to input?");

        int amount = scanner.nextInt();

        System.out.println("Input a number: ");

        int min = scanner.nextInt(); //Start off min with the first input

        for (int i = 1; i < amount; i++)
        {
            System.out.println("Input a number: ");

            int n = scanner.nextInt();

            if (n < min) //Check if the new input n is less than current min
            {
                min = n; //Min will always be the smallest number input
            }
        }

        System.out.println("The min is: " + min); //Output the minimum
    }

    public static void findMax() //Find the maximum of an input set of numbers
    {
        System.out.println("How many numbers do you want to input?");

        int amount = scanner.nextInt();

        System.out.println("Input a number: ");

        int max = scanner.nextInt(); //Start off max with the first input

        for (int i = 1; i < amount; i++)
        {
            System.out.println("Input a number: ");

            int n = scanner.nextInt();

            if (n > max) //Check if the new input n is greater than than current max
            {
                max = n; //Min will always be the smallest number input
            }
        }

        System.out.println("The max is: " + max); //Output the maximum
    }
}
