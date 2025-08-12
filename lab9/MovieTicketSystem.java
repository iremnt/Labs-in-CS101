import java.util.ArrayList;
import java.util.Scanner;

public class MovieTicketSystem {
    //shortcut for print selection list
    public static void printlist(){
        System.out.print("\n1. List Movies \n" +
                                "2. List Screenings \n" +
                                "3. Add Screening \n" +
                                "4. Buy Ticket \n" +
                                "5. Calculate Revenue \n" +
                                "6. Exit \n" +
                                "Enter your option: ");
    }
    //shortcut for print error
    public static void printerror(){
        System.out.println("Invalid option. Please try again.\n");
    }
   
    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);

        // Initial mock data
        // Add movies
        ArrayList<Movie> movies = new ArrayList<>();
        movies.add(new Movie("Toyz Goin' Wild", "Family", 1, 1.23));
        movies.add(new Movie("Car's Life", "Family", 2, 1.00));
        movies.add(new Movie("The Amazing Bulk", "Action", 1, 2.10));
        movies.add(new Movie("The Rise of Black Bat", "Action", 2, 1.90));

        // Add auditoriums
        ArrayList<Auditorium> auditoriums = new ArrayList<>();
        auditoriums.add(new Auditorium("Screen 1", 5, 4, 1.0));
        auditoriums.add(new Auditorium("Screen 2", 5, 4, 1.0));
        auditoriums.add(new Auditorium("IMAX", 3, 5, 1.5));

        // Add initial screenings
        ArrayList<Screening> screenings = new ArrayList<>();
        screenings.add(new Screening(movies.get(1), auditoriums.get(0), 1));
        screenings.add(new Screening(movies.get(2), auditoriums.get(0), 0));
        screenings.add(new Screening(movies.get(2), auditoriums.get(0), 4));
        screenings.add(new Screening(movies.get(0), auditoriums.get(1), 0));
        screenings.add(new Screening(movies.get(2), auditoriums.get(2), 4));
        screenings.add(new Screening(movies.get(3), auditoriums.get(2), 6));

        // Buy some tickets
        screenings.get(0).buyTicketForRange(2, 2, 4);
        screenings.get(1).buyTicketForRange(2, 1, 2);
        screenings.get(2).buyTicketForRange(1, 1, 4);
        screenings.get(2).buyTicketForRange(3, 2, 4);
        screenings.get(3).buyTicketForRange(5, 1, 3);
        screenings.get(3).buyTicketForRange(3, 3, 4);
        screenings.get(5).buyTicketForRange(3, 1, 5);

        // You can implement the functionalities described in the lab document here.
        // Feel free to add additional private static helper methods as needed.

        //selection
        boolean valid = false;
        int selected = 0;
        while(!valid){
            printlist();
            if(!scanner.hasNextInt()){
                printerror();
                scanner.nextLine();
            }
            else{
                selected = scanner.nextInt();
                if(selected > 6 || selected < 1){
                    printerror();
                }
                else
                    valid = true;
            }
        }
        
        while(selected != 6){
            //List movies
            if(selected == 1){
                System.out.println("Available movies:");
                for(Movie m:movies){
                System.out.println("\"" + m.getTitle() + "\", Genre: " + m.getGenre() + 
                                    ", Duration: " + m.getDuration() + " hours");
                }   
            }
            //List Screenings
            else if(selected == 2){
                for(Screening s:screenings){
                    System.out.println(s + "");
                }
            }
            //Add Screening
            else if(selected == 3){
                valid = false;
                //select movie
                while(!valid){
                    System.out.println("Select a movie:");
                    for(int i = 0; i < movies.size(); i++){
                        System.out.println((i + 1) + ": \"" + movies.get(i).getTitle() + "\", Genre: " + movies.get(i).getGenre() + 
                                            ", Duration:" + movies.get(i).getDuration() + " hours");
                    }
                    System.out.print("Enter: ");

                    if(!scanner.hasNextInt()){
                        printerror();
                        scanner.nextLine();
                    }
                    else{
                        selected = scanner.nextInt();
                        if(selected > movies.size() || selected < 1){
                            printerror();
                        }
                        else
                            valid = true;
                    }
                }
                int selectedMovie = selected - 1;

                //select auditorium
                valid = false;
                while(!valid){
                    System.out.println("Select an auditorium:");
                    for(int i = 0; i < auditoriums.size(); i++){
                        System.out.println((i+1) + ": Auditorium: " + auditoriums.get(i));
                    }
                    System.out.print("Enter: ");

                    if(!scanner.hasNextInt()){
                        printerror();
                        scanner.nextLine();
                    }
                    else{
                        selected = scanner.nextInt();
                        if(selected > movies.size() || selected < 1){
                            printerror();
                        }
                        else
                            valid = true;
                    }
                }
                int selectedAu = selected - 1;

                //select a start time
                ArrayList<Integer> times = new ArrayList<>();
                valid = false;
                while(!valid){
                    for(Screening s:screenings){
                        if(s.getAu().equals(auditoriums.get(selectedAu))){
                            System.out.println(s + "");
                            times.add(s.getStartTime());
                            times.add(s.getEndTime());
                        }
                    }
                    System.out.print("Enter a start time: ");
                
                    if(!scanner.hasNextInt()){
                        printerror();
                        scanner.nextLine();
                    }
                    else{
                        selected = scanner.nextInt();
                        valid = true;
                        for(int i = 0; i < times.size(); i++){
                            if((selected >= times.get(i) && selected < times.get(i+1)) || 
                                ( (selected + movies.get(selectedMovie).getDuration()) > times.get(i) && (selected + movies.get(selectedMovie).getDuration()) <= times.get(i+1) ) ||
                                (selected <= times.get(i) && (selected + movies.get(selectedMovie).getDuration()) >= times.get(i+1) ))
                                valid = false;
                            i++;
                        }
                        if(!valid)
                            System.out.println("The auditorium is not available at the given time.");
                        else{
                            System.out.println("Screening added: " + movies.get(selectedMovie).getTitle() + " is playing in the " 
                                                + auditoriums.get(selectedAu).getName() + " from " + selected + ":00 to " + 
                                                (selected + movies.get(selectedMovie).getDuration()) + ":00");
                            screenings.add(new Screening(movies.get(selectedMovie), auditoriums.get(selectedAu), selected));
                        }
                        valid = true;
                    }
                }

            }
            //buy ticket
            else if(selected == 4){
                
                //select movie
                valid = false;
                while(!valid){
                    System.out.println("Select a movie:");
                    for(int i = 0; i < movies.size(); i++){
                        System.out.println((i + 1) + ": \"" + movies.get(i).getTitle() + "\", Genre: " + movies.get(i).getGenre() + 
                                            ", Duration:" + movies.get(i).getDuration() + " hours");
                    }
                    System.out.print("Enter: ");

                    if(!scanner.hasNextInt()){
                        printerror();
                        scanner.nextLine();
                    }
                    else{
                        selected = scanner.nextInt();
                        if(selected > movies.size() || selected < 1){
                            printerror();
                        }
                        else
                            valid = true;
                    }
                }
                int selectedMovie = selected - 1;

                //select a screening
                valid = false;
                int selectedS;
                ArrayList <Screening> availableS = new ArrayList<>();
                while(!valid){
                    System.out.println("select a screening for '" + movies.get(selectedMovie).getTitle() + "':");
                    int i = 1;
                    for(Screening s:screenings){
                        if(s.getMov().equals(movies.get(selectedMovie))){
                            System.out.println(i + ": " + s);
                            i++;
                            availableS.add(s);
                        }
                    }
                    System.out.print("Enter: ");
                    if(!scanner.hasNextInt()){
                        printerror();
                        scanner.nextLine();
                    }
                    else{
                        selected = scanner.nextInt();
                        if(selected > i || selected < 1){
                            printerror();
                        }
                        else
                            valid = true;
                    }
                }
                selectedS = selected - 1;

                //print layout
                System.out.println("Seating layout for "+ availableS.get(selectedS) + ":");
                System.out.println(availableS.get(selectedS).getSeatingLayout());
                
                //select seat(s)
                valid = false;
                while(!valid){
                    System.out.print("Select a row: ");
                    if(!scanner.hasNextInt()){
                        printerror();
                        scanner.nextLine();
                    }
                    else{
                        selected = scanner.nextInt();
                        if(selected > availableS.get(selectedS).getSeats().length || selected < 1){
                            printerror();
                        }
                        else
                            valid = true;
                    }
                }
                int row = selected;

                valid = false;
                String range;
                int from = 0, to = 0;
                while(!valid){
                    System.out.print("Select a column or range (e.g., 3 or 2-4): ");
                    if(!scanner.hasNextInt()){
                        scanner.nextLine();
                        range = scanner.nextLine();
                        if(!range.contains("-"))
                            printerror();
                        else{
                            from = Integer.valueOf(range.substring(0, range.indexOf("-")));
                            to = Integer.valueOf(range.substring(range.indexOf("-") + 1));
                            if(from > availableS.get(selectedS).getSeats()[0].length || from < 1)
                                printerror();
                            else if(to > availableS.get(selectedS).getSeats()[0].length || to < 1)
                                printerror();
                            else{
                                valid = true;
                            }
                        }
                    }
                    else{
                        selected = scanner.nextInt();
                        if(selected > availableS.get(selectedS).getSeats()[0].length || selected < 1){
                            printerror();
                        }
                        else{
                            valid = true;
                            from = selected;
                            to = selected;
                        }
                    }
                }
                //print ticket
                if(availableS.get(selectedS).buyTicketForRange(row, from, to) == null){
                    System.out.println("Ticket purchase failed: one or more selected seats are unavailable.");
                }
                else{
                    System.out.println("Ticket purchased. Ticket for " + availableS.get(selectedS).getSoldTickets().get(availableS.get(selectedS).getSoldTickets().size() - 1));
                    
                    //print layout
                    System.out.println("Seating layout for " + availableS.get(selectedS));
                    System.out.println(availableS.get(selectedS).getSeatingLayout() + "\n");
                }

            }
            //Calculate revenue
            else if(selected == 5){
                double totalRevenue = 0;
                for(Screening s:screenings){
                    totalRevenue += s.calculateRevenue();
                }
                System.out.printf("Total revenue for today: $%.2f\n", totalRevenue);
            }

            //selection
            valid = false;
            while(!valid){
                printlist();
                if(!scanner.hasNextInt()){
                    printerror();
                    scanner.nextLine();
                }
                else{
                    selected = scanner.nextInt();
                    if(selected > 6 || selected < 1){
                        printerror();
                    }
                    else
                        valid = true;
                }
            }
        }
        System.out.println("Exiting...");
    }
}
