package model;

import java.util.ArrayList;

public class STack<T> implements IStack<T> {

    private ArrayList<NodeStack<T>> patients;
    private NodeStack<T> top;

    public STack()
    {
        patients = new ArrayList<>();
        top = null;
    }

    @Override
    public void push(T patient){
        top = new NodeStack<>(patient);
        patients.add(top);
    }

    @Override
    public NodeStack<T> pop(){

        NodeStack tempTop = top;

        if(isEmpty()) {
            System.out.println("There is no elements in the stack");
        } else {
            top = patients.get(patients.size() - 1);
            patients.remove(patients.size()-1);
        }
        return tempTop;
    }

    @Override
    public NodeStack<T> peek(){
        if (!isEmpty()) {
            return top;
        } else {
            System.out.println("There is no elements in the stack");
        }
        return null;
    }

    @Override
    public boolean isEmpty(){
        return patients.size() == 0;
    }

    public int size(){
        return patients.size() - 1;
    }
}
