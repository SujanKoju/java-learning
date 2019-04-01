package examples.linkedlist;

public class Main {

    public static void main(String[] args) {
        LinkedList linkedList = new LinkedList();
        linkedList.insert(5);
        linkedList.insert(12);
        linkedList.insert(77);
        linkedList.insert(54);
        linkedList.insertAtStart(1);
        linkedList.show();

        java.util.LinkedList ll = new java.util.LinkedList();
        ll.add(55);
    }


}
