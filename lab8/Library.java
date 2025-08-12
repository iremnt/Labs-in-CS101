
import java.util.ArrayList;

public class Library {
    private ArrayList<Book> books = new ArrayList<>();
    private ArrayList<Member> members = new ArrayList<>();

    //getters just to see
    public ArrayList<Book> getBooks() {
        return books;
    }

    public ArrayList<Member> getMembers() {
        return members;
    }

    //add book to library
    public void addBook(Book book){
        books.add(book);
    }

    //add member to library
    public void addMember(Member member){
        members.add(member);
    }

    //a member borrow a book
    public void borrowBook(String bookId, String memberId){
        Book theBook = new Book("", "", "");
        Member theMember = new Member("", "");
        boolean valid = false;
        //find the book
        for(Book b : books){
            if(b.getId().equals(bookId)){
                theBook = b;
                valid = true;
            }
        }
        if(!valid){
            System.out.println("Error: This book is not in the library.");
        }
        else{
            if(!theBook.isIsAvailable())
                System.out.println("This book is not available.");
            else{
                //find the member
                valid = false;
                for(Member m : members){
                    if(m.getId().equals(memberId)){
                        theMember = m;
                        valid = true;
                    }
                }
                if(!valid)
                    System.out.println("Error: User is not a member of the library.");
                else{
                    //borrow the book
                    theBook.borrow();
                    theMember.getBorrowedBooks().add(theBook);//lists are mutable  

                    System.out.println("The book, " + theBook.getTitle() + " is successfully borrowed from the member, " + theMember.getName());
                }
            }
        }
    }

    //return a book
    public void returnBook(String bookId){
        Book theBook = new Book("", "", "");
        Member theMember = new Member("", "");
        boolean valid = false;

        //find the book
        for(Book b : books){
            if(b.getId().equals(bookId)){
                theBook = b;
                valid = true;
            }
        }
        if(!valid){
            System.out.println("Error: This book is not in the library.");
        }
        else{
            if(theBook.isIsAvailable())
                System.out.println("This book is not borrowed from the library.");
            else{
                //find the member
                for(Member m : members){
                    if(m.getBorrowedBooks().contains(theBook)){
                        theMember = m;
                    }
                }
                //change books availability
                theBook.returnBook();
        
                //return the book from member
                theMember.getBorrowedBooks().remove(theBook);

                System.out.println("The book, " + theBook.getTitle() + " is returned successfully form the member, " + theMember.getName());
            }
        }
    }
}
