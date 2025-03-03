import java.util.Scanner;

// Lab 04, Q2, Eliminate the Odd Digits, Gülser İrem AÇIKGÖZ, 6.03.2025 

public class Lab04_Q3 {
    public static void main(String[] args) {
        int index;
        String usersNumber;
        String evenDigits = "0";
        Scanner input = new Scanner(System.in);
        System.out.print("Enter a positive integer of at least 5 digits: ");
        usersNumber = input.nextLine();
        while(Integer.parseInt(usersNumber) > 0){
            
            if (usersNumber.length() >= 5){
                index = 0;
                while (index < usersNumber.length()){
                    if (Integer.parseInt(usersNumber.charAt(index) + "") % 2 == 0)
                        evenDigits += usersNumber.charAt(index);
                    index++;
                }
                System.out.println("Here is the number without the odd digits: " + Integer.parseInt(evenDigits));
            }
            else
                System.out.println("The number you entered is invalid, please try again…");
            evenDigits = "0";
            System.out.print("\nEnter a positive integer of at least 5 digits: ");
            usersNumber = input.nextLine();
        }
        System.out.println("Program finished.");
        input.close();
    }
}
