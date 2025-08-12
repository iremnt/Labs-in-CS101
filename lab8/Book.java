// lab8

public class Book {
    // Instance Data Members
    private String id;
    private String title;
    private String author;
    private boolean isAvailable;

    // Constructor
    public Book(String id, String title, String author){
        this.id = id;
        this.title = title;
        this.author = author;
        this.isAvailable = true;
    }
    // Accessor methods
    public String getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public boolean isIsAvailable() {
        return isAvailable;
    }

    // Setter methods
    public void changeTitle(String newTitle) {
        title = newTitle;
    }

    /* public void setAuthor(String author) {
        this.author = author;
    } */

    public void borrow() {
        isAvailable = false;
    }

    public void returnBook() {
        isAvailable = true;
    }



}
