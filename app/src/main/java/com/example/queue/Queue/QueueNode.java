package com.example.queue.Queue;

public class QueueNode {
    private int data;
    private QueueNode next;

    public QueueNode(int data) {
        this.data = data;
        next = null;
    }

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }

    public QueueNode getNext() {
        return next;
    }

    public void setNext(QueueNode next) {
        this.next = next;
    }



    @Override
    public String toString() {
        return String.valueOf(data);
    }
}
