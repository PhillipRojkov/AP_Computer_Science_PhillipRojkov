/*
 * Name: Phillip Rojkov
 * Date: November 6, 2020
 * Assignment Name: (1106-U10A3) Unit 10 Assignment 3 - Implement mergeSort
 * Inputs: none
 * Outputs: Sorted arrayLists initialized in main
 */

import java.util.*;

public class RojkovMain {
    public static void main(String[] args) {
        //Test arrayLists
        ArrayList<Integer> list1 = new ArrayList<Integer>(List.of(6,2,1,4,5,7,3,8,9));
        ArrayList<Integer> list2 = new ArrayList<Integer>(List.of(5,1,2,35,61,236,3,3));

        //Print out sorted lists using mergeSort
        System.out.println(MergeSort.mergeSort(list1));
        System.out.println(MergeSort.mergeSort(list2));
    }
}
