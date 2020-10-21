/*
 * Name: Phillip Rojkov
 * Date: October 16, 2020
 * Assignment Name: (1016) U6-A1: Assignment 1, for (Unit 6) Arrays
 * Description: Write code that stores all odd numbers between min and max values into an array using a loop
 */

public class PRArray {
    public static void main(String[] args) {
        int min = -6; //minimum number of the array (inclusive unless even)
        int max = 38; //maximum number of the array (inclusive unless even)

        if (min % 2 == 0) {
            min++; //set min to an odd int if it is even
        }
        if (max % 2 == 0) {
            max--; //set max to an odd int if it is even
        }

        int length = (max - min) / 2 + 1; //remember that length is rounded down. This is the reason for +1
        int[] array = new int[length]; //Create the array object

        for (int i = 0; i < length; i++) { //Iterate through the array to set all the values
            array[i] = min + 2 * i;
        }

        for (int i : array) { //Print out the values of the array using a for-each loop
            System.out.println(i);
        }
    }
}