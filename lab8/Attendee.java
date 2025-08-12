public class Attendee {
    private String id;
    private String name;
    private String organization;

    //constructor(s)
    public Attendee(String id, String name) {
        this.id = id;
        this.name = name;
    }
    public Attendee(String id, String name, String organization) {
        this.id = id;
        this.name = name;
        this.organization = organization;
    }//! i decided to add another constructor bc of sample run

    //getters
    public String getId() {
        return id;
    }
    public String getName() {
        return name;
    }
    public String getOrganization() {
        return organization;
    }

    // setters
    public void setName(String name) {
        this.name = name;
    }
    public void setOrganization(String organization) {
        this.organization = organization;
    }

    
}
