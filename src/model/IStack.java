package model;

public interface IStack<T> {
    public void push(T value);
    public T pop();
    public T peek();
    public boolean isEmpty();
    public boolean isFull();
}
