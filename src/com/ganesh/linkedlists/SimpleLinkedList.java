package com.ganesh.linkedlists;

public class SimpleLinkedList {

    Node head;

    public SimpleLinkedList(int i) {
        this.head = new Node(i, null);
    }

    public void print() {

        for (Node pointer = head; pointer != null; pointer = pointer.nextNode) {
            System.out.print(pointer);
        }
        System.out.println("");

    }

    public void insert(int i) {
        head = new Node(i, head);
    }

    public void delete(int i) {

        if (head.data == i) {
            head = head.nextNode;
            return;
        }
        for (Node pointer = head; pointer != null; pointer = pointer.nextNode) {
            if (pointer.nextNode != null && pointer.nextNode.data == i) {
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
        SimpleLinkedList sll = new SimpleLinkedList(10);
        sll.print();
        sll.insert(20);
        sll.insert(15);
        sll.insert(2);
        sll.print();
        sll.delete(10);
        sll.delete(20);

        sll.print();
        System.out.println("index of 2 is:" + sll.find(2));

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

