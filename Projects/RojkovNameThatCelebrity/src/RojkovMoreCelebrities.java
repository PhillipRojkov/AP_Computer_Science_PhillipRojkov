/*
 * Name: Rojkov Phillip
 * Date: 2020-09-23
 * Assignment Name: (0923c) Using Scanner with Strings
 * Description: Use the String and Scanner object
 */

import java.util.*;
import java.io.*;

public class RojkovMoreCelebrities
{
    public static void main(String[] args)
    {
        //Names
        /*
        String s1 = "Allan Alda";
        String s2 = "John Wayne";
        String s3 = "Gregory Peck";
        */

    while (true) //Keep asking for more celebrity names and shortening them
        {
          System.out.println("Enter the name of a celebrity:");
          Scanner scanner = new Scanner(System.in);

          String name = scanner.nextLine();

         shortenName(name);
        }
    }

    public static void shortenName (String name) //Shortens and prints the shortened input name
    {
        if (name.length() <= 5) //The name shortening only works for names longer than 5 letters (otherwise error) so check here
        {
            System.out.println("That name is too short!");
        } else {
            String shortenedName = name.substring(2, name.length() - 3); //Get the portion of the name not including first 2 and last 3 letters

            System.out.println(name + ">>>" + shortenedName); //Print shortened name
        }
    }
}
