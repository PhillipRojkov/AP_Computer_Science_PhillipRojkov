/*
* author: Phillip Rojkov
 */

public class Cereal {
    private String name;
    private int sugar;

    public Cereal(String n, int s) {
        name = n;
        sugar = s;
    }

    public String getName(){
        return name;
    }

    public int getSugar(){
        return sugar;
    }

    public String toString(){
        return name + ", " + sugar;
    }
}
