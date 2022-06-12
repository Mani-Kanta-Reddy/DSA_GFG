package misc;

import java.util.Arrays;
import utils.FastReader;

public class SumOfUncommonNumbers {
    public static void main(String[] args) {
        FastReader sc = new FastReader();

        int[] arr1 = Arrays.stream(sc.nextLine().split("\\s"))
                           .mapToInt(Integer::parseInt)
                           .toArray();

        int[] arr2 = Arrays.stream(sc.nextLine().split("\\s"))
                           .mapToInt(Integer::parseInt)
                           .toArray();

        System.out.println(SumOfUncommonNumber(arr1, arr2));
    }
    static int SumOfUncommonNumber(int[] arr1, int[] arr2) {
        int sum = 0;
        boolean isFound = false;
        for(int i = 0; i < arr1.length; i++) {
            isFound = false;
            for(int j = 0; j < arr2.length; j++) {
                if(arr1[i] == arr2[j]) {
                    isFound = true;
                    break;
                }
            }
            if(!isFound) 
                sum += arr1[i];  
        }
        isFound = false;
        for(int i = 0; i < arr2.length; i++) {
            isFound = false;
            for(int j = 0; j < arr1.length; j++) {
                if(arr2[i] == arr1[j]) {
                    isFound = true;
                    break;
                }
            }
            if(!isFound)
                sum += arr2[i];
        }
        int temp = sum;
        int temp2 = 0;
        while(temp > 9) {
            temp2 = 0;
            while(temp > 0) {
                temp2 += temp % 10;
                temp /= 10;
            }
            temp = temp2;
        }
        return temp2;
    }
}
