import java.util.Scanner;

// Lab 02, Q2, Mythical Names, Gülser İrem AÇIKGÖZ, 20.02.2025 

public class Lab02_Q3 {
    public static void main(String[] args) {
        String name, color; //variables from user
        String mythical; //output
        char first, last;

        //scanning variables from user
        Scanner input = new Scanner(System.in);
        System.out.print("Enter your name: ");
        name = input.next();
        System.out.print("Enter your favorite color: ");
        color = input.next();
        input.close();

        //swapping first and last letters of name and adding to mythicname
        first = name.charAt(0);
        last = name.charAt(name.length()-1);
        mythical = last + name.substring(1, name.length()-1) + first;

        //finding middle characters in color
        first = color.charAt(0);
        last = color.charAt(color.length()-1);
        color = color.substring(1,color.length()-1);
        
        //swapping middle of "color"
        StringBuilder reversed = new StringBuilder();
        reversed.append(color);
        reversed.reverse();
        
        //adding all other stuff to mythic name and printing it
        mythical += first + reversed.substring(0) + last + "ion";
        System.out.print("Your mythical name is: " + mythical);
    }
}
