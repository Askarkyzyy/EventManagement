package eventmanagement;

public class Participant extends Person {
    private String email;

    public Participant(int id, String name, String email) {
        super(id, name);
        this.email = email;
    }


    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        if(email != null && !email.isEmpty()) {
            this.email = email;
        }
    }




    @Override
    public String getRole() {
        return "Participant";
    }

    @Override
    public String toString() {
        return "Participant{" + super.toString() + ", email='" + email + "'}";
    }
}
