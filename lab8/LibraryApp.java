import java.util.Scanner;

public class LibraryApp {
    public static void main(String[] args) {
        Library library = new Library();

        Scanner in = new Scanner(System.in);
        do {
            System.out.print("Library Management System" 
            + "\n-------------------------" 
            + "\n1. Add a new book"
            + "\n2. Register a new member"
            + "\n3. Borrow a book"
            + "\n4. Return a book" 
            + "\n5. View borrowed books of a member" 
            + "\n6. Exit Enter your choice: ");

        } while (!in.hasNextInt());
        int choice = in.nextInt();

        while ( choice != 6){
            in.nextLine();
            if(choice == 1){
                System.out.print("Enter book id to add: ");
                String bookId = in.nextLine(); 
                System.out.print("Enter book title: ");
                String title = in.nextLine();
                System.out.print("Enter book author: ");
                String author = in.nextLine();

                Book addBook = new Book(bookId, title, author);
                library.addBook(addBook);
            }
            else if(choice == 2){
                System.out.print("Enter member id to add: ");
                String memId = in.nextLine(); 
                System.out.print("Enter name of the member: ");
                String name = in.nextLine();

                Member addMem = new Member(memId, name);
                library.addMember(addMem);
            }
            else if(choice == 3){
                System.out.print("Enter book id to borrow: ");
                String bookId = in.nextLine();
                System.out.print("Enter member id: ");
                String memberId = in.nextLine();

                library.borrowBook(bookId, memberId);
            }
            else if(choice == 4){
                System.out.print("Enter book id to return: ");
                String bookId = in.nextLine();

                library.returnBook(bookId);
            }
            else if(choice == 5){
                System.out.print("Enter member id: ");
                String memberId = in.nextLine();
                boolean valid = false;

                for( Member m : library.getMembers()){
                    if(m.getId().equals(memberId)){
                        valid = true;
                        System.out.println("Borrowed books by member " + m.getName());
                        for(Book b : m.getBorrowedBooks()){
                            System.out.println("- " + b.getTitle());
                        }
                    }
                }
                if(!valid)
                    System.out.println("You are not a member");
            }


            do {
                System.out.print("\nLibrary Management System" 
                + "\n-------------------------" 
                + "\n1. Add a new book"
                + "\n2. Register a new member"
                + "\n3. Borrow a book"
                + "\n4. Return a book" 
                + "\n5. View borrowed books of a member" 
                + "\n6. Exit Enter your choice: ");
            } while (!in.hasNextInt());
            choice = in.nextInt();
        }
    }
}
