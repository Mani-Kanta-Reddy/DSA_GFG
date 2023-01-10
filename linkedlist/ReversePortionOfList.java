package linkedlist;

import java.util.Scanner;

public class ReversePortionOfList
{
    public static void main(String[] args)
    {
        // 1 -> 2 -> 3 -> 4 -> 5
        // left -> 2, right -> 4
        // 1 -> 4 -> 3 -> 2 -> 5
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        LinkedList list = new LinkedList();
        for(int i = 0; i < n; i++) {
            list.add(sc.nextInt());
        }
        int left = sc.nextInt();
        int right = sc.nextInt();

        reversePortionOfList(list, left, right).print();
    }
    public static LinkedList reversePortionOfList(LinkedList list, int start, int end) {
        //guard-clause corner-case when start and end are same
        if(start == end) {
            return list;
        } else {
            LinkedList.Node temp = list.head;
            LinkedList.Node prev = null;
            int counter = 1;
            while(counter < start) {
                prev = temp;
                temp = temp.next;
                counter++;
            }
            //`temp` is pointing to `start` and `prev` is pointing to the node just before `start` :) and counter is start
            LinkedList.Node temp1 = temp;
            while(counter < end) {
                temp1 = temp1.next;
                counter++;
            }
            //`temp1` is pointing to `end`
            LinkedList.Node endPlusOne = temp1.next;
            //Now reverse nodes starting from start (temp) till end (temp1)
            LinkedList.Node curr = temp.next;
            LinkedList.Node previous = temp;
            LinkedList.Node aux = curr.next;


            while(previous != temp1) {
                curr.next = previous;
                previous = curr;
                curr = aux;
            }

            while(previous != temp1) {
                curr.next = previous;
                previous = curr;
                curr = aux;
                aux = aux.next;
            }


            //now change `start - 1` nodes next to end
            prev.next = temp1;

            temp.next = endPlusOne;
            return list;
        }
    }
}
