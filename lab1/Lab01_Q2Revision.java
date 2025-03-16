// Lab 01, Q2 revision, Gülser İrem AÇIKGÖZ, 13.02.2025 

public class Lab01_Q2Revision{
    public static void main(String[] args) {
        int a, b, c;// given values
        a = 2;
        b = -7;
        c = 3;

        double firstRoot, secondRoot;//we want o find these

        // given formula
        firstRoot = (- b + Math.sqrt((Math.pow(b,2) - 4 * a * c))) / (2 * a);
        secondRoot = (- b - Math.sqrt((Math.pow(b,2) - 4 * a * c))) / (2 * a);

        System.out.println("Roots of these equation are " + firstRoot + " and " + secondRoot);
    }
}