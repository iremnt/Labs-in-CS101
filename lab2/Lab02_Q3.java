import java.util.Scanner;

// Lab 02, Q2, Mythical Names, Gülser İrem AÇIKGÖZ, 20.02.2025 

public class Lab02_Q3 {
    public static void main(String[] args) {
        String Name, Color; //variables from user
        String Mythical; //output

        char first, last;

        //scanning variables from user
        Scanner input = new Scanner(System.in);
        System.out.print("Enter your name: ");
        Name = input.next();
        System.out.print("Enter your favorite color: ");
        Color = input.next();
        input.close();

        //swapping first and last letters of name and adding to mythicname
        first = Name.charAt(0);
        last = Name.charAt(Name.length()-1);
        Mythical = last + Name.substring(1, Name.length()-1) + first;

        //finding middle characters in color
        first = Color.charAt(0);
        last = Color.charAt(Color.length()-1);
        Color = Color.substring(1,Color.length()-1);
        
        //swapping middle of "color"
        StringBuilder Reversed = new StringBuilder();
        Reversed.append(Color);
        Reversed.reverse();
        

        //adding all other stuff to mythic name and printing it
        Mythical += first + Reversed.substring(0) + last + "ion";
        System.out.print("Your mythical name is: " + Mythical);

        
    }
}
