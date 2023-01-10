package misc;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class MedianFinder
{
    Queue<Integer> leftPQ, rightPQ;

    public MedianFinder() {
        leftPQ = new PriorityQueue<>(Comparator.reverseOrder());
        rightPQ = new PriorityQueue<>();
    }
    public void addNum(int num) {
        if(leftPQ.isEmpty()) {
            leftPQ.add(num);
            return;
        }
        //compare the `num` with `max` of leftPQ & the `min` of rightPQ
        int lmax = leftPQ.peek();
        if(num > lmax) {
            //push it to rightPQ
            //After pushing check if the size of rightPQ is > leftPQ.size() + 1
            //if greater push `min` from rightPQ to leftPQ (balance)
            rightPQ.add(num);
            if(rightPQ.size() > leftPQ.size() + 1) {
                //balance
                int minFromRight = rightPQ.poll();
                leftPQ.add(minFromRight);
            }
        } else {
            //num <= lmax
            //push the `num` to `leftPQ` after pushing check the leftPQ > rightPQ.size() + 1
            //if greater push `max` of leftPQ to rightPQ (balance)
            leftPQ.add(num);
            if(leftPQ.size() > rightPQ.size() + 1) {
                //balance
                int maxFromRight = leftPQ.poll();
                rightPQ.add(maxFromRight);
            }
        }
    }
    public double findMedian() {
        int lsize = leftPQ.size();
        int rsize = rightPQ.size();
        return lsize == rsize ? (leftPQ.peek() + rightPQ.peek()) / 2.0D : lsize > rsize ? leftPQ.peek() : rightPQ.peek();
    }
    //Leetcode - 295
    public static void main(String[] args)
    {
        MedianFinder medianFinder = new MedianFinder();
        medianFinder.addNum(1);
        medianFinder.addNum(2);
        medianFinder.addNum(3);
//        medianFinder.addNum(4);
//        medianFinder.addNum(52);
//        medianFinder.addNum(19);
//        medianFinder.addNum(27);
//        medianFinder.addNum(4);
        System.out.println(medianFinder.findMedian());
    }

}
