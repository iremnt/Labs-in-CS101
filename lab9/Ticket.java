
import java.util.ArrayList;

public class Ticket {
    private Screening screen;
    private ArrayList<Seat> bookedSeats = new ArrayList<>();
    private double totalPrice;

    //constructor
    public Ticket(Screening s, ArrayList<Seat> sList, double totalPrice){
        screen=s;
        bookedSeats = sList;
        this.totalPrice = totalPrice;
    }

    //getters
    public Screening getScreen() {
        return screen;
    }

    public ArrayList<Seat> getBookedSeats() {
        return bookedSeats;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    //toString override
    public String toString(){
        String printSeats = "";
        for(Seat s:this.bookedSeats){
            printSeats += s + " ";
        }
        totalPrice = Math.round(totalPrice * 100) / 100.0;
        return "\"" + this.screen.getMov().getTitle() + "\", Genre: " + this.screen.getMov().getGenre() + 
                ", Duration:" + this.screen.getMov().getDuration() + " hours" + 
                "\nAuditorium: " + this.screen.getAu().toString() + 
                "\nStart time: " + this.screen.getStartTime() +
                "\nSeats: " + printSeats + 
                "\nTotal Price: $" + totalPrice;
    }
}
