/*
 * Name: Rojkov Phillip
 * Date: 2020-09-23
 * Assignment Name: (0923c) Using Scanner with Strings
 * Description: Use the String and Scanner object to ask for and shorten a celebrity name
 */

import java.util.*;
import java.io.*;

public class RojkovMoreCelebrities
{
    public static void main(String[] args)
    {
        int charsTakeOffBeginning = 2; //Characters to take off the beginning
        int charsTakeOffEnd = 3; //Characters to take off the end

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

         shortenName(name, charsTakeOffBeginning, charsTakeOffEnd);
        }
    }

    public static void shortenName (String name, int charsTakeOffBeginning, int charsTakeOffEnd) //Shortens and prints the shortened input name
    {
        if (name.length() <= (charsTakeOffBeginning + charsTakeOffEnd)) //The name shortening only works for names longer than 5 letters (otherwise error) so check here
        {
            System.out.println("That name is too short!");
        } else {
            int var1 = charsTakeOffBeginning; //Beginning of substring
            int var2 = name.length() - charsTakeOffEnd; //End of substring

            String shortenedName = name.substring(var1, var2); //Get the portion of the name not including first 2 and last 3 letters

            System.out.println(name + ">>>" + shortenedName); //Print shortened name
        }
    }
}
