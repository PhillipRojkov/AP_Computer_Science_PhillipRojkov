public class ExerciseSum
{
    public static void main(String[] args)
    {
        sum(3); //Run sum fuction with input 3

        sum(100); //Run sum funciton with input 100
    }

    public static void sum(int n) //Sums all the numbers n-1
    {
        int summed = 0;

        for (int i = 0; i < n; i++)
        {
            summed += n - i;
        }

        System.out.println(summed);
    }
}
