import java.util.Scanner;

// Lab 02, Q1, Calculations and Formatting, Gülser İrem AÇIKGÖZ, 20.02.2025 

public class Lab02_Q1 {
    public static void main(String[] args) {
        final double PAL = 1.4; //constant value of physical activity level
        final double percentCarbs = 0.45; 
        final double percentProtein = 0.25;
        final double percentFat = 0.3;

        int weight, height, age; //variables required for calories
        double bmr, calExpenditure; //calculating with given variables(above) also bmr is Basal metabolic rate
        double gramCarbs, gramProtein, gramFat; //outputs

        //input data from user
        Scanner in = new Scanner(System.in);
        System.out.println("Enter your weight(kg), height(cm) and age: ");
        weight = in.nextInt();
        height = in.nextInt();
        age = in.nextInt();
        in.close();

        //calculating burned calories with given variables
        bmr = 10 * weight + 6.25 * height - 5 * age - 161;
        calExpenditure = bmr * PAL;

        //calculating weights for each macro
        gramCarbs = calExpenditure * percentCarbs / 4;
        gramProtein = calExpenditure * percentProtein / 4;
        gramFat = calExpenditure * percentFat / 9;


        /* System.out.println("Calories Required: " + calExpenditure );
        System.out.println("GRAMS PROTEIN: " + gramProtein );
        System.out.println("GRAMS FAT: " + gramFat );
        System.out.println("GRAMS CARBS " + gramCarbs ); */

        //but i chose to print with printf in order to change the number of decimals after "." 
        System.out.printf("%30s %10.2f\n%30s %10.2f\n%30s %10.2f\n%30s %10.2f\n",
        "Calories Required:",calExpenditure, "GRAMS PROTEIN:", gramProtein, "GRAMS FAT:", gramFat, "GRAMS CARBS:", gramCarbs);
    }
}
