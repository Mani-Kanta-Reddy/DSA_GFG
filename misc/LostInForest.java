package misc;

public class LostInForest {
    public static void main(String[] args) {
        System.out.println(lostInForest(10));    
    }

    static int lostInForest(int m) {
        //run a loop from 2 to m find the largest path (print all the paths)
        int result = 0;
        int[] mask = new int[m];
        for(int i = 2; i <= m; i++) {
            int temp = i;
            int pathLength = 0;
            System.out.print(i + "-> ");
            while(temp == 1) {
                if(temp == 1) break;
                
                if(temp % 2 == 0) {
                    temp = temp / 2;
                    System.out.print(temp + "-> ");
                }
                else {
                    temp = 3 * temp + 1;
                    System.out.print(temp + "-> ");
                }
                pathLength++;
            }
            mask[i - 1] = pathLength;
            if(mask[i - 1] > mask[result])
                result = i - 1;
            System.out.println();
        }
        return result + 1;
    }
}
