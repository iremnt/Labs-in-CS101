
import java.util.ArrayList;

public class TicketRev {
    private ScreeningRev screen;
    private ArrayList<SeatRev> bookedSeats = new ArrayList<>();
    private double totalPrice;

    //constructor
    public TicketRev(ScreeningRev s, ArrayList<SeatRev> sList, double totalPrice){
        screen=s;
        bookedSeats = sList;
        this.totalPrice = totalPrice;
    }

    //getters
    public ScreeningRev getScreen() {
        return screen;
    }

    public ArrayList<SeatRev> getBookedSeats() {
        return bookedSeats;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    //toString override
    public String toString(){
        String printSeats = "";
        for(SeatRev s:this.bookedSeats){
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
