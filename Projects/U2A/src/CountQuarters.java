//P 193, Question 17

public class CountQuarters
{
    public static void main(String[] args)
    {
        int cents = 64;

        int quarters = countQuarters(cents);

        System.out.println(quarters + " quarters");
    }

    public static int countQuarters(int cents)
    {
        int remainderCents = cents % 100; //find remaining cents after dollar bills removed

        return (int)(remainderCents / 25); //Devide remainder cents into quarters and cast as int to round down
    }
}
