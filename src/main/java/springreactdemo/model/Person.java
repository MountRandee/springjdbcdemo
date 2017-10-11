package springreactdemo.model;

public class Person {
    
    private Integer id;
    private String firstName;
    private String lastName;
    private AliveStatusEnum aliveStatus;
    
    public Person() {}
    
    public Person(Integer id, String firstName, String lastName, AliveStatusEnum aliveStatus) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.aliveStatus = aliveStatus;
    }
    
    public Integer getId() {
        return id;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }
    
    public String getFirstName() {
        return firstName;
    }
    
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    
    public String getLastName() {
        return lastName;
    }
    
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    
    public AliveStatusEnum getAliveStatus() {
        return aliveStatus;
    }
    
    public void setAliveStatus(AliveStatusEnum aliveStatus) {
        this.aliveStatus = aliveStatus;
    }
}