package teste.pact.providerNumber;

public class PersonInfo {
    String name;
    String lastname;
    Integer id;


    public PersonInfo(String name, String lastname, Integer id) {
        this.name = name;
        this.lastname = lastname;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public String getLastname() {
       return lastname;
    }

    public Integer getId() {
        return id;
    }

    public void setName(String name) {
        this.name = name;
    }
     public void setLastname(String surname) {
        this.lastname = surname;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
