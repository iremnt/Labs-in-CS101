// Lab 01, Q3, Finding fibonacci numbers, Gülser İrem AÇIKGÖZ, 13.02.2025 


//import scanner pack to have input from user
import java.util.Scanner;

public class Lab01_Q3 {
    public static void main(String[] args) {
        final double PHI_GOLDEN_RATIO = (1 + Math.sqrt(5)) / 2; //constant for formula
        int termNumber, nThFibonacciNumber;// crating variables former one from user latter one output of this programme

        //creating a scanner object
        Scanner input = new Scanner(System.in);

        //having the term number from user
        System.out.print("Type a number for nth term of fibonacci: ");
        termNumber = input.nextInt();

        //calculating nth term of fibonacci
        nThFibonacciNumber = (int) ((Math.pow(PHI_GOLDEN_RATIO, termNumber) - Math.pow(-PHI_GOLDEN_RATIO, -termNumber)) / Math.sqrt(5.0));

        System.out.println("Fibonacci(" + termNumber + ") is " + nThFibonacciNumber);
        
        //closing scanner
        input.close();
    }
}