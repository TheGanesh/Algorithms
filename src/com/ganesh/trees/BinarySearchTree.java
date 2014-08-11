package com.ganesh.trees;


import sun.print.resources.serviceui_pt_BR;

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


    public int find(int key) {
        Node current = root;
        while (current != null) {

            if (key == current.key) {
                return current.value;
            } else if (key < current.key) {
                current = current.leftChild;
            } else if (key > current.key) {
                current = current.rightChild;
            }


        }
        return -1;
    }


    public int findMax() {
        Node current = root;
        Node parent = root;
        while (current != null) {

            parent = current;
            current = current.rightChild;
        }
        return parent.key;
    }


    public int findMin() {
        Node current = root;
        Node parent = root;
        while (current != null) {

            parent = current;
            current = current.leftChild;
        }
        return parent.key;
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

    public boolean isLeafNode(Node node) {
        return (node.leftChild == null && node.rightChild == null);
    }

    public boolean isNodehasSingleChild(Node node) {
        return (node.leftChild == null || node.rightChild == null);
    }

    public void delete(int key) {


        Node delNode = root;
        Node parent = root;
        boolean isLeftChild = false;
        while (key != delNode.key) {
            parent = delNode;

            if (key < delNode.key) {
                delNode = delNode.leftChild;
                isLeftChild = true;
            } else if (key > delNode.key) {
                delNode = delNode.rightChild;
                isLeftChild = false;
            }

        }


        if (delNode.leftChild == null && delNode.rightChild == null) {
            if (isLeftChild) {
                parent.leftChild = null;
            } else {
                parent.rightChild = null;
            }
        } else if (delNode.leftChild == null && delNode.rightChild != null) {
            if (isLeftChild) {
                parent.leftChild = delNode.rightChild;
            } else {
                parent.rightChild = delNode.rightChild;
            }
        } else if (delNode.leftChild != null && delNode.rightChild == null) {
            if (isLeftChild) {
                parent.leftChild = delNode.leftChild;
            } else {
                parent.rightChild = delNode.leftChild;
            }
        } else {

            Node current = delNode.rightChild;
            Node successor = delNode;
            Node successorParent = delNode;
            while (current != null) {
                successorParent = successor;
                successor = current;
                current = current.leftChild;
            }

            //you properly connected successor with all required details
            if (successor != delNode.rightChild) {
                successorParent.leftChild = successor.rightChild;
                successor.rightChild = delNode.rightChild;
            }
            successor.leftChild = delNode.leftChild;

            // Now connecting successor to the delNode parent to form complete tree
            if (delNode == root) {
                root = successor;
            } else if (isLeftChild) {
                parent.leftChild = successor;
            } else {
                parent.rightChild = successor;
            }


        }

    }


    public static void main(String[] args) {

        BinarySearchTree bst = new BinarySearchTree(50, 1);
        bst.insert(75, 2);
        bst.insert(62, 3);
        bst.insert(87, 4);
        bst.insert(77, 5);
        bst.insert(79, 6);
        bst.insert(93, 7);
        bst.insert(30, 2);
        bst.insert(20, 3);
        bst.insert(40, 4);
        bst.insert(35, 5);


        System.out.print("inOrder:");
        bst.traverse("INORDER");
        System.out.println("");

        bst.delete(79);

        System.out.print("After deleting 79 inOrder:");
        bst.traverse("INORDER");
        System.out.println("");

        bst.delete(35);

        System.out.print("after deleting 35 inOrder:");
        bst.traverse("INORDER");
        System.out.println("");

        bst.insert(79, 0);
        bst.insert(35, 0);

        bst.delete(50);

        System.out.print("after deleting 50 inOrder:");
        bst.traverse("INORDER");
        System.out.println("");


//        System.out.println("");
//        System.out.print("postOrder:");
//        bst.traverse("POSTORDER");
//        System.out.println("");
//        System.out.print("preOrder:");
//        bst.traverse("PREORDER");

        //    System.out.println(bst.findMax());
        //   System.out.println(bst.findMin());
        // System.out.println(bst.find(100));
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
