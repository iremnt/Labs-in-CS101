import java.util.Scanner;

// Lab 02, Q2R, Revision Thu, 20.02.2025 

public class Lab02_Q2Revision {
    public static void main(String[] args) {
        String ID; //variables from user
        String depCode, numID; //output
        
        //scanning variables from user
        Scanner input = new Scanner(System.in);
        System.out.print("Enter your student ID: ");
        ID = input.nextLine();
        ID = ID.replaceAll(" ","");

        // assign output variables 
        depCode = ID.substring(0, ID.indexOf("-"));
        numID = ID.substring(ID.indexOf("-") + 1 , ID.length());

        //print them
        System.out.println("Department Code: " + depCode);
        System.out.println("Numeric ID: " + numID);
        System.out.println("Total Characters: " + ID.length());
       
    }
}
