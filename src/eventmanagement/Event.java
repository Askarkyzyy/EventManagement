package eventmanagement;

public class Event {
    private int id;
    private String name;
    private String date;
    private String location;

    //Constructor
    public Event(int id,String name,String date,String location){
        if(id>0) this.id=id; else this.id=1;
        this.name=name;
        this.date=date;
        this.location=location;
    }
    //Getters and setters
    public int getId(){ return id;}
    public void setId(int id){if(id>0) this.id=id;}

    public String getName() { return name; }
    public void setName(String name) { if(name != null && !name.isEmpty()) this.name=name; }

    public String getDate() { return date; }
    public void setDate(String date) { this.date = date; }

    public String getLocation() { return location; }
    public void setLocation(String location) { this.location = location;}

}
