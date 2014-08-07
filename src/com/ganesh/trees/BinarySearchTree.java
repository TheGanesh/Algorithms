package com.ganesh.trees;


public class BinarySearchTree {

    private Node root;

    BinarySearchTree(int rootKey, int rootValue) {
        root = new Node(null, rootKey, rootValue, null);
    }

    public void insert(int key, int value) {

        Node newNode = new Node(null, key, value, null);

        Node current = root;
        Node parent = root;
        boolean isLeft = false;

        while (current != null) {
            parent = current;

            if (key < current.key) {
                current = current.leftChild;
                isLeft = true;
            } else if (key > current.key) {
                current = current.rightChild;
                isLeft = false;
            }
        }

        if (isLeft) {
            parent.leftChild = newNode;
        } else {
            parent.rightChild = newNode;
        }

    }


    public void delete(int key) {

    }

    public int find(int key) {
        return 0;
    }


    public int findMax() {
        return 0;
    }


    public int findMin() {
        return 0;
    }

    public void inOrder(Node current) {

        if (current != null) {
            inOrder(current.leftChild);
            System.out.print(current);
            inOrder(current.rightChild);
        }
    }

    public void preOrder(Node current) {

        if (current != null) {
            System.out.print(current);
            preOrder(current.leftChild);
            preOrder(current.rightChild);

        }

    }

    public void postOrder(Node current) {

        if (current != null) {
            postOrder(current.leftChild);
            postOrder(current.rightChild);
            System.out.print(current);

        }
    }

    public void traverse(String type) {

        if (type.equalsIgnoreCase("INORDER")) {
            inOrder(root);
        } else if (type.equalsIgnoreCase("PREORDER")) {
            preOrder(root);
        } else if (type.equalsIgnoreCase("POSTORDER")) {
            postOrder(root);
        }
    }

    public boolean isLeaf(Node node) {
        return (node.leftChild == null && node.rightChild == null);
    }

    public static void main(String[] args) {

        BinarySearchTree bst = new BinarySearchTree(20, 1);
        bst.insert(10, 2);
        bst.insert(5, 3);
        bst.insert(15, 4);
        bst.insert(30, 5);
        bst.insert(25, 6);
        bst.insert(35, 7);

        System.out.print("inOrder:");
        bst.traverse("INORDER");
        System.out.println("");
        System.out.print("postOrder:");
        bst.traverse("POSTORDER");
        System.out.println("");
        System.out.print("preOrder:");
        bst.traverse("PREORDER");
    }


    class Node {

        Node leftChild;
        int key;
        int value;
        Node rightChild;

        public Node(Node leftChild, int key, int value, Node rightChild) {
            this.leftChild = leftChild;
            this.key = key;
            this.value = value;
            this.rightChild = rightChild;
        }

        @Override
        public String toString() {
            return "(" + this.key + ")";
        }
    }
}
