//Blastoise
public class PokemonChallenge
{
    static int baseHP = 79;

    static int baseAttack = 83;

    static boolean isShedinja = false;

    public static void main(String[] args)
    {
        System.out.println("Blastoise has reached level 100");

        int HP = HP100(baseHP);
        System.out.println("HP is: " + HP);

        int Attack = Attack100(baseAttack);
        System.out.println("Attack is: " + Attack);
    }

    public static int HP100 (int baseHP) //return new HP at level 100
    {
        if (!isShedinja) { //Check if Shedinja, if yes, HP = 1
            return 2 * baseHP + 110;
        } else {
            return 1;
        }
    }

    public static int Attack100 (int baseAttack) //return new Attack at level 100
    {
        return 2 * baseAttack + 5;
    }
}
