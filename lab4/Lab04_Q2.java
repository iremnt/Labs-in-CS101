import java.util.Scanner;

// Lab 04, Q2, Super Prime Numbers, Gülser İrem AÇIKGÖZ, 6.03.2025 

public class Lab04_Q2 {
    public static void main(String[] args) {
        int usersNumber, index, allSmalls, allSmallsSmalls;
        String primes;
        boolean isPrime;

        Scanner input = new Scanner(System.in);
        System.out.print("Enter a number: ");
        usersNumber = input.nextInt();

        while (usersNumber >= 2){
            primes = "2";
            allSmalls = 3;
            index = 1;
            while (allSmalls < usersNumber) {
                isPrime = true;
                allSmallsSmalls = 2;
                while (allSmallsSmalls != allSmalls){
                    if (allSmalls % allSmallsSmalls == 0 && isPrime)
                        isPrime = false;
                    allSmallsSmalls++;
                }
                if (isPrime){
                    index++;
                    isPrime = true;
                    allSmallsSmalls = 2;
                    while (allSmallsSmalls != index && index >= 2 && isPrime){
                        if (index % allSmallsSmalls == 0)
                            isPrime = false;
                        allSmallsSmalls++;
                    }
                    if(isPrime){
                        primes += ", (" + allSmalls + ")";
                    }
                    else
                        primes += ", " + allSmalls;
                }
                allSmalls++;
            }
            System.out.printf("Prime numbers less than or equal to %d: %s\n",usersNumber,primes);
            System.out.print("\nEnter a number: ");
            usersNumber = input.nextInt();
        }
        System.out.println("Program finished.");
        input.close();
        
    }
}