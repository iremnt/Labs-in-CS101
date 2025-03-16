import java.util.Scanner;

// Lab 04, Q3, Eliminate the Odd Digits, Gülser İrem AÇIKGÖZ, 6.03.2025 

public class Lab04_Q3{
    public static void main(String[] args){
        int userNumber, digit, even = 0;
        int index = 0;

        Scanner input = new Scanner(System.in);
        System.out.print("Enter a positive integer of at least 5 digits: ");
        userNumber = input.nextInt();

        while ( userNumber >= 0){//valid value
            if (userNumber >= 10000){//valid value 5 digits
                while (userNumber > 0){//work until there is no digits
                    digit = userNumber % 10;//find the last digits
                    userNumber = userNumber / 10;//substract it
                    if (digit % 2 == 0){//check if it even
                        even += Math.pow(10,index) * digit;//add it considering the digit
                        index++;
                    }
                }
                System.out.println("Here is the number without the odd digits: " + even);
            }
            else
                System.out.println("The number you entered is invalid, please try again…");//too short
            //reset values
            index = 0;
            even = 0;
            //ask again
            System.out.print("\nEnter a positive integer of at least 5 digits: ");
            userNumber = input.nextInt();
        }
        System.out.println("Program finished.");//negative value
    }
}