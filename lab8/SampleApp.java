public class SampleApp {
    public static void main(String[] args){
        Conference conf = new Conference("TechConf 2025"); 
        Event event1 = new Event("E101", "AI Innovations", "05-06-2025"); 
        Event event2 = new Event("E102", "Blockchain Trends", "06-06-2025");
        Speaker speaker1 = new Speaker("S101", "Dr. Jane Doe", "Artificial Intelligence"); 
        Speaker speaker2 = new Speaker("S102", "Dr. Mike Lee", "Blockchain"); 
        Attendee attendee1 = new Attendee("A101", "Mark Spencer", "TechCorp"); 
        Attendee attendee2 = new Attendee("A102", "Sara Johnson", "InnovaTech"); 
        conf.addEvent(event1); conf.addEvent(event2); event1.registerSpeaker(speaker1); 
        event1.registerAttendee(attendee1); event2.registerSpeaker(speaker2); 
        event2.registerAttendee(attendee2); 
        System.out.println("Events by Dr. Jane Doe: " + conf.getEventsBySpeaker("S101").size()); 
        System.out.println("Events by Dr. Mike Lee: " + conf.getEventsBySpeaker("S102").size());
    }
}
