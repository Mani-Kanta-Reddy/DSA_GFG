package misc;

import java.util.Arrays;
import java.util.Comparator;

public class MinimumArrows
{
    public static void main(String[] args) {
        int[][] points = {
            {9,12}, {1,10}, {4,11}, {8,12}, {3,9}, {6,9}, {6,7}
        };
        System.out.println(findMinArrowShots(points));

    }
    public static int findMinArrowShots(int[][] points) {
        int n = points.length;
        //sort the points based on Xstart
        Arrays.sort(points, (a, b) -> {
            if(a[0] < b[0]) {
                return -1;
            } else if(a[0] == b[0]) {
                if(a[1] < b[1]) {
                    return -1;
                } else {
                    return 1;
                }
            } else {
                return 1;
            }
        });
        //find overlaps and increment the arrows count
        int arrowCount = 1;
        int xend = points[0][1];
        for(int[] arr: points) {
            if(arr[0] <= xend) {
                continue;
            } else {
                arrowCount++;
                xend = arr[1];
            }
        }
        return arrowCount;
    }
}
