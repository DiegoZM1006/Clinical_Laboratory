package model;

public class Patient {

    private String name;
    private String lastName;
    private int age;
    private String gender;
    private String id;
    private int priority;

    public Patient(String name, String lastName, int age, String gender, String id, int priority) {
        this.name = name;
        this.lastName = lastName;
        this.age = age;
        this.gender = gender;
        this.id = id;
        this.priority = priority;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getPriority() {
        return priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }

    @Override
    public String toString() {
        return "Patient{" +
                "name='" + name + '\'' +
                "lastName='" + lastName + '\'' +
                ", age='" + age + '\'' +
                ", gender='" + gender + '\'' +
                ", id='" + id + '\'';
    }
}
