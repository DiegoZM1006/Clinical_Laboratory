package model;

import java.util.ArrayList;

public class Stack<T> implements IStack<T> {

    private NodeStack[] patients;
    private NodeStack top;
    private int capacity;
    private int cont = 0;

    Stack()
    {
        patients = new NodeStack[10000000];
        capacity = 10000000;
        top = null;
    }

    @Override
    public boolean isFull(){
        return cont == capacity - 1;
    }

    @Override
    public void push(Patient patient){
        if (isFull()) {
            System.out.println("You cant add more patients");
            System.exit(-1);
        }

        System.out.println("Inserting " + patient);
        patients[cont] = patient;
    }
}
