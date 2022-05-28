import java.util.Arrays;

public class MinimumGroupFlips {
    public static void main(String[] args) {
        /*
        Target: Make all the element same either by flipping 1's or 0's
        Note: You can flip consecutive zeroes or consecutive ones at single stretch but you can flip either 0's or 1's but not 0's & 1's
        Input: [1, 1, 0, 0, 0, 1]
        Output: from 2 to 4
        */
        FastReader sc = new FastReader();
        int[] arr = Arrays.stream(sc.nextLine().split("\\s"))
                          .map(Integer::parseInt)
                          .mapToInt(Integer::valueOf)
                          .toArray();
        // minimumGroupFlips(arr); //Naive O(n) + O(n) (two traversals of the given array) | O(1)
        minimumGroupFlipsEfficient(arr); //O(n) | O(1)
    }
    static void minimumGroupFlipsEfficient(int[] arr) {
        /*
        The idea goes like this (and it's based on the below interesting fact of the given binary array)
        The Difference b/w the flipZeroes & flipOnes is always atmost 1 (either 1 or 1)
        Example for 1:
        1 1 0 0 0 1 0 1 1   => 3 - 2
        0 1 1 1 0 0 1 1 0   => 3 - 2 

        1 1 1               => 1 - 0
        0 0 0               => 1 - 0
        Example for 0:
        0 0 1 1 1 0 0 1 1   => 2 - 2
        1 1 0 0 1 1 0 0 0   => 2 - 2

        And the interesting fact from the examples above is that if start and end is same then diff is 1 else 0
        So always flip the second group because for example 1 its gives minimum flips for example two it same
        */
        //find second group elements & flip them
        for(int i = 1; i < arr.length; i++) {
            if(arr[i] != arr[i - 1]) {
                if(arr[i] != arr[0])
                    System.out.printf("From %d -> ", i);
                else
                    System.out.printf("%d \n", i - 1);
            }
        }
        if(arr[arr.length - 1] != arr[0])
            System.out.printf("%d", arr.length - 1);
    }
    static void minimumGroupFlips(int[] arr) {
        //Count FlipOnes & FlipZeroes
        int flipOnes = 0, flipZeroes = 0;
        for(int i = 1; i < arr.length; i++) {
            if(arr[i] == arr[i - 1])
                continue;
            else {
                if(arr[i - 1] == 1)
                    flipOnes++;
                else 
                    flipZeroes++;
            }
        }
        if(arr[arr.length - 1] != arr[arr.length - 2]) {
            if(arr[arr.length - 1] == 1) {
                flipOnes++;
            } else {
                flipZeroes++;
            }
        } else {
            if(arr[arr.length - 1] == 1)
                flipOnes++;
            else 
                flipZeroes++;
        }
        System.out.printf("FlipZeroes = %d, FlipOnes = %d \n", flipZeroes, flipOnes);
        if(flipZeroes < flipOnes) {
            printOutputWhenFlipZeroesIsLess(arr);
        } else if(flipOnes < flipZeroes) {
            printOutputWhenFlipOnesIsLess(arr);
        } else {
            //flipZeroes == flipOnes
            //I'm going with flipZeroes sol you could also print flipOnes sol
            printOutputWhenFlipZeroesIsLess(arr);
        }
    }
    private static void printOutputWhenFlipOnesIsLess(int[] arr) {
        boolean isOneAppeared = false;
        for(int i = 0; i < arr.length; i++) {
            if(arr[i] == 1) {
                if(!isOneAppeared) {
                    isOneAppeared = true;
                    System.out.printf("From %d -> ", i);
                }
                continue;
            } else {
                if(isOneAppeared) {
                    System.out.printf("%d \n", i - 1);
                    isOneAppeared = false;
                }
            }
        }
    }
    private static void printOutputWhenFlipZeroesIsLess(int[] arr) {
        boolean isZeroAppeared = false;
        for(int i = 0; i < arr.length; i++) {
            if(arr[i] == 0) {
                if(!isZeroAppeared) {
                    isZeroAppeared = true; 
                    System.out.printf("From %d -> ", i);
                }
                continue;
            } else {
                if(isZeroAppeared) {
                    System.out.printf("%d \n", i - 1);
                    isZeroAppeared = false;
                }
            }
        }
    }
}
