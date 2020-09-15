/*
 * Name: Phillip Rojkov
 * Date: 2020-09-14
 * Assignment Name: (U1-A4-0914) Solving a Word Problem
 * Description: Assignment 3. Calculates and prints the answers to a word problem.
 */

public class RojkovWordProblem
{
    public static void main(String[] args)
    {
        /*
        A car-rental firm uses this formula, C = 28.5D + 0.095 (d - 75), to calculate the cost, C dollars,
        of using one of their cars for D days to travel d kilometers (d > 75). Find how much the firm will
        charge a customer who uses the car for 5 days and travels 955 km.
         */

        float days = 5; //days driven
        float distance = 955; //distance traveled

        float cost; //initialize cost

        if (distance > 75) //distance is greater than 75 kilometers
        {
            cost = 28.5f * days + 0.095f * (distance - 75f); //calculate cost using formula
        }
        else //distance is less than 75 kilometers
        {
            cost = 28.5f * days + 0.095f; //calulate cost using formula without distance component
        }

        System.out.println("The customer has driven for: " + days + " days.");
        System.out.println("The customer has driven: " + distance + "kilometers.");
        System.out.println("The cost is: " + cost + "dollars");
    }
}