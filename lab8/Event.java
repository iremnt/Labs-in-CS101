
import java.util.ArrayList;

public class Event {
    private String id;
    private String title;
    private String date;
    public ArrayList<Speaker> speakers = new ArrayList<>();
    private ArrayList<Attendee> attendees = new ArrayList<>();

    //constructor
    public Event(String id, String title, String date) {
        this.id = id;
        this.title = title;
        this.date = date;
    }
    
    public void registerSpeaker(Speaker speaker){
        speakers.add(speaker);
    }
    public void registerAttendee(Attendee attendee){
        attendees.add(attendee);
    }
}
