public class Auditorium {
    //attributes
    private String name;
    private int rowsNo;
    private int columnsNo;
    private double baseTicketPrice;//! not used?
    private double priceMultiplier;

    //constructor
    public Auditorium(String name, int rowsNo, int columns, double priceMultiplier) {
        this.columnsNo = columns;
        this.name = name;
        this.priceMultiplier = priceMultiplier;
        this.rowsNo = rowsNo;
    }

    //getters
    public String getName() {
        return name;
    }

    public int getRowsNo() {
        return rowsNo;
    }

    public int getColumnsNo() {
        return columnsNo;
    }

    public double getBaseTicketPrice() {
        return baseTicketPrice;
    }

    public double getPriceMultiplier() {
        return priceMultiplier;
    }

    //toString override
    public String toString(){
        return name + ", " + (rowsNo*columnsNo) + " seats.";
    }

    //equals override
    public boolean equals(Object obj){
        if (!(obj instanceof Auditorium))
            return false;
        Auditorium au = (Auditorium) obj;
        return au.getName().equals(this.name);
    }

    
}
