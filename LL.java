public class LL {
    Node head;

    static class Node {
        public int data;
        public Node next;

        public Node(int data) {
            this.data = data;
            this.next = null;
        }
    }
    //add(int data) append to the list
    public void add(int data) {
        Node newNode = new Node(data);
        //if list is empty
        if(head == null) {
            head = newNode;
        }
        //if list non-empty
        else {
            Node temp = head;
            while(temp.next != null) {
                temp = temp.next;
            }
            temp.next = newNode;
        }
    }
    
    public void print() {
        Node temp = head;
        while(temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
    }
    public static void main(String[] args) {
        LL l1 = new LL();
        l1.add(1);
        l1.add(2);
        l1.add(3);
        l1.print();
    }
}
