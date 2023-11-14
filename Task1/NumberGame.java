import java.util.*;
import java.util.Scanner;
class NumberGame{
    public static void main(String args[]){
        System.out.println("Welcome to the NUMBER GAME");
        System.out.println("--------------------------------");
        System.out.println("Instructions:\n");
        System.out.println("Each time a new number will be \ngenerated you need to guess \nthat number within the limited \nattempts.You will be having only \n5 attempts to guess that number.");
        System.out.println("\nSo Best Of Luck !!!");
        System.out.println("--------------------------------");
        int choice=0;
        int round=1;
        
        do{
            Random r = new Random();
            int number=r.nextInt(1, 101);
            int roundScore=guessNumber(number,round);
            System.out.println("--------------------------------");
            System.out.println("Round "+round+" Score : "+roundScore);
            System.out.println("--------------------------------");
            System.out.println("Want to play for round "+(round+1));

            System.out.println("Type [1] for Yes or [0] for No or any Key to exit:");
            Scanner sc = new Scanner(System.in);
            choice = sc.nextInt();
            System.out.println("--------------------------------");
            if(choice ==1)
            {
                round++;
            }
            else
            {
                System.exit(0);
            }
        }while(choice==1);
        
    }

    public static int guessNumber(int number,int round)
    {
        int attempts=5;
        int score=100;
        int guess;
        System.out.println("--------------------------------");
        System.out.println("Round "+round);
        System.out.println("--------------------------------");
        while(true)
        {
            System.out.println("Options:\n");
            System.out.println("press 1 to guess the Number\npress 2 to display attempts left\npress 3 to exit");
            Scanner sc = new Scanner(System.in);
            int option=sc.nextInt();
            System.out.println("--------------------------------");
            switch(option)
            {
                case 1:
                {
                    System.out.println("Enter Your Number:");
                    guess=sc.nextInt();
                    if(guess>number)
                    {
                        if (attempts==1)
                        {
                            System.out.println("Sorry You Lose Your Attempts");
                            System.out.println("The Actual Number Was "+number);
                            return 0;
                        }
                        System.out.println("--------------------------------");
                        System.out.println("The Number Seems Too High..Try to Guess Lower value..");
                        attempts--;
                        score-=20;
                        System.out.println("Your Attempts Left : "+attempts);
                        System.out.println("--------------------------------");
                    }
                    else if(guess<number)
                    {
                        if (attempts==1)
                        {
                            System.out.println("Sorry You Lose Your Attempts");
                            System.out.println("The Actual Number Was "+number);
                            return 0;
                        }
                        System.out.println("--------------------------------");
                        System.out.println("The Number Seems Too Low..Try to Guess Higher value..");
                        attempts--;
                        score-=20;
                        System.out.println("Your Attempts Left : "+attempts);
                        System.out.println("--------------------------------");
                    }
                    else
                    {
                        System.out.println("--------------------------------");
                        System.out.println("Congratulations!!!...You Guessed The Right Number...");
                        System.out.println("Your Score is : "+score);
                        System.out.println("Your Attempts Left : "+attempts);
                        System.out.println("--------------------------------");
                        return score;
                    }
                    break;
                }
                case 2:
                {
                    // System.out.println("--------------------------------");
                    System.out.println("Your Attempts Left : "+attempts);
                    System.out.println("--------------------------------");
                    break;
                }
                case 3:
                {
                    System.exit(0);
                }
                default:
                {
                    System.out.println("--------------------------------");
                    System.out.println("You may have selected a wrong option");
                    System.out.println("--------------------------------");
                }
            }
        }        
    }
}