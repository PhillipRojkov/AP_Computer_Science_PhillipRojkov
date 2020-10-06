/*
 * Name: Rojkov Phillip
 * Date: 2020-10-05
 * Assignment Name: (1005) U4A5 - Assignment 5 (Sum a set of input numbers)
 * Description: Sum 16+ user inputs
 */

import java.util.*;

public class RojkovSumInputs
{
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in); //Create scanner object

        System.out.println("How many numbers do you want to sum? ");

        int howMany = scanner.nextInt(); //Input for how many numbers the user wants to sum

        int sum = 0; //Initialize sum

        for (int i = 0; i < howMany; i++) //Ask the user to input numbers to sum
        {
            System.out.println("Input a number: ");

            int num = scanner.nextInt();

            sum += num; //add to the sum
        }

        System.out.println("The sum is: " + sum); //print the sum
    }
}
