import java.util.Scanner;

// Lab 02, Q2, Manipulating Strings, Gülser İrem AÇIKGÖZ, 20.02.2025 

public class Lab02_Q2 {
    public static void main(String[] args) {
        String phoneNumber;//input
        String countryCode, cityCode, phoneCode; //outputs
        int firstDash, secondDash; //because I want to use firstDash's and secondDash's indexes more than one time I want to assign them to a variable

        //scanning input phone number
        Scanner in = new Scanner(System.in);
        System.out.print("Enter phone number: ");
        phoneNumber = in.nextLine();
        in.close();

        //make the phone number more condensed by deleting spaces
        phoneNumber = phoneNumber.replaceAll(" ", "");

        //finding country code by using "(" and ")" 
        countryCode = phoneNumber.substring(phoneNumber.indexOf("(") + 1, phoneNumber.indexOf(")"));

        //finding city code by using ")" and first dash 
        firstDash = phoneNumber.indexOf("-");
        cityCode = phoneNumber.substring(phoneNumber.indexOf(")") + 1, firstDash);

        //finding phone code by using first dash and second dash 
        secondDash = phoneNumber.indexOf("-", firstDash + 1);
        phoneCode = phoneNumber.substring(firstDash + 1, firstDash + 4) + " - " + phoneNumber.substring(secondDash + 1,secondDash + 3) + " " + phoneNumber.substring(secondDash + 3);

        //print part
        System.out.println("Country Code: " + countryCode);
        System.out.println("City\\Area Code: " + cityCode);
        System.out.println("Phone Number: " + phoneCode);
    }
}
