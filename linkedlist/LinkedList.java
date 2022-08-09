package linkedlist;

public class LinkedList {
    Node head;

    static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    LinkedList add(int data) {
        Node newNode = new Node(data);
        if(this.head == null) {
            this.head = newNode;
        } else {
            Node temp = this.head;
            while(temp.next != null) {
                temp = temp.next;
            }
            temp.next = newNode;
        }
        return this;
    }
    
    void print() {
        Node temp = head;
        while(temp != null) {
            System.out.println(temp.data);
            temp = temp.next;
        }
    }
    public static void main(String[] args) {
        LinkedList list = new LinkedList();
        list.add(1);
        list.add(3);
        list.add(2);
        list.add(4);
        list.print();

    }
}
