package com.ganesh.queue;


import java.util.Arrays;

public class ArrayQueue {

    private int[] queue;
    private int front;
    private int rear;
    private int nItems;

    public ArrayQueue(int[] queue) {
        this.queue = queue;
        front = 0;
        rear = -1;
        nItems = 0;
    }

    public void insert(int i) {
        if (!isFull()) {
            if (rear == queue.length - 1) {
                rear = 0;
            } else {
                rear++;
            }
            queue[rear] = i;
            nItems++;
        }
    }

    public void delete() {

        if (!isEmpty()) {

            queue[front] = 0;
            if (front == queue.length - 1) {
                front = 0;
            } else {
                front++;
            }
            nItems--;
        }
    }

    public boolean isEmpty() {
        return nItems == 0;
    }

    public boolean isFull() {
        return nItems == queue.length;
    }

    public void print() {
        System.out.println("Front:" + front + "     Rear:" + rear+"  nItems:"+nItems);
        System.out.println(Arrays.toString(queue));
    }

    public static void main(String[] args) {
        ArrayQueue aq = new ArrayQueue(new int[10]);
        aq.insert(1);
        aq.insert(2);
        aq.print();
        aq.insert(3);
        aq.insert(4);
        aq.insert(5);
        aq.insert(6);
        aq.insert(7);
        aq.print();
        aq.delete();
        aq.print();
        aq.insert(8);
        aq.insert(9);
        aq.insert(10);
        aq.insert(11);
        aq.insert(12);
        aq.print();
        aq.delete();
        aq.delete();
        aq.delete();
        aq.delete();
        aq.delete();
        aq.delete();
        aq.delete();
        aq.delete();
        aq.delete();
        aq.print();


    }
}
