package misc;

import java.util.Arrays;
import java.util.Comparator;

public class MinimizeCoins
{
    public static void main(String[] args)
    {
        Integer[] coins = {1, 2, 5}; //Denomination available
        Arrays.sort(coins, Comparator.reverseOrder());  //[5, 2, 1]
        int targetSum = 15;
        int minCoins = 0;
        while(targetSum != 0) {
            for(int i = 0; i < coins.length; i++) {
                if(targetSum >= coins[i] && (targetSum - coins[i]) >= 0) {
                    targetSum -= coins[i];
                    minCoins++;
                    break;
                }
            }
        }
        System.out.println(minCoins);
    }
}
