package examples.linkedlist;

public class LinkedList {
    Node head;

    public void insert(int data) {
        Node node = new Node();
        node.data = data;
        node.nextNode = null;
        if (head == null) {
            head = node;
        } else {
            Node tempNode = head;
            while (tempNode.nextNode != null) {
                tempNode = tempNode.nextNode;
            }
            tempNode.nextNode = node;
        }
    }

    public void inseertAt(int index, int data)
    {
        Node node = new Node();
        node.data = data;
        Node tempNode = head;
        for (int i = 0 ; i<index-1 ; i++)
        {
           tempNode=tempNode.nextNode;
        }
        node.nextNode=tempNode;
    }
    public void insertAtStart(int data) {
        Node node = new Node();
        node.data = data;
        if (head == null) {
            head = node;
        } else {
            node.nextNode = head;
            head = node;
        }
    }

    public void show() {

        Node tempNode = head;
        while (tempNode.nextNode != null) {
            System.out.println(tempNode.data);
            tempNode = tempNode.nextNode;
        }
        System.out.println(tempNode.data);
    }
}
