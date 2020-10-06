/*
 * Name: Rojkov Phillip
 * Date: 2020-10-05
 * Assignment Name: (1005) U4A4 - Programming Project 1
 * Description: Use for loops to print a picture of an hourglass
 */

public class RojkovHourglass
{
    public static void main(String[] args)
    {
        //endWidth and height can be edited
        int endWidth = 11; //The width of the top |"""""'| line. Must be odd. Default 11
        int height = 10; //The entire height of the picture. Must be even. Default 10

        int width = height - 3; //The number of : at the top of the hourglass body. Must be odd.
        // width  must be directly calculated from height so that the middle has a width of 1 ":" char.

        drawHourglass(endWidth, width, height); //Call the drawHourglass function
    }

    public static void drawHourglass(int endWidth, int width, int height) //Draw the hourglass shape
    {
        drawEnd(endWidth, width); //Draw |""'|
        drawMiddleUpper(width, height); //Draw upper portion, \:/
        drawMiddleLower(width, height); //draw lower portion, /:\
        drawEnd(endWidth, width); //Draw |""'|
    }

    public static void drawEnd(int endWidth, int width) //Draw the end pieces.
    {
        int offset = width - endWidth / 2; //calculate the offset so that the end piece is centred
        /* endWidth / 2 is rounded down. width is already divided by 2 because the : characters
        *  all have spaces between them.
         */

        for (int i = 0; i < offset; i++)
        {
            System.out.print(" "); //Add a horizontal offset
        }

        System.out.print("|"); //print |
        for (int i = 0; i < endWidth - 3; i++) //the - 3 is due to the extra | and '| characters on each end
        {
            System.out.print("\""); //print "
        }
        System.out.println("'|"); //print '|
    }

    public static void drawMiddleUpper(int width, int height)
    {
        //Draw upper half of middle
        for (int i = 0; i < height/2 - 1; i++) //Iterate print the hourglass body sections for half the height - 1
        {
            for (int j = 0; j < i; j++)
            {
                System.out.print("  "); //Indent the beginning \ of the hourglass by two more spaces each iteration i
            }
            System.out.print("\\"); //print \ to begin the hourglass portion

            for (int k = 0; k < width - 2 * i - 1; k++) //The width of the hourglass portion is two less each iteration
            {
                System.out.print(": "); //Print : and a space
            }
            System.out.println(":/");
            /*Print :/ to end hourglass. This is the reason for - 1 in
            * k < width -2 * i - 1;
             */
        }
    }

    public static void drawMiddleLower(int width, int height)
    {
        //Draw lower half of middle
        for (int i = 0; i < height/2 - 1; i++) //Iterate print the hourglass body for half the height - 1
        {
            for (int j = height/2 - 2; j > i; j--)
            {
                System.out.print("  "); //Indent the beginning / of the hourglass by two fewer spaces each iteration i
            }
            System.out.print("/"); //print / to begin the hourglass portion

            for (int k = 0; k < 2 * i; k++) //The width of the hourglass portion is two more each iteration
            {
                System.out.print(": "); //Print : and a space
            }
            System.out.println(":\\"); //Print :\ to end hourglass.
        }
    }
}