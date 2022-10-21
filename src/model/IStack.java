package model;

public interface IStack<T> {
    public void push(T patient);
    public NodeStack<T> pop();
    public NodeStack<T> peek();
    public boolean isEmpty();
}
