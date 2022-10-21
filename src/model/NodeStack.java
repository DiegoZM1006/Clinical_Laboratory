package model;

public class NodeStack<T> {
    private T patient;

    public NodeStack(T patient) {
        this.patient = patient;
    }

    public T getPatient() {
        return patient;
    }

    public void setPatient(T patient) {
        this.patient = patient;
    }
}
