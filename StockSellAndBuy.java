import java.util.Arrays;

public class StockSellAndBuy {
    public static void main(String[] args) {
        FastReader sc = new FastReader();
        int[] arr = Arrays.stream(sc.nextLine().split("\\s"))
                          .map(Integer::parseInt)
                          .mapToInt(Integer::valueOf)
                          .toArray();
        System.out.println(findMaxProfitNaive(arr, 0, arr.length - 1));
        System.out.println(findMaxProfitEfficient(arr));
    }
    static int findMaxProfitNaive(int[] arr, int start, int end) {
        int profit = 0;
        //base-case:
        if (end <= start) {
            return 0;
        }
        //recursive - case:
        for(int i = start; i < end; i++) {
            for(int j = i + 1; j <= end; j++) {
                if(arr[j] > arr[i]) {
                    int curr_profit = arr[j] - arr[i] 
                                      + findMaxProfitNaive(arr, start, i - 1) 
                                      + findMaxProfitNaive(arr, j + 1, end);
                    profit = Math.max(profit, curr_profit);
                }
            }
        }
        return profit;
    }
    static int findMaxProfitEfficient(int[] arr) {
        /*
        The ides is simple:
        initialize profit to 0
        Start scan from left if the stock is monotonically increasing then add to curr profit
            else don't do anything
        */
        int profit = 0;
        for(int i = 1; i < arr.length; i++) {
            if(arr[i] > arr[i - 1]) {
                profit += arr[i] - arr[i - 1];
            }
        }
        return profit;
    }
}
