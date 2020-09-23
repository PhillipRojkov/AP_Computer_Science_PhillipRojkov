/*
 * Name: Rojkov Phillip
 * Date: 2020-09-22
 * Assignment Name: NameThatCelebrity
 * Description: Extrapolate the name of celebrities with a substring or section of their name
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
    }

    public static void shortenName (String name)
    {
        String shortenedName = name.substring(2, name.length() - 3); //Get the portion of the name not including first 2 and last 3 letters

        System.out.println(shortenedName); //Print shortened name
    }
}