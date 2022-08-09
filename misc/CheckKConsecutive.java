package misc;

import utils.FastReader;

public class CheckKConsecutive {
    public static void main(String[] args) {
        /*
            Input: maaanikbasha
                   3
            Output: true (since there are three consecutive chars that are same in given Input String (a starting from 1 to 3))

            Input: aohaoeryol
                   3
            Output: false (since there are no three consecutive chars that are same in given Input String)
                    
        */
        FastReader sc = new FastReader();
        String str = sc.next();
        int k = sc.nextInt();
        
        System.out.println(checkIfKConsecutive(str, k));
    }
    static boolean checkIfKConsecutive(String str, int k) {
        for(int i = 0; i <= str.length() - k; i++) {
            int count = 1;
            int l = i + 1;

            for(int j = 0; j < k - 1; j++, l++) {
                if(str.charAt(i) != str.charAt(l)) {
                    break;
                }
                if(str.charAt(i) == str.charAt(l)) {
                    count++;
                }
            }
            if(count == k) {
                return true;
            }
        }
        return false;
    }
}
