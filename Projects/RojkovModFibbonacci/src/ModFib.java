/*
 * Class Name: ModFib
 * Date Created: November 5, 2020
 * Details: Contains static int modFibonnacci recursive method that returns the Kth term of the modified fibonacci sequence
 * Methods: public static int modFibonnacci(int k)
 * Static Variables: none
 */

public class ModFib {
    public static int modFibonacci(int k) { //Returns integer which represents the Kth term of the modified fibonacci sequence
        if (k == 0) { //Since the recursion requires the three previous terms, we need to explicitly declare them here
            return 3; //Term 0 is 3
        } else if (k == 1) {
            return 5; //Term 1 is 5
        } else if (k == 2) {
            return 8; //Term 2 is 8
        }
            //Recursive call to compute fibonacci sequence
            return modFibonacci(k - 1) + modFibonacci(k - 2) + modFibonacci(k - 3);
    }
}
