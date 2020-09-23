/*
 * Name: Rojkov Phillip
 * Date: 2020-09-22
 * Assignment Name: (0923b) Using the MATH Object - Compute This!
 * Description: Use methods from the Math class to solve equations
 */

public class RojkovComputeThis
{
    public static void main(String[] args)
    {
        double d1 = 3 * Math.PI * Math.sin(Math.toRadians(187)) + Math.abs(Math.cos(Math.toRadians(122))); //Calculate d1. parameters for Math.sin and cos must be in radians
        System.out.println("d1 = " + d1); //print d1

        double d2 = Math.pow(14.72, 3.801) + Math.log(72); //Calculate d2. Math.log uses natural log e
        System.out.println("d2 = " + d2); //print d2

        //Custom
        double d3 = Math.sin(Math.toRadians(301)) + Math.abs(-11 * Math.pow(41, 4)); //Calculate custom d3
        System.out.println("d3 = " + d3); //print custom d3
    }
}
