/*
 * Name: Rojkov Phillip
 * Date: 2020-09-22
 * Assignment Name: (0923) Using the string and Scanner Objects
 * Description: Use the String methods to shorten a celebrity's name
 */

public class RojkovNameThatCelebrity
{
    public static void main(String[] args)
    {
        int charsTakeOffBeginning = 2; //Characters to take off the beginning
        int charsTakeOffEnd = 3; //Characters to take off the end

        //Names
        String s1 = "Allan Alda";
        String s2 = "John Wayne";
        String s3 = "Gregory Peck";
        String s4 = "Justin Truedeau";

        shortenName(s1, charsTakeOffBeginning, charsTakeOffEnd);
        shortenName(s2, charsTakeOffBeginning, charsTakeOffEnd);
        shortenName(s3, charsTakeOffBeginning, charsTakeOffEnd);
        shortenName(s4, charsTakeOffBeginning, charsTakeOffEnd);
    }

    public static void shortenName (String name, int charsTakeOffBeginning, int charsTakeOffEnd) //Shortens and prints the shortened input name
    {
        int var1 = charsTakeOffBeginning; //Beginning of substring
        int var2 = name.length() - charsTakeOffEnd; //End of substring

        String shortenedName = name.substring(var1, var2); //Get the portion of the name not including first 2 and last 3 letters

        System.out.println(name + ">>>" + shortenedName); //Print shortened name
    }
}
