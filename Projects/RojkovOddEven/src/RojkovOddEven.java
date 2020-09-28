/*
 * Name: Rojkov Phillip
 * Date: 2020-09-27
 * Assignment Name: (O930) Programming Assignment - ODD/EVEN (If Statements)
 * Description: Use if statements and a while loop to determine if a user inputs even or odd numbers
 */

import java.util.*;

public class RojkovOddEven
{
    public static Scanner scanner = new Scanner(System.in); //Create scanner object

    public static void main(String[] args)
    {
        System.out.print("What is your name? ");

        String name = scanner.nextLine(); //Read user input name

        System.out.println(); //New line

        Boolean askAgain = true;

        while (askAgain)
        {
            askAgain = inputAnother(); //Ask if user wants to input another number

            System.out.println(""); //New line

            if (askAgain) //User wants to enter a number
            {
                System.out.println("Enter an integer: ");

                int num = scanner.nextInt(); //Read user input number

                /*nextInt leaves \n in input stream
                 * Let's empty the input stream with a call to nextLine
                 */
                scanner.nextLine();

                checkNumber(num); //Check and output if num is odd or even
            }
            else //The user does not want to input another number
            {
                System.out.println(name + ", the program is over.");
            }
        }
    }

    public static Boolean inputAnother() //Ask and return true if the user wants to input another number
    {

        int retries = 0;

        while (retries++ < 100) //Give user a chance to answer correctly up to 100 tries
        {
            System.out.println("Would you like to input a number (Y/N)? ");

            String input = scanner.nextLine(); //User inputs Y or N

            if (input.equals("Y")) //User wants to input a number
            {
                return true;
            }
            else if (input.equals("N")) //User doesn't want to input a number
            {
                return false;
            }
            System.out.println("Invalid input, please enter 'Y' or 'N'");
        }

        //Avoid infinite loop by throwing exception when user fails valid input 100 times
        throw new IllegalStateException("Exceeded maximum amount of tries");
    }

    public static void checkNumber(int num) //Check if a number is odd or even
    {
        if ((num % 2) == 0) //if even
        {
            System.out.println("The integer " + num + " is even. \n");
        }
        else
        { //if odd
            System.out.println("The integer " + num + " is odd. \n");
        }
    }
}
