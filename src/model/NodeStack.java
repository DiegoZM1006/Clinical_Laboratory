package model;

public class NodeStack<T> {
    private T value;
    private Patient patient;

    public NodeStack(T value, Patient patient) {
        this.value = value;
        this.patient = patient;
    }

    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }
}
