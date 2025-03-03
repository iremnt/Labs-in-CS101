import java.util.Scanner;

// Lab 03, Q3, Movie overview and rating system, Gülser İrem AÇIKGÖZ, 27.02.2025 

public class Lab03_Q3 {
    public static void main(String[] args) {
        String admin = "Violet#Cupcake";//admin username and password
        String users = "Jinx#Jinx,Jayce#Jayce,Caitlyn#Caitlyn"; // users name and password
        String movieNames = "Joker 2,Gladiator 2,Fear,Inception,Cape Fear";
        String reviews = "Joker 2 (Jinx): Waste of time\nJoker 2 (Jayce): It is trash. Don't watch\nJoker 2 (Caitlyn): I like Lady Gaga\nGladiator 2 ( Jayce ): I really luved it *_*\n";
        String userName, password, addDeleteMovieReview; //inputs and also addDeleteMovieReview is for add movies,deleting movies,add reviews
        int selected;

        Scanner input = new Scanner(System.in);
        System.out.print("Enter your username: ");
        userName = input.nextLine();
        System.out.print("Enter your password: ");
        password = input.nextLine();

        //admin part
        if (admin.equals(userName + "#" + password)){
            System.out.print("Welcome! Your role is Admin.\n1- Add Movie\n2- Delete Movie\n3- Logout\nSelect an operation: ");
            selected = input.nextInt();
            addDeleteMovieReview = input.nextLine();// to not end the programme

            if (selected == 1){
                System.out.print("Enter movie name to add: ");
                addDeleteMovieReview = input.nextLine();
                if (movieNames.contains(addDeleteMovieReview + ",") || movieNames.contains("," + addDeleteMovieReview))//check wheter the movie is in the list
                    System.out.println("This movie is already on your list");
                else{
                    movieNames += "," + addDeleteMovieReview;//if not then add
                    System.err.println("Movie added!\n"+ movieNames);
                }
            }
            else if (selected == 2){
                System.out.print("Enter movie name to delete: ");
                addDeleteMovieReview = input.nextLine();

                if (movieNames.contains(","+ addDeleteMovieReview + ",")){//check movvie is in middle
                    movieNames = movieNames.replace("," + addDeleteMovieReview, "");
                    System.out.println("Movie deleted!\n" + movieNames);
                }
                else if (movieNames.indexOf(addDeleteMovieReview) == 0 && movieNames.contains(addDeleteMovieReview + ",")){//check movie is at the beginning
                    movieNames = movieNames.substring(addDeleteMovieReview.length() + 1);
                    System.out.println("Movie deleted!\n" + movieNames);
                }
                else if (movieNames.indexOf(addDeleteMovieReview) + addDeleteMovieReview.length() == movieNames.length() &&
                movieNames.contains("," + addDeleteMovieReview)){//check movie is at the end
                    movieNames = movieNames.substring(0,movieNames.indexOf(addDeleteMovieReview) - 1);
                    System.out.println("Movie deleted!\n" + movieNames);
                }
                else 
                    System.out.println("The movie is not on the list");                
            }
            else if (selected == 3){
                System.out.println("Logged out successfully");
            }//maybe adding there is no selection in else case
        }
        //users part
        else if(users.contains(userName + "#" + password)){
            System.out.print("Welcome! Your role is User.\n1 - List Movies and Reviews\n2 - Submit a Review\n3 - Logout\nSelect an operation: ");
            selected = input.nextInt();
            addDeleteMovieReview = input.nextLine();// to not end the programme
            if (selected == 1){
                System.out.print(movieNames + "\n" + reviews);
            }
            else if (selected == 2){
                System.out.print("Enter movie name to review: ");
                addDeleteMovieReview = input.nextLine();
                if (movieNames.contains("," + addDeleteMovieReview + ",") || //check if movie is in the middle
                movieNames.indexOf(addDeleteMovieReview) == 0 && movieNames.contains(addDeleteMovieReview + ",") || //check if movie is at the beginning
                movieNames.indexOf(addDeleteMovieReview) + addDeleteMovieReview.length() == movieNames.length() && movieNames.contains("," + addDeleteMovieReview)){//check movie is at the end
    
                    reviews += addDeleteMovieReview + " (" + userName + "): ";
                    System.out.print("Enter review: ");
                    addDeleteMovieReview = input.nextLine();
                    reviews += addDeleteMovieReview + "\n";//add review
                    System.out.print(reviews);
                }
                else //movie is not in the list
                    System.out.println("Movie not found");  
            }
            else if (selected == 3){
                System.out.println("Logged out successfully");
            }//maybe adding there is no selection for else case
        }
        else //non user nor admin
            System.out.println("You shall not pass!");
        input.close();
    }
}
