import java.util.Scanner;

// Lab 04, Q2, Super Prime Numbers, Gülser İrem AÇIKGÖZ, 6.03.2025 

public class Lab04_Q2 {
    public static void main(String[] args) {
        int usersNumber;//input
        int index, numberToCheck, divisor;// index, all values smaller than userNumber(or index), all values smaller than (all values smaller than user number)
        String primes;//final string output
        boolean isPrime;// a boolean variable to check primes

        Scanner input = new Scanner(System.in);
        System.out.print("Enter a number: ");
        usersNumber = input.nextInt();

        while (usersNumber >= 2){//if its not program wouldnt progress
            primes = "2";//always there is 2
            numberToCheck = 3;//starting with 3 bc always there is 2
            index = 1;
            while (numberToCheck <= usersNumber) {//if user input 2 this code wouldnt work
                isPrime = true;//initialize true
                divisor = 2;//not 1 but 2 bc definition of prime
                while (divisor != numberToCheck){
                    if ((numberToCheck % divisor == 0) && isPrime)//check prime
                        isPrime = false;
                    divisor++;
                }
                if (isPrime){//if it is prime
                    index++;//now index higher than 1 bc index 1 is 2 and its not super prime

                    isPrime = true;//its actually unnecessary but i want to show this value indicates another thing
                    divisor = 2;
                    while ((divisor != index) && isPrime){
                        if (index % divisor == 0)//check wether index is prime
                            isPrime = false;
                        divisor++;
                    }
                    if(isPrime){//super prime
                        primes += ", (" + numberToCheck + ")";
                    }
                    else//prime but not super
                        primes += ", " + numberToCheck;
                }
                numberToCheck++;//check other values
            }
            System.out.printf("Prime numbers less than or equal to %d: %s\n", usersNumber, primes);

            System.out.print("\nEnter a number: ");
            usersNumber = input.nextInt();
        }
        System.out.println("Program finished.");
        input.close();      
    }
}