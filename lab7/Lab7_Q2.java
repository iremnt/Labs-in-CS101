/* Book Reservation, 16.04.2025, İrem Açıkgöz */

import java.util.ArrayList;

public class Lab7_Q2 {
    private static final int TOTALBOOK = 10;//total # of books in the library

    public static void reserveBook(int bookId, ArrayList<Integer> reservations){//reserve a book if it is available
        if(!reservations.contains(bookId)){
            reservations.add((Integer)bookId);
            System.out.printf("Book %d reserved successfully.\n",bookId);
        }
        else
            System.out.printf("Book %d is already reserved.\n",bookId);
    }

    public static void returnBook(int bookId, ArrayList<Integer> reservations){//return a book if it is reserved
        if(reservations.contains(bookId)){
            reservations.remove((Integer)(bookId));
            System.out.printf("Book %d returned successfully.\n",bookId);
        }
        else
            System.out.printf("Book %d was not reserved.\n", bookId);
    }

    public static void displayBooks(ArrayList<Integer> reservations){//display all books' availability
        System.out.println("\nCurrent Book Status:");
        for (int i = 0; i < TOTALBOOK; i++) {
            System.out.printf("Book %d:", (i+1));
            if(reservations.contains(i+1))
                System.out.println("Reserved");
            else
                System.out.println("Available");
        }
        System.out.println();
    }

    public static void processBatchReservations(int[] batch, ArrayList<Integer> reservations){//reserve books in order
        for (int v : batch) {
            reserveBook(v, reservations);
        }
        displayBooks(reservations);//! 
    }
    public static void main(String[] args) {

        // *sample run
        ArrayList<Integer> reservations = new ArrayList<>(); 
        
        // make reservations for some books 
        reserveBook(3, reservations); 
        reserveBook(7, reservations); 
        reserveBook(3, reservations); // Already reserved 

        // display the current status of reservations 
        displayBooks(reservations); 
        
        // return books 
        returnBook(3, reservations); 
        returnBook(5, reservations); // try with not reserved 
        
        // display the current status 
        displayBooks(reservations); 
        
        // do a batch of reservations 
        int[] batch = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10}; 
        processBatchReservations(batch, reservations); 

        // display the final status 
        displayBooks(reservations);
    }
}
