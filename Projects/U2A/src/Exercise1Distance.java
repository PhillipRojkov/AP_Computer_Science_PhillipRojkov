//Exercise 1, Write a method called distance

public class Exercise1Distance
{
    public static void main(String[] args)
    {
        int x1 = 0; //First coordinate pair
        int y1 = 2;

        int x2 = 64; //Second coordinate pair
        int y2 = 85;

        double distance = distance(x1, y1, x2, y2);

        System.out.println(distance);
    }

    public static double distance(int x1, int y1, int x2, int y2)
    {
        return (double) (Math.sqrt(Math.pow((x2 - x1), 2) + Math.pow((y2 - y1), 2)));
    }
}
