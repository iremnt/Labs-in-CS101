public class SeatRev {
    private int row;
    private int column;
    private boolean bookingStatus;

    //constructor
    public SeatRev(int row, int column) {
        this.column = column;
        this.row = row;
        this.bookingStatus = false;
    }

    //getters
    public int getRow() {
        return row;
    }

    public int getColumn() {
        return column;
    }

    public boolean isBooked() {
        return bookingStatus;
    }

    //setters
    public void setBookingStatus(boolean bookingStatus) {
        this.bookingStatus = bookingStatus;
    }

    //toString override
    public String toString(){
        return "(" + (row + 1) + ", " + (column + 1) + ") ";
    }

    //equals override
    public boolean equals(Object obj){
        if(!(obj instanceof SeatRev))
            return false;
        SeatRev s = (SeatRev) obj;
        return s.getRow() == this.row && s.getColumn() == this.column;
    }
}
