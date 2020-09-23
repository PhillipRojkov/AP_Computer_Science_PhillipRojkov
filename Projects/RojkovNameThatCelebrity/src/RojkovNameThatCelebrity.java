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
        //Names
        String s1 = "Allan Alda";
        String s2 = "John Wayne";
        String s3 = "Gregory Peck";
        String s4 = "Justin Truedeau";

        shortenName(s1);
        shortenName(s2);
        shortenName(s3);
        shortenName(s4);
    }

    public static void shortenName (String name) //Shortens and prints the shortened input name
    {
        String shortenedName = name.substring(2, name.length() - 3); //Get the portion of the name not including first 2 and last 3 letters

        System.out.println(name + ">>>" + shortenedName); //Print shortened name
    }
}
