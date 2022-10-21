package model;

import java.util.ArrayList;
import java.util.Iterator;

public class PriorityQueue<T> implements IPriorityQueue<T> {
    private ArrayList<NodePriorityQueue<T>> arrPriority;
    public PriorityQueue() {
        arrPriority = new ArrayList<>();
        arrPriority.add(null);
    }
    public void buildMaxHeapify() {
        for(int i = arrPriority.size()-1; i >=1; i--){
            maxHeapify(i);
        }
    }
    public void maxHeapify(int val) {
        int l = 2*val;
        int r = 2*val + 1;
        int max;
        if(l <= arrPriority.size()-1 && arrPriority.get(l).getPriority() > arrPriority.get(val).getPriority()) {
            max = l;
        } else {
            max = val;
        }
        if(r<= arrPriority.size()-1 && arrPriority.get(r).getPriority()  > arrPriority.get(max).getPriority() ) {
            max = r;
        }
        if(max != val) {
            NodePriorityQueue<T> temp1= arrPriority.get(val);
            NodePriorityQueue<T> temp2= arrPriority.get(max);
            arrPriority.set(val,temp2);
            arrPriority.set(max,temp1);
            maxHeapify(max);
        }
    }
    public ArrayList<NodePriorityQueue<T>> getArrPriority() {
        return arrPriority;
    }
    public void setArrPriority(ArrayList<NodePriorityQueue<T>> arrPriority) {
        this.arrPriority = arrPriority;
    }

    @Override
    public T extractMax() {
        if(arrPriority.size() <2) {
            //Error
        }
        T max = arrPriority.get(1).getValue();
        arrPriority.set(1, arrPriority.get(arrPriority.size()-1));
        arrPriority.remove(arrPriority.size()-1);
        maxHeapify(1);
        return max;
    }
    @Override
    public void insertElement(int priority, T patient) {
        arrPriority.add(new NodePriorityQueue(patient, priority));
        buildMaxHeapify();
    }

    @Override
    public T showMax() {
        return arrPriority.get(1).getValue();
    }

    @Override
    public String showQueue() {
        String cad = "";
        for (int i = 1; i < arrPriority.size() ; i++) {
            cad+= arrPriority.get(i).getPriority() + " "+ arrPriority.get(i).getValue() + "\n";
        }
        return cad;
    }

    public void deleteElement(Patient patient) {
        int cont = 0;
        for (NodePriorityQueue p : arrPriority) {
            if(p.getValue() == patient) break;
            cont++;
        }
        arrPriority.remove(cont);
    }

    @Override
    public void increaseKey(T element, int newValue) {
        int val = -1;
        for (int i = 1; i < arrPriority.size(); i++) {
            if(arrPriority.get(i).getValue().equals(element)) val = i;
        }
        if(newValue < arrPriority.get(val).getPriority()) {
            //
            //Error, the key is lower than the current key
        }
        while (val>1 && arrPriority.get(val/2).getPriority() < arrPriority.get(val).getPriority()){
            NodePriorityQueue<T> temp1 = arrPriority.get(val/2);
            NodePriorityQueue<T> temp2 = arrPriority.get(val);
            arrPriority.set(val, temp1);
            arrPriority.set(val/2, temp2);
            val = val/2;
        }
    }
}
