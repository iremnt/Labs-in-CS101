import java.util.ArrayList;
public class Conference {
    private String name;
    private ArrayList<Event> events = new ArrayList<>();

    //! constructor bc of sample run
    public Conference(String name){
        this.name = name;
    }

    public void addEvent(Event event){
        events.add(event);
    }
    public ArrayList<Event> getEventsBySpeaker(String speakerId){
        ArrayList<Event> speakersEvents = new ArrayList<>();
        for ( Event e : events){
            for( Speaker s : e.speakers){
                if(s.getId().equals(speakerId)){
                    speakersEvents.add(e);
                }
            }
        }
        return speakersEvents;
    }
}
