package com.example.queue.Queue;

import android.util.Log;

public class Queue {
    private QueueNode first;
    private QueueNode last;
    private int cont = 0;

    public Queue() {
        first = null;
        last = null;
    }

    public void add(int data){
        QueueNode node = new QueueNode(data);
        if(node == null){
            Log.i("Log", "QueueOverFlow");
        } else {
            if( first == null)
                first = node;
            else
                last.setNext(node);
            last = node;
            cont ++;
        }
    }

    public void print(){
        String result = "";
        QueueNode aux = first;
        while (aux != null){
            result += aux+"->";
            aux = aux.getNext();
        }
        Log.i("Log", result+"");
    }

    public QueueNode getFirst() {
        return first;
    }

    public QueueNode getLast() {
        return last;
    }

    public int getCont() {
        return cont;
    }

    public void setCont(int cont) {
        this.cont = cont;
    }

    public int remove() {
        if(first == null){
            return -1;
        } else  {
            QueueNode node = first;
            first = first.getNext();
            if(first == null){
                last = null;
            }
            cont --;
            return node.getData();
        }
    }
}
