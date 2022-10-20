package model;

public class Patient {

    private String name;
    private String age;
    private String gender;
    private String id;
    private boolean priority;

    public Patient(String name, String age, String gender, String id, boolean priority) {
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.id = id;
        this.priority = priority;
    }



    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
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

    public boolean isPriority() {
        return priority;
    }

    public void setPriority(boolean priority) {
        this.priority = priority;
    }

    @Override
    public String toString() {
        return "Patient{" +
                "name='" + name + '\'' +
                ", age='" + age + '\'' +
                ", gender='" + gender + '\'' +
                ", id='" + id + '\'' +
                ", priority=" + priority +
                '}';
    }
}
