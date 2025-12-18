package eventmanagement;

public class Participiant {
    private int id;
    private String name;
    private String email;

    // Constructor
    public Participiant(int id, String name, String email) {
        if(id > 0) this.id = id; else this.id = 1;
        this.name = name;
        this.email = email;
    }

    // Getters and setters
    public int getId() { return id; }
    public void setId(int id) { if(id > 0) this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { if(name != null && !name.isEmpty()) this.name = name; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
}

