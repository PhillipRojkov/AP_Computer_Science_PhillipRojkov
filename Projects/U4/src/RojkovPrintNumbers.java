/*
 * Name: Rojkov Phillip
 * Date: 2020-10-05
 * Assignment Name: (1005) U4A1 - Assignment 1
 * Description: Write a program that counts down from 100 down to 1
 */

public class RojkovPrintNumbers
{
    public static void main(String[] args)
    {
        int max = 100;
        int min = 1;

        for (int i = max; i >= min; i--) //Count down from max to min (inclusive)
        {
            System.out.println(i); //print i
        }
    }
}
