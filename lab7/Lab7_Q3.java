
/* Online Shopping Cart System, 16.04.2025, İrem Açıkgöz */

import java.util.ArrayList;
import java.util.Scanner;

public class Lab7_Q3 {
    public static ArrayList<String> items = new ArrayList<>(5);
    public static int[] prices = {1200, 800, 100, 50, 70};

    public static int[] frequency = new int[5];

    public static double totalCost = 0;

    //1) add Item to cart
    public static void addItem(ArrayList<String> cart){
        System.out.print("Enter the item to add: ");
        Scanner in = new Scanner(System.in);
        String item = in.nextLine();

        if(!items.contains(item))
            System.out.println("Error: There is no such item.");
        else{
            if(!cart.contains(item))
                cart.add(item);
            
            System.out.printf("%s added to the cart.\n", item);
            frequency[items.indexOf(item)] += 1;
            totalCost += prices[items.indexOf(item)];
        }
    }

    //2) remove Item from cart
    public static void removeItem(ArrayList<String> cart){
        System.out.print("Enter the item to remove: ");
        Scanner in = new Scanner(System.in);
        String item = in.nextLine();

        if(!cart.contains(item))
            System.out.printf("Error: %s is not in the cart.", item);
        else{
            cart.remove(item);
            System.out.printf("%s removed from the cart.\n", item);
            totalCost -= prices[items.indexOf(item)];
        }
    }

    //3) display
    public static void display(ArrayList<String> cart){
        System.out.println("Your Cart: ");
        for (int i = 0; i < cart.size(); i++) {
            System.out.printf("- %s: %d\n", cart.get(i), frequency[items.indexOf(cart.get(i))]);
        }
        System.out.printf("Total Cost: $%.1f\n", totalCost);
    }

    // 4) most added Item
    public static void mostAdded(){
        int max = -1;
        String maxItems = "";
        for (int i = 0; i < frequency.length; i++) {
            if(frequency[i] > max){
                max = frequency[i];
                maxItems = "- " + items.get(i) + "\n";
            }
            else if(frequency[i] == max)
                maxItems += "- " + items.get(i) + "\n";
        }
        System.out.printf("Most frequently added item(s):\n%s",maxItems);
    }

    // 5) Apply a discount and calculate the total cost:
    public static void discount(ArrayList<String> cart){
        System.out.printf("Total Cost before discount: %.1f\n", totalCost);
        totalCost = totalCost*90/100;
        System.out.printf("Total Cost after 10%% discount: %.1f\n", totalCost);
    }
    // 6 is just exit so its in the main

    //just for me i want to make a function that initially arranges the items that market have
    public static void marketItems(){
        items.add("Laptop");
        items.add("Phone");
        items.add("Headset");
        items.add("Mouse");
        items.add("Keyboard");
    }
    public static void main(String[] args) {

        marketItems();

        ArrayList<String> cart = new ArrayList<>();
        
        Scanner in = new Scanner(System.in);
        System.out.println("Welcome to the Online Shopping Cart System!\n" +
                            "1. Add an item to the cart\n" +
                            "2. Remove an item from the cart\n"+
                            "3. View the cart\n"+
                            "4. Find the most frequently added item\n"+
                            "5. Apply discount and calculate total cost\n"+
                            "6. Exit\n");
        System.out.print("Enter your choice: ");
        int selected = in.nextInt();
        while(selected!=6){
            if(selected == 1){
                addItem(cart);
            }
            else if(selected == 2){
                removeItem(cart);
            }
            else if(selected == 3){
                display(cart);
            }
            else if(selected == 4){
                mostAdded();
            }
            else if(selected == 5){
                discount(cart);
            }
            System.out.println("\nWelcome to the Online Shopping Cart System!\n" +
                                "1. Add an item to the cart\n" +
                                "2. Remove an item from the cart\n"+
                                "3. View the cart\n"+
                                "4. Find the most frequently added item\n"+
                                "5. Apply discount and calculate total cost\n"+
                                "6. Exit\n");
            System.out.print("Enter your choice: ");
            selected = in.nextInt();            
        }
        System.out.println("Exiting the program. Goodbye!");
    }
}
