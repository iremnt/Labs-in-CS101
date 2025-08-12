//lab 8

import java.util.ArrayList;

public class Member {
    private String id;
    private String name;
    private ArrayList<Book> borrowedBooks = new ArrayList<>();

    // costructor
    public Member(String id, String name) {
        this.id = id;
        this.name = name;
    }
    
    // getter methods
    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public ArrayList<Book> getBorrowedBooks() {
        return borrowedBooks;
    }

    // setter methods
    public void setName(String name) {
        this.name = name;
    }

    public void setBorrowedBooks(ArrayList<Book> borrowedBooks) {
        this.borrowedBooks = borrowedBooks;
    }


}
