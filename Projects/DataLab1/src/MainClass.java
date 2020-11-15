/*
 * author: Phillip Rojkov
 */

public class MainClass {
    public static void main(String[] args) {
        //Create some cereal objects
        Cereal bran100 = new Cereal("100% Bran", 6);
        Cereal wheatiesHG = new Cereal("Wheaties Honey Gold", 8);

        //Compare the two cereal objects and print the output
        System.out.println(compareSugar(bran100, wheatiesHG));
    }

    //Compares two input cereals
    public static String compareSugar(Cereal c1, Cereal c2) { //Return the name of the cereal with most sugar
        if (c1.getSugar() > c2.getSugar()) {
            return c1.getName();
        } else if (c1.getSugar() < c2.getSugar()) {
            return c2.getName();
        }
        return "equal";
    }
}
