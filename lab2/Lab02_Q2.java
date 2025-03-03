import java.util.Scanner;

// Lab 02, Q2, Manipulating Strings, Gülser İrem AÇIKGÖZ, 20.02.2025 

public class Lab02_Q2 {
    public static void main(String[] args) {
        String PhoneNumber;//input
        String countryCode, cityCode, phoneCode; //outputs
        int firstDash, secondDash; //because I want to use firstDash's and secondDash's indexes more than one time I want to assign them to a variable

        //scanning input phone number
        Scanner in = new Scanner(System.in);
        System.out.print("Enter phone number: ");
        PhoneNumber = in.nextLine();
        in.close();

        //make the phone number more condensed by deleting spaces
        PhoneNumber = PhoneNumber.replaceAll(" ", "");

        //finding country code by using "(" and ")" 
        countryCode = PhoneNumber.substring(PhoneNumber.indexOf("(") + 1, PhoneNumber.indexOf(")"));

        //finding city code by using ")" and first dash 
        firstDash = PhoneNumber.indexOf("-");
        cityCode = PhoneNumber.substring(PhoneNumber.indexOf(")") + 1, firstDash);

        //finding phone code by using first dash and second dash 
        secondDash = PhoneNumber.indexOf("-",firstDash+1);
        phoneCode = PhoneNumber.substring(firstDash+1, firstDash+4) + " - " + PhoneNumber.substring(secondDash+1,secondDash+3) + " " + PhoneNumber.substring(secondDash+3, PhoneNumber.length());

        //print part
        System.out.println("Country Code: " + countryCode);
        System.out.println("City\\Area Code: " + cityCode);
        System.out.println("Phone Number: " + phoneCode);
    }
}
