import java.util.Scanner;

// Lab 03, Q1, A Distance-Based Game Simulation, Gülser İrem AÇIKGÖZ, 27.02.2025 

public class Lab03_Q1 {
    public static void main(String[] args) {
        String aliceCoordinates, bobCoordinates;
        int aliceX, aliceY, bobX, bobY; //inputs
        double distance; //output

        Scanner input = new Scanner(System.in);

        //getting alice's coordinates
        System.out.print("Alice's coordinates: ");
        aliceCoordinates = input.nextLine();
        aliceCoordinates = aliceCoordinates.replaceAll(" ", "");
        aliceX = Integer.parseInt(aliceCoordinates.substring(0, aliceCoordinates.indexOf(",")));
        aliceY = Integer.parseInt(aliceCoordinates.substring(aliceCoordinates.indexOf(",") + 1));

        //getting bob's coordinates
        System.out.print("Bob's coordinates: ");
        bobCoordinates = input.nextLine();
        bobCoordinates = bobCoordinates.replaceAll(" ", "");
        bobX = Integer.parseInt(bobCoordinates.substring(0, bobCoordinates.indexOf(",")));
        bobY = Integer.parseInt(bobCoordinates.substring(bobCoordinates.indexOf(",") + 1));

        input.close();

        //calculating and printing distance
        distance = Math.sqrt(Math.pow((aliceX - bobX), 2) + Math.pow((aliceY-bobY), 2));
        System.out.printf("Distance: %.2f\n", distance);

        //calculating wheter they can find each other 
        if (distance <= 5.0)
            System.out.println("Alice and Bob have found each other :D");
        else 
            System.out.println("Alice and Bob have not found each other :(");
    }
}
