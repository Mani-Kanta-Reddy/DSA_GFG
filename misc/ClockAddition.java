package misc;

import utils.FastReader;

public class ClockAddition {
    public static void main(String[] args) {
        FastReader sc = new FastReader();
        final int givenHrs = sc.nextInt();
        final int givenMins = sc.nextInt();
        int hrsToAdd = sc.nextInt();
        int minsToAdd = sc.nextInt();

        int totalMins = givenMins + minsToAdd;
        if(totalMins >= 60) {
            hrsToAdd++;
            totalMins %= 60;
        }
        int outPutHrs = givenHrs + hrsToAdd;
        
        if(outPutHrs > 23)
            outPutHrs %= 24;

        System.out.printf("%d Hrs : %d Mins", outPutHrs, totalMins);
    }
}
