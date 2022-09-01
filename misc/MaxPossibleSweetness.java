package misc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.Map;
import java.util.TreeMap;

public class MaxPossibleSweetness
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long T = Integer.parseInt(br.readLine());
        while(T-- > 0) {
            String[] arr = br.readLine().split("\\s");
            long noOfCandies = Integer.parseInt(arr[0]);
            long totalCash = Integer.parseInt(arr[1]);
            String[] price = br.readLine().split("\\s");
            String[] sweetness = br.readLine().split("\\s");
            TreeMap<Long, Long> sweetToPrice = new TreeMap<>(Comparator.reverseOrder());
            for(int i = 0; i < sweetness.length; i++) {
                sweetToPrice.put(Long.parseLong(sweetness[i]), Long.parseLong(price[i]));
            }
            long maxSweetness = 0L;
            int noOfCandiesBought = 0;
            for(Map.Entry<Long, Long> entry : sweetToPrice.entrySet()) {
                if(noOfCandiesBought == 2) {
                    break;
                }
                if(noOfCandiesBought < 2) {
                    if(entry.getValue() <= totalCash) {
                        //can buy
                        maxSweetness += entry.getKey();
                        totalCash -= entry.getValue();
                        noOfCandiesBought++;
                    }
                }
            }
            System.out.println(maxSweetness);
        }
    }
}
