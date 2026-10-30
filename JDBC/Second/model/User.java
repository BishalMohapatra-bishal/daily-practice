package JDBC.Second.model;

public class User {

    private int id;
    private String name;
    private String address;

    public User(String name, String address) {
        this.name = name;
        this.address = address;
    }

    public User() {}

    @Override 
    public String toString() {
        return "Student[ " + "name : " + name + " address : " + address + " ]";
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
    
}
