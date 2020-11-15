/*
 * Class Name: MergeSort
 * Date Created: November 6, 2020
 * Details: Merge sort class - method merge sort takes an integer arrayList parameter and returns sorted integer arrayList
 * Methods: public static ArrayList<Integer> mergeSort(ArrayList<Integer> list)
 *          private static ArrayList<Integer> merge(ArrayList<Integer> list1, ArrayList<Integer> list2);
 * Static Variables: none
 */

import java.util.*;

public class MergeSort {
    public static ArrayList<Integer> mergeSort(ArrayList<Integer> list){ //mergeSort method, takes Integer list input and returns an Integer list
        if (list.size()  <= 1) { //If the list size is 0 or 1 it is already sorted
            return list;
        }

        ArrayList<Integer> list1 = new ArrayList<>(); //Create list1 variable to store the first half of list
        for (int i = 0; i < list.size() / 2; i++) { //put first half of list into list1
            list1.add(list.get(i));
        }
        ArrayList<Integer> list2 = new ArrayList<>(); //Create list2 variable to store the second half of list
        for (int i = list.size() / 2; i < list.size(); i++) { //put second half of list into list2
            list2.add(list.get(i));
        }

        //Recursively call mergeSort on list1 and list2
        list1 = mergeSort(list1);
        list2 = mergeSort(list2);

        //return list1 and list2 merged (sorted) together
        return merge(list1, list2);
    }

    private static ArrayList<Integer> merge(ArrayList<Integer> list1, ArrayList<Integer> list2) { //merge method takes two integer lists
        ArrayList<Integer> output = new ArrayList<>(); //Create integer list to hold output

        int l1 = 0, l2 = 0; //l1 and l2 represent indexes of list1 and list2
        while(l1 < list1.size() && l2 < list2.size()) { //Sort from index 0 all the way to the end of one list (list1 and list2 are already sorted!)
            if (list1.get(l1) < list2.get(l2)) { //index l1 of list1 is larger than index l2 of list2
                output.add(list1.get(l1));
                l1++;
            } else { //index l1 of list1 is smaller than index l2 of list2
                output.add(list2.get(l2));
                l2++;
            }
        }
        //We have reached the end of one list so now we need to add the rest of the remaining list (which is already sorted) to output
        while(l1 < list1.size()) { //Add the end of list1 to output
            output.add(list1.get(l1));
            l1++;
        }
        while(l2 < list2.size()) { //Add the end of list2 to output
            output.add(list2.get(l2));
            l2++;
        }

        return output;
    }
}
