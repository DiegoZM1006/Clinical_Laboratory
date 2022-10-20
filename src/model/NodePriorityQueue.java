package model;

public class NodePriorityQueue<T> {
    private T value;
    private int priority;

    public NodePriorityQueue(T value, int priority){
        this.value = value;
        this.priority = priority;
    }

    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }

    public int getPriority() {
        return priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }
}
