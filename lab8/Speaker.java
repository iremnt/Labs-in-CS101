public class Speaker {
    private String id;
    private String name;
    private String expertise;

    //constructor(s)
    public Speaker(String id, String name) {
        this.id = id;
        this.name = name;
    }
    public Speaker(String id, String name, String expertise) {
        this.id = id;
        this.name = name;
        this.expertise = expertise;
    }//! i decided to add another constructor bc of sample run

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getExpertise() {
        return expertise;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setExpertise(String expertise) {
        this.expertise = expertise;
    }

    

}
