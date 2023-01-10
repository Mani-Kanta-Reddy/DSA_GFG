package misc;

import java.util.HashMap;
import java.util.Map;

public class MinimumRoundsToComplete
{
    public static void main(String[] args)
    {
        int[] tasks = {2,2,3,3,2,4,4,4,4,4};
        System.out.println(minimumRounds(tasks));
    }
    public static int minimumRounds(int[] tasks) {
        int res = 0;
        //first build the map to store the frequencies
        Map<Integer, Integer> freq = new HashMap<>();
        for(int task : tasks) {
            if(!freq.containsKey(task)) {
                freq.put(task, 1);
            } else {
                freq.put(task, freq.get(task) + 1);
            }
        }
        //first get as many as `3`s and then look for `2`s if you should left over with `1`
        //which indicates that particular task cant be completed
        for(int key: freq.keySet()) {
            int value = freq.get(key);
            int threes = value / 3;
            if(threes != 0) {
                value -= threes * 3;
                if(value == 2) {
                    res += threes;
                    value -= 2;
                    res++;
                } else if(value == 0) {
                    res += threes;
                } else {
                    //one scenario
                    value = freq.get(key) - (threes - 1) * 3;
                    res += threes - 1;
                }
            }
            if(value != 0) {
                // 1, 2, 4
                int twos = value / 2;
                if(twos != 0) {
                    value -= twos * 2;
                    res += twos;
                } else {
                    res = -1;
                    break;
                }
            }
        }
        return res;
    }
}
