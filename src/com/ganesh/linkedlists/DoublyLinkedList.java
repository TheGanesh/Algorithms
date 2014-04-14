package com.ganesh.linkedlists;

public class DoublyLinkedList {

    Node head;
    Node tail;

    public DoublyLinkedList(int i) {
        Node newNode = new Node(i, null, null);
        this.head = newNode;
        this.tail = newNode;
    }

    public void printFromHead() {

        for (Node pointer = head; pointer != null; pointer = pointer.nextNode) {
            System.out.print(pointer);
        }
        System.out.println("   @@@@@@@@@@ head:" + head + "  tail:" + tail);

    }

    public void printFromTail() {

        for (Node pointer = tail; pointer != null; pointer = pointer.previousNode) {
            System.out.print(pointer);
        }
        System.out.println("   @@@@@@@@@@ head:" + head + "  tail:" + tail);

    }


    public void insertFirst(int i) {
        Node newNode = new Node(i, head, null);
        head.previousNode = newNode;
        head = newNode;

    }

    public void insertLast(int i) {
        Node newNode = new Node(i, null, tail);
        tail.nextNode = newNode;
        tail = newNode;
    }

    public void delete(int i) {

        if (head.data == i) {
            head.nextNode.previousNode = null;
            head = head.nextNode;
            return;
        }

        if (tail.data == i) {
            tail.previousNode.nextNode = null;
            tail = tail.previousNode;
            return;
        }

        for (Node pointer = head; pointer != null; pointer = pointer.nextNode) {

            if (pointer.data == i) {

                if (pointer.previousNode != null) {
                    pointer.previousNode.nextNode = pointer.nextNode;
                }

                if (pointer.nextNode != null) {
                    pointer.nextNode.previousNode = pointer.previousNode;
                }

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

        DoublyLinkedList dll = new DoublyLinkedList(10);

        dll.printFromHead();
        dll.insertFirst(20);
        dll.insertFirst(15);
        dll.printFromHead();
        dll.insertLast(2);
        dll.printFromHead();
        dll.delete(2);
        dll.insertLast(30);
        dll.insertLast(81);
        dll.insertFirst(01);

        dll.printFromHead();
        dll.printFromTail();
        System.out.println("index of 15 is:" + dll.find(15));

    }

    private class Node {

        int data;
        Node nextNode;
        Node previousNode;

        Node(int data, Node nextNode, Node previousNode) {
            this.data = data;
            this.nextNode = nextNode;
            this.previousNode = previousNode;
        }

        @Override
        public String toString() {
            String result = "[" + data + "]";
            if (nextNode != null) {
                result = result + "->";
            }
            if (previousNode != null) {
                result = "<-" + result;
            }
            return result;
        }
    }

}
