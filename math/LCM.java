package math;
import utils.FastReader;

public class LCM {
    public static void main(String[] args) {
        FastReader sc = new FastReader();
        int a = sc.nextInt();
        int b = sc.nextInt();
        System.out.println(findLCM(a, b));
        System.out.println(findLCM(new int[] {2, 7, 0, 9, 4}));
    }
    static int findLCM(int a, int b) {
        int small = Math.min(a, b);
        int i = 1;
        while(true) {
            int temp = small * i;
            if(temp % a == 0 && temp % b == 0)
                return temp;
            i++;
        }
    }
    static int findLCM(int[] arr) {
        //find the smallest element from the array:
        int soFarSmall = arr[0];
        for(int i = 1; i < arr.length; i++)
            soFarSmall = Math.min(soFarSmall, arr[i]);

        int i = 1; 
        while(true) {
            int temp = soFarSmall * i;
            boolean isAllFactors = true;
            for(int j = 0; j < arr.length; j++) {
                if(arr[j] == 0) return 0;
                if(temp % arr[j] != 0)
                    isAllFactors = false;
                
            }
            if(isAllFactors)    return temp;
            i++;
        }
    }   
}
