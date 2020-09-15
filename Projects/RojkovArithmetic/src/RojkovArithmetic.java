/*
 * Name: Phillip Rojkov
 * Date: 2020-09-14
 * Assignment Name: (U1-A3-0914) Arithmetic Assignment
 * Description: Assignment 2. Calculates and prints the answers to some arithmetic.
*/

public class RojkovArithmetic
{
    public static void main(String[] args)
    {
        //First equation
        int result01 = 79 + 3 * (4 + 82 - 68) - 7 + 19; //calculate result01

        System.out.println("79 + 3 * (4 + 82 - 68) - 7 + 19 = " + result01); //Write equation 1 and result01 to console

        //Second equation
        int result02 = (179 + 21 + 10) / 7 + 181; //calculate result02

        System.out.println("(179 + 21 + 10) / 7 + 181 = " + result02); //Write equation 2 and result02 to console

        //Third equation
        int result03 = 10389 * 56 * 11 + 2246; //calculate result03

        System.out.println("10389 * 56 * 11 + 2246 = " + result03); //Write equation 3 and result03 to console

        //Fourth equation (unique)
        int result04 = 1423 * (12 + 9^3) - 6378;

        System.out.println("1423 * (12 + 9^3) - 6378 = " + result04); //Write equation 4 and result04 to console
    }
}
