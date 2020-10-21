//Write a program that converts user input to pig latin

import java.util.*;

public class PigLatin {

    public String sentinel = "";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Input a phrase. Input a blank line to quit.");
            String input = scanner.nextLine();

            if (input.equals("")) {
                break;
            }
            String output = "";

            Boolean runLoop = true; //run the loop the time after next
            while (runLoop) {
                String sub;
                if (input.contains(" ")) {
                    sub = input.substring(0, input.indexOf(" ")); //Get the first word
                    input = input.substring(input.indexOf(" ") + 1); //input = input - the first word
                } else { //This is the last word
                    sub = input; //Get the last word
                    runLoop = false; //Don't run this loop again
                }

                //Check if first letter is vowel
                if (sub.indexOf("a") == 0 || sub.indexOf("e") == 0 ||
                        sub.indexOf("o") == 0 || sub.indexOf("i") == 0 ||
                        sub.indexOf("u") == 0) {
                    output += sub + "-ay ";
                } else { //The first letter is not a vowel
                    int firstVowelIndex = 0;
                    for (int i = 0; i < sub.length(); i++) { //Find the index of the first vowel
                        if (sub.indexOf("a") == i || sub.indexOf("e") == i ||
                            sub.indexOf("o") == i || sub.indexOf("i") == i ||
                            sub.indexOf("u") == i) {
                            firstVowelIndex = i;
                            break;
                        }
                    }
                    //output += from the firstVowelIndex onwards + "-" + first letter of sub + "ay "
                    output +=  sub.substring(firstVowelIndex) + "-" + sub.substring(0, firstVowelIndex) + "ay ";
                }
            }
            System.out.println(output); //print the output
        }
    }
}
