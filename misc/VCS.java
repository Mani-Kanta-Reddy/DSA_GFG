package misc;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class VCS
{
    public static void main(String[] args) throws Exception{
        Scanner sc = new Scanner(System.in);
        int noOfTestCases = sc.nextInt();
        while(noOfTestCases-- > 0) {
            //read N, M, K
            int noOfSourceFiles = sc.nextInt();
            int noOfUntracked = sc.nextInt();
            int noOfTracked = sc.nextInt();

            Set<Integer> untracked = new HashSet<>();
            Set<Integer> tracked = new HashSet<>();

            List<Integer> allFiles = new ArrayList<>();

            for(int i = 0; i < noOfUntracked; i++) {
                int curr = sc.nextInt();
                untracked.add(curr);
                allFiles.add(curr);
            }
            for(int i = 0; i < noOfTracked; i++) {
                int curr = sc.nextInt();
                tracked.add(curr);
                allFiles.add(curr);
            }

            solve(untracked, tracked, allFiles, noOfSourceFiles);
        }
    }
    static void solve(Set<Integer> untrackedSet, Set<Integer> trackedSet, List<Integer> allFiles, int noOfSourceFiles) {
        Set<Integer> temp = new HashSet<>(untrackedSet);
        temp.retainAll(trackedSet);
        System.out.printf("%d ", temp.size());
        //find the noOf missing numbers from all Files
        int untrackedAndUnIgnored = 0;
        for(int i = 1; i <= noOfSourceFiles; i++) {
            if(!allFiles.contains(i))
                untrackedAndUnIgnored++;
        }
        System.out.printf("%d \n", untrackedAndUnIgnored);
    }
}
