/*
 * Name: Phillip Rojkov
 * Date: November 5, 2020
 * Assignment Name: (1105-U10A1) Unit 10 Assignment 1 - Creating a program that generates a "modified" Fibonacci term.
 * Inputs: Accepts an integer input greater or equal to 0
 * Outputs: The term in the modified fibonacci sequence at 'input'
 */

import java.util.*;

public class RojkovMain {
    public static void main(String[] args) {
        Scanner kbReader = new Scanner(System.in); //Create scanner object
        System.out.print("Generate which number? "); //Ask user to input a number
        int k = kbReader.nextInt(); //Initialize int k to user input (Must be >= 0)

        //Print out the Kth term of the modified fibonacci sequence
        System.out.println("Term# " + k + " is " + ModFib.modFibonacci(k));
    }
}
