/*
 * Name: Rojkov Phillip
 * Date: 2020-10-05
 * Assignment Name: (1005) U4A1 - Assignment 1
 * Description: Keep track of and write the sum of 100 + 99 + 88 +... + 1
 */

public class RojkovSUMValues
{
    public static void main(String[] args)
    {
        int max = 100;
        int min = 1;

        int sum = 0;
        for (int i = max; i >= min; i--) //Count down from max to min (inclusive) and add those numbers
        {
            sum += i; //Add i to sum
        }

        System.out.print("max is: " + max + "\nmin is: " + min + "\nSum is: " + sum); //Print the sum
    }
}
