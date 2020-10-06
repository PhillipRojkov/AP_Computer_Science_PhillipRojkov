/*
 * Name: Rojkov Phillip
 * Date: 2020-10-05
 * Assignment Name: (1005) U4A2 - Assignment 2
 * Description: Use nested for loops to count to 1000 in 11 lines without executing a loop > 10 times
 */

public class RojkovCounter
{
    public static void main(String[] args)
    {
        for (int i = 0; i < 10; i++)
        {
            for (int j = 0; j < 10; j++)
            {
                for (int k = 0; k < 10; k++)
                {
                    System.out.print(k + (i * 100 + j * 10) + " "); //Print the number and a space
                }
                System.out.println(); //go down one line every 10 numbers for better readability in console
            }
        }
    }
}
