package misc;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ZennyAndSimpleSum
{
    //remove duplicates and then count positives and negatives separately
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while(T-- > 0) {
            int noOfNumbers = sc.nextInt();
            List<Integer> numbers = new ArrayList<>();
            int positiveSum = 0;
            int negativeSum = 0;
            for(int i = 0; i < noOfNumbers; i++) {
                int curr = sc.nextInt();
                if(!numbers.contains(curr)) {
                    numbers.add(curr);
                    if(curr < 0) {
                        negativeSum += curr;
                    } else {
                        positiveSum += curr;
                    }
                }
            }
            System.out.printf("%d %d \n", positiveSum, negativeSum);
        }
    }
}
