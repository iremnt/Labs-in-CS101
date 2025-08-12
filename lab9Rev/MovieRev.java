public class MovieRev {
    //Attributes
    private String title;
    private String genre;
    private int duration;
    private double ticketPrice;

    //construction
    public MovieRev(String title, String genre, int duration, double ticketPrice ) {
        this.duration = duration;
        this.genre = genre;
        this.ticketPrice = ticketPrice;
        this.title = title;
    }

    //getters
    public String getTitle() {
        return title;
    }

    public String getGenre() {
        return genre;
    }

    public int getDuration() {
        return duration;
    }

    public double getTicketPrice() {
        return ticketPrice;
    }
    
    //toString override
    public String toString() {
        return "\"" + title + "\", Genre: " + genre + ", Duration:" + duration + " hours, " + ticketPrice + " dolars.";
    }
    
    //equals override
    public boolean equals(Object obj) {
        if(!(obj instanceof MovieRev))
            return false;
        MovieRev mov = (MovieRev) obj; 
        return mov.getTitle().equals(this.title);
    }

    

    


}
