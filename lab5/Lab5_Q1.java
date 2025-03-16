import java.util.Scanner;

// Lab 05, Q1, Drawing A Bar Chart, Gülser İrem AÇIKGÖZ, 20.03.2025 

public class Lab5_Q1 {
    public static void main(String[] args){
        int userNumber = 0, maxNumber = -1, digit;
        String userString, spaces = "", outputString = "";
        boolean valid = false;
        
        while(!valid){
            Scanner input = new Scanner(System.in);
            System.out.print("Please enter the chart data as string: ");
            if (input.hasNextInt()){
                userNumber = input.nextInt();
                valid = true;
            }
            else{
                System.out.println("Invalid input. Please only enter digits(0-9).");
            }
        }

        userString = userNumber + "";
        for (int i = 0; i < userString.length(); i++){
            digit = Integer.parseInt(userString.charAt(i) + "");
            if (digit == 0){
                if (i == 0)
                    outputString = "0|___";
                else{
                outputString += "___";
                outputString = outputString.replaceAll("\n", "   \n");
                }
            }
            else{
                if (i == 0){
                    maxNumber = digit;
                    for (int j = digit; j > 0; j--){
                        outputString += j + "| * \n";
                    }
                    outputString += "0|";
                }
                else{
                    if (digit > maxNumber){
                        outputString = outputString.replaceAll("\n", " * \n");
                        for (int k = 1; k <= i; k++){
                            spaces += "   ";
                        }
                        for (int j = maxNumber + 1; j <= digit; j++){
                            outputString = j + "|" + spaces + " * \n" + outputString;
                        }
                        spaces = "";
                        maxNumber = digit;
                    }
                    else{
                        outputString = (outputString.substring(0, outputString.indexOf(digit + ""))).replaceAll("\n", "   \n") + 
                        (outputString.substring(outputString.indexOf(digit + ""))).replaceAll("\n", " * \n");
                    }
                }
                outputString += "___";
            }
        }
        System.out.println(outputString);
    }
}
