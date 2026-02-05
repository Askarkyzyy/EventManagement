package eventmanagement;

import java.util.Objects;

public abstract class Person {
    protected int id;
    protected String name;

    public Person(int id, String name) {
        this.id = id > 0 ? id : 1;
        this.name = name;
    }

    public void setId(int id) {
        if(id > 0) {
            this.id = id;
        }
    }


    public abstract String getRole();

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "id=" + id + ", name='" + name + "'";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Person)) return false;
        Person person = (Person) o;
        return id == person.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

}
