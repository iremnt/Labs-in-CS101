
import java.util.ArrayList;

public class Screening {
    private Movie mov;
    private Auditorium au;
    private int startTime;
    private Seat[][] seats;
    private ArrayList<Ticket> soldTickets;

    //constructor
    public Screening(Movie mov, Auditorium au, int startTime) {
        this.au = au;
        this.mov = mov;
        this.startTime = startTime;
        seats = new Seat[au.getRowsNo()][au.getColumnsNo()];
        for(int i = 0; i < au.getRowsNo(); i++){
            for(int j = 0; j < au.getColumnsNo(); j++){
                seats[i][j] = new Seat(i, j);
            }
        }
        soldTickets = new ArrayList<>();
    }

    //getters
    public Movie getMov() {
        return mov;
    }

    public Auditorium getAu() {
        return au;
    }

    public int getStartTime() {
        return startTime;
    }

    public Seat[][] getSeats() {
        return seats;
    }

    public ArrayList<Ticket> getSoldTickets() {
        return soldTickets;
    }

    //get End time
    public int getEndTime(){
        return startTime + this.getMov().getDuration();
    }

    //get price
    public double getPrice(){
        return this.getMov().getTicketPrice() * this.getAu().getPriceMultiplier();
    }

    //calculate Revenue
    public double calculateRevenue(){
        double sum = 0;
        for(Ticket t :this.getSoldTickets()){
            sum += t.getTotalPrice();
        }
        return sum;
    }

    //row column --> seat
    public Seat getSeat(int row, int column){
        if( row < 0 || column < 0 )
            return null;
        if(row >= seats.length || column >= seats[0].length){
            return null;
        }
        return this.getSeats()[row][column];
    }

    //check the availability of the seat
    public boolean isSeatAvailable(int row, int column){
        if(this.getSeat(row, column) != null){
            if(!this.getSeat(row, column).isBooked())
                return true;
        }
        return false;
    }

    //buying a ticket
    public Ticket buyTicket(ArrayList<Seat> listOfSeats){
        for(Seat s:listOfSeats){
            if(!this.isSeatAvailable(s.getRow(), s.getColumn()))
                return null;
            //have to add a for loop to be sure that every seat in arraylist is available
        }
        double sum = 0;
        for(Seat s:listOfSeats){
            this.getSeat(s.getRow(), s.getColumn()).setBookingStatus(true);
            sum += this.getPrice();
        }
        soldTickets.add(new Ticket(this, listOfSeats, sum));
        return soldTickets.get(soldTickets.size()-1);
    }

    public Ticket buyTicketForRange(int row, int startColumn, int endColumn){
        ArrayList<Seat> rangeOfSeats = new ArrayList<>();
        for(int i = startColumn; i <= endColumn; i++){
            rangeOfSeats.add(this.getSeat(row - 1, i - 1));
        }
        return this.buyTicket(rangeOfSeats);
    }

    //get a string representation of seats
    public String getSeatingLayout(){
        String a = "\n";
        String b = " ";
        for(int i = 0; i < seats.length; i++){
            a += i + 1;
            for(int j = 0; j < seats[0].length; j++){
                b += j + 1;
                if(!isSeatAvailable(i, j))
                    a += "#";
                else
                    a += "_";
            }
            a += "\n";
        }
        return b.substring(0, seats[0].length + 1) + a;
    }

    //overrided toString
    public String toString(){
        return this.getMov().getTitle() + " is playing in the " + this.getAu().getName() + " auditorium from " + this.getStartTime() + ":00 to " + this.getEndTime() + ":00";
    }

    //overrided equals

    public boolean equals(Object obj){
        if(!(obj instanceof Screening))
            return false;
        Screening s = (Screening) obj;
        return (s.getMov().equals(this.getMov())) && (s.getAu().equals(this.getAu())) && (s.getStartTime() == this.getStartTime());
    }
}
