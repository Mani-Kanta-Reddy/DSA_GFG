package misc;

import java.util.Scanner;

public class GuessTheNumber {
    private static int pick;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        pick = sc.nextInt();
        System.out.println(new GuessTheNumber().guessNumber(n));
        sc.close();
    }
    public int guessNumber(int n) {
        int low = 1;
        int high = n;
        while(low <= high) {
            int mid = (high - low) / 2 + low;
            int res = guess(mid);
            if(res == 0) {
                return mid;
            } else if(res == -1) {
                //left-half
                high = mid - 1;
            } else {
                //right-half
                low = mid + 1;
            }
        }
        return -1;
    }
    public int guess(int num) {
        return num > pick ? -1 : num == pick ? 0 : 1;
    }
}
