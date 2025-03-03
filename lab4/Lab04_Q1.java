import java.util.Random;
import java.util.Scanner;

// Lab 04, Q1, Guess The Number, Gülser İrem AÇIKGÖZ, 6.03.2025 

public class Lab04_Q1 {
    public static void main(String[] args) {
        int randomNumber, usersGuess;
        boolean guessed = false;

        Random random = new Random();
        randomNumber = random.nextInt(101);
        while(!guessed){
            Scanner input = new Scanner(System.in);
            System.out.print("Guess the number: ");
            usersGuess = input.nextInt();
            if (usersGuess == randomNumber){
                guessed = true;
                System.out.println("Congratulations, you guessed it!");
            }
            else if( Math.abs(randomNumber - usersGuess) <= 10){
                if (randomNumber > usersGuess)
                    System.out.println("close but low, try again…");
                else 
                    System.out.println("close but high, try again…");

            }
            else{
                if(randomNumber > usersGuess)
                    System.out.println("too low, try again...");
                else
                    System.out.println("too high, try again...");
            }
        }
    }
}
