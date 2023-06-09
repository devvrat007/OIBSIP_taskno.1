import java.util.Scanner;
import java.lang.Math;

public class NumberGuessing
{
    public static void guessing()
    {
        boolean play=true;
        while(play)
        { play=false;
            int randomNumber = 1 + (int) (Math.random() * 100);
            System.out.println("Difficulty level : \n Easy (7 try) type 1 \n Medium (5 try) type 2 \n Hard (3 try) type 3");
            int easy = 7;
            int medium = 5;
            int hard = 3;
            int maxAttepmt = 0;
            int guessed=0;
            Scanner ab = new Scanner(System.in);
            int difficulty = ab.nextInt();
            switch (difficulty)
            {
                case 1:
                    maxAttepmt = 7;
                    break;
                case 2:
                    maxAttepmt = 5;
                    break;
                case 3:
                    maxAttepmt = 3;
                    break;
                default:
                    System.out.println("Not a valid difficulty");

            }

            for(int i=0;i<maxAttepmt;i++)
            {
                System.out.println("give guessed number");
                int GNumber=ab.nextInt();

                if(GNumber==randomNumber)
                {
                    System.out.println("Congratulation!! you guessed it right :)");
                    guessed=1;
                    break;
                } else if (GNumber<randomNumber)
                {
                    System.out.println("The number is greater than your guessed number");
                } else
                {
                    System.out.println("The number is lesser than your guessed number");
                }
            }
            if(guessed!=1)
            {
                System.out.println("Sorry , you did not guess the number. \n the correct number was "+randomNumber);
            }
            System.out.println("Do you want to play again?? Yes/No");
            String playAgain=ab.next().toLowerCase();
            play=playAgain.equals("yes");

        }
    }

    public static void main(String[] args)
    {
        guessing();
    }
}



