package misc;

import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;

public class OrderlyQueue
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        int k = sc.nextInt();
        System.out.println(new OrderlyQueue().orderlyQueue(str, k));
    }

    private String orderlyQueue(String str, int k)
    {
        if(k == 1) {
            //find the smallest char that starts
            char smallest = 'z';
            int idxOfSmallest = 0;
            for(int i = 0; i < str.length(); i++) {
                if(str.charAt(i) < smallest) {
                    smallest = str.charAt(i);
                    idxOfSmallest = i;
                }
            }
            StringBuilder sb = new StringBuilder(str);
            StringBuilder firstHalf = new StringBuilder();
            for(int i = 0; i < idxOfSmallest; i++) {
                firstHalf.append(sb.charAt(i));
            }
            sb.delete(0, idxOfSmallest);
            sb.append(firstHalf);
            return sb.toString();
        }
        boolean isParentGreaterThanChild = false;
        String currParent = str;
        String finalRes = null;
        do {
            isParentGreaterThanChild = false;   //restore state for next iteration
            Queue<StringBuilder> currPQ = new PriorityQueue<>();
            for(int i = 0; i < k; i++) {
                StringBuilder sb = new StringBuilder(currParent);
                sb.append(currParent.charAt(i));
                sb.deleteCharAt(i);
                currPQ.add(sb);
            }
            StringBuilder parent = currPQ.peek();
            Queue<StringBuilder> pq = new PriorityQueue<>();
            for(int i = 0; i < k; i++) {
                StringBuilder sb = new StringBuilder(parent);
                sb.append(parent.charAt(i));
                sb.deleteCharAt(i);
                pq.add(sb);
            }
            int value = parent.compareTo(pq.peek());
            if(value > 0) {
                isParentGreaterThanChild = true;
                currParent = parent.toString();
            } else {
                finalRes = parent.toString();
            }
        } while(isParentGreaterThanChild);  //while parent > child
        return finalRes;
    }
}
