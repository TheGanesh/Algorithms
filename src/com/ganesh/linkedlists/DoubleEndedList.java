package com.ganesh.linkedlists;

public class DoubleEndedList {

    Node head;
    Node tail;

    public DoubleEndedList(int i) {
        Node newNode = new Node(i, null);
        this.head = newNode;
        this.tail = newNode;
    }

    public void print() {

        for (Node pointer = head; pointer != null; pointer = pointer.nextNode) {
            System.out.print(pointer);
        }
        System.out.println("   @@@@@@@@@@ head:" + head + "  tail:" + tail);

    }

    public void insertFirst(int i) {
        head = new Node(i, head);
    }

    public void insertLast(int i) {
        Node newNode = new Node(i, null);
        tail.nextNode = newNode;
        tail = newNode;
    }

    public void delete(int i) {

        if (head.data == i) {
            head = head.nextNode;
            return;
        }

        for (Node pointer = head; pointer != null; pointer = pointer.nextNode) {
            if (pointer.nextNode != null && pointer.nextNode.data == i) {

                if (pointer.nextNode == tail) {
                    tail = pointer;
                }
                pointer.nextNode = pointer.nextNode.nextNode;
            }
        }

    }

    public int find(int i) {

        int position = 0;
        if (head.data == i) {
            return 0;
        }

        for (Node pointer = head; pointer != null; pointer = pointer.nextNode) {
            position++;
            if (pointer.nextNode != null && pointer.nextNode.data == i) {
                return position;
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        DoubleEndedList del = new DoubleEndedList(10);

        del.print();
        del.insertFirst(20);
        del.insertFirst(15);
        del.print();
        del.insertLast(2);
        del.print();
        del.delete(2);
        del.insertLast(30);
        del.insertLast(81);
        del.insertFirst(01);

        del.print();
        System.out.println("index of 15 is:" + del.find(15));

    }

    private class Node {

        int data;
        Node nextNode;

        Node(int data, Node nextNode) {
            this.data = data;
            this.nextNode = nextNode;
        }

        @Override
        public String toString() {
            String result = "[" + data + "]";
            if (nextNode != null) {
                result = result + "->";
            }
            return result;
        }
    }

}
