
public class Node {
    public int data;
    public Node next;

    public static Node add(Node head, Node curr) {
        //if list is already empty:
        if(head == null) {
            head = curr;
        }
        //list already contains some nodes
        else {
            Node temp = head;
            while(temp.next != null) {
                temp = temp.next;
            }
            temp.next = curr;
        }
        return head;
    }
    
    @Override
    public String toString() {
        String listRep = "";
        Node temp = this;
        while(temp != null) {
            listRep = listRep + " " + temp.data;
            temp = temp.next;
        }
        return listRep;
    }
    

    public static void main(String[] args) {
        Node list1 = null;
        Node n1 = new Node();
        n1.data = 1;
        list1 = add(list1, n1);
        Node n2 = new Node();
        n2.data = 2;
        add(list1, n2);
        Node n3 = new Node();
        n3.data = 3;
        add(list1, n3);
        Node n4 = new Node();
        n4.data = 4;
        add(list1, n4);
        Node n5 = new Node();
        n5.data = 5;
        add(list1, n5);
        System.out.println(list1);      
    }
}

