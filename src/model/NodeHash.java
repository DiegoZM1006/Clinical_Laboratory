package model;

public class NodeHash<K> {

    private K key;
    private NodeHash<K> next;
    private NodeHash<K> prev;
    private Patient patient;

    public NodeHash(K key, Patient patient) {
        this.key = key;
        this.patient = patient;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public K getKey() {
        return key;
    }

    public void setKey(K key) {
        this.key = key;
    }

    public NodeHash<K> getNext() {
        return next;
    }

    public void setNext(NodeHash<K> next) {
        this.next = next;
    }

    public NodeHash<K> getPrev() {
        return prev;
    }

    public void setPrev(NodeHash<K> prev) {
        this.prev = prev;
    }
}
