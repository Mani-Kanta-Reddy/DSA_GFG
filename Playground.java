import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Stream;

public class Playground {
    static void printDecreasing(int n) {
        //base-case:
        if(n == 0) {
            return;
        }
        //recurisive -case:
        System.out.println(n);
        printDecreasing(n - 1);

    }

    static void printIncreasing(int n) {
        if(n == 0) 
            return;
        //recursive -case
        printIncreasing(n - 1);
        System.out.println(n);
    }

    static int powerLinear(int x, int n) {
        //base-case
        if(n == 1) 
            return x;
        //recursive -case
        int currProduct = powerLinear(x, n - 1) * x;
        return currProduct;
    }

    static int factorial(int n) {
        //base-case
        if(n == 0)
            return 1;
        //recursive-case:
        return n * factorial(n - 1);
    }

    static int fibonacci(int n) {
        //base-case
        if(n <= 1) {
            return n;
        }
        //recursive-case
        //pre-order
        int fibn1 = fibonacci(n - 1);   //leftcall
        //in-order
        int fibn2 = fibonacci(n - 2);   //rightcall
        //post-order
        return fibn1 + fibn2;
    }

    static void printZigZag(int n) {
        //base-case
        if(n == 0) {
            return;
        }

        //recursive-case:
        System.out.println("Pre -> " + (n));
        printZigZag(n - 1);
        System.out.println("In -> " + (n));
        printZigZag(n - 1);
        System.out.println("Post -> " + (n));
    }

    static boolean isPalindrome(String str, int start , int end) {
        if(start >= end) {
            return true;
        }

        //recursive-case:
        return isPalindrome(str, start + 1, end - 1) && str.charAt(start) == str.charAt(end);
    }

    static void toh(int n, String source, String dest, String temp) {
        //base-case:
        if(n == 0) {
            return;
        }

        //recursive -case:
        toh(n - 1, source, temp, dest);
        System.out.println("Move " + n + source + dest);
        toh(n - 1, temp, dest, source);
    }
    static void printArr(int[] arr, int idx) {
        //base-case:
        if(idx == arr.length) {
            return;
        }
        //recursive -case:
        System.out.println(arr[idx]);
        printArr(arr, idx + 1);
    }

    static void printDecArr(int[] arr, int idx) {
        //base-case:
        if(idx == arr.length)
            return;
        //recursive -case:
        printDecArr(arr,  idx + 1);
        System.out.println(arr[idx]);
    }
    static int findFirstOccurance(int[] arr, int idx, int target) {
        //base -case:
        if(idx == arr.length)
            return -1;

        //recursive-case:
        if(arr[idx] == target) {
            return idx;
        } else {
            return findFirstOccurance(arr, idx + 1, target);
        }
    }

    static int findLastOccurance(int[] arr, int idx, int target) {
        //base -case:
        if(idx == arr.length)
            return -1;
        //recursive  -case:
        int fisa = findLastOccurance(arr,  idx + 1, target);
        if(fisa == -1) {
            if(arr[idx] == target) {
                return idx;
            } else {
                return -1;
            }
        } else {
            return fisa;
        }
    }
    static int findMax(int[] arr, int idx) {
        //base-case:
        if(idx == arr.length - 1) {
            return arr[idx];
        }
        //recursive -case:
        int soFarMax = findMax(arr, idx + 1);
        if(soFarMax > arr[idx]) {
            return soFarMax;
        } else {
            return arr[idx];
        }
    }

    static int findMin(int[] arr, int idx) {
        //base -case:
        if(idx == arr.length - 1)
            return arr[idx];
        //recursive-case:
        int soFarMin = findMin(arr, idx + 1);
        if(soFarMin < arr[idx])     //guard-clause
            return soFarMin;
        else 
            return arr[idx];
    }
    static int binSearchIterative(int[] arr, int target) {
        int start = 0;
        int end = arr.length - 1;

        while(start <= end) {
            //first calc mid
            int mid = (start + end) / 2;

            //check
            if(target == arr[mid])
                return mid;
            else if(target < arr[mid])
                end = mid - 1;
            else
                start = mid + 1;
        }
        return -1;
    }

    static int binSearchRecursive(int[] arr, int start, int end, int target) {
        int mid = (start + end) / 2;
        //base-case:
        if(start >= end)
            return -1;
        //recursive-case:
        if(target < arr[mid])
            return binSearchRecursive(arr, start, mid - 1, target);
        else if(target > arr[mid])
            return binSearchRecursive(arr, mid + 1, end, target);
        else
            return mid;
    }
    static List<String> getSubsequences(String str) {
        //base-case:
        if(str.length() == 0) {
            List<String> res = new ArrayList<> ();
            res.add("");    
            return res;
        }

        //recursive-case:
        char ch = str.charAt(0);
        String ss = str.substring(1);
        List<String> temp = getSubsequences(ss);
        List<String> finalRes = new ArrayList<>();
        for(String s : temp) {
            finalRes.add(ch + s);
        }
        for(String s: temp) {
            finalRes.add("" + s);
        }
        return finalRes;
    }

    static List<String> getStairPaths(int n) {
        //base-case:
        //positive - case:
        if(n == 0) {
            List<String> baseRes = new ArrayList<>();
            baseRes.add("");
            return baseRes;
        }
        //negative -case:
        if(n < 0) {
            List<String> negativeRes = new ArrayList<>();
            return negativeRes;
        }
        //recursive-case:
        List<String> finalRes = new ArrayList<>();
        List<String> paths1 = getStairPaths(n - 1);
        List<String> paths2 = getStairPaths(n - 2);
        List<String> paths3 = getStairPaths(n - 3);
        for(String p1 : paths1) {
            finalRes.add("1" + p1);
        }
        for(String p2 : paths2) {
            finalRes.add("2" + p2);
        }
        for(String p3: paths3) {
            finalRes.add("3" + p3);
        }
        return finalRes;
    }
    static List<String> getMazePaths(int sr, int sc, int dr, int dc) {
        //base-case:
        //postive -case:
        if(sr == dr && sc == dc) {
            List<String> baseRes = new ArrayList<>();
            baseRes.add("");
            return baseRes;
        }
        //negative-case:
        if(sc > dc || sr > dr) {
            return new ArrayList<>();
        }
        //recursive-case:
        List<String> paths = new ArrayList<>();
        List<String> hpaths = getMazePaths(sr, sc + 1, dr, dc);
        List<String> vpaths = getMazePaths(sr + 1, sc, dr, dc);
        for(String h1: hpaths) {
            paths.add("h" + h1);
        }
        for(String v1 : vpaths) {
            paths.add("v" + v1);
        }
        return paths;
    }
    static List<String> getMazePathsWithDiag(int sr, int sc, int dr, int dc) {
        //base-case:
        //positiv-case:
        if(sr == dr && sc == dc) {
            List<String> baseRes = new ArrayList<>();
            baseRes.add("");
            return baseRes;
        }
        //negative-case:
        if(sr > dr || sc > dc) {
            return new ArrayList<>();
        }
        //recursive -case:
        List<String> hpaths = getMazePathsWithDiag(sr, sc + 1, dr, dc);
        List<String> vpaths = getMazePathsWithDiag(sr + 1, sc, dr, dc);
        List<String> dpaths = getMazePathsWithDiag(sr + 1, sc + 1, dr, dc);
        List<String> paths = new ArrayList<>();
        for(String h1 : hpaths) {
            paths.add("h" + h1);
        }
        for(String v1 : vpaths) {
            paths.add("v" + v1);
        }
        for(String d1 : dpaths) {
            paths.add("d" + d1);
        }
        return paths;
    }
    static List<String> getMazePathsSP(int sr, int sc, int dr, int dc) {
        //base-case:    
        //positive-case
        if(sr == dr && sc == dc) {
            return Arrays.asList("");
        }

        //negative-case:
        if(sr > dr || sc > dc) {
            return new ArrayList<>();
        }

        //recursive-case:
        List<String> finalRes = new ArrayList<>();
        for(int i = 1; i < dc; i++) {
            List<String> hpaths = getMazePathsSP(sr, sc + i, dr, dc);
            for(String h : hpaths) {
                finalRes.add("h" + i + h);
            }
        }
        for(int k = 1; k < dc && k < dr; k++) {
            List<String> dpaths = getMazePathsSP(sr + k, sc + k, dr, dc);
            for(String d : dpaths) {
                finalRes.add("d" + k + d);
            }
        }
        for(int j = 1; j < dr; j++) {
            List<String> vpaths = getMazePathsSP(sr + j, sc, dr, dc);
            for(String v : vpaths) {
                finalRes.add("v" + j + v);
            }
        }
        return finalRes;

    }
    
    public static void main(String[] args) throws IOException{
        // printDecreasing(9);
        // printIncreasing(9);
        // System.out.println(powerLinear(2, 8));
        // System.out.println(factorial(5));
        // System.out.println(fibonacci(7));x
        // printZigZag(2);
        // System.out.println(isPalindrome("father", 0, "father".length() - 1));

        // toh(2, "A", "B", "C");
        // printArr(new int [] {0, 4, 5, 6}, 0);
        // int[] myArr = new int[] {0, 4, 5, 6};
        // printDecArr(myArr, myArr.length);
        // printDecArr(myArr, 0);
        // int[] arr = {9, 7, 3, 10, 3};
        // Arrays.sort(arr);
        // System.out.println(findFirstOccurance(arr, 0, 3));
        // System.out.println(findLastOccurance(arr, 0, 3));
        // System.out.println(findMax(arr, 0));
        // System.out.println(findMin(arr, 0));
        // System.out.println(binSearchIterative(arr, 1));
        // System.out.println(binSearchRecursive(arr, 0, arr.length - 1, 0));
        // System.out.println(getSubsequences("abc"));
        // System.out.println(getKPC());
        // System.out.println(getStairPaths(5));
        // System.out.println(getMazePaths(1, 1, 3, 3));
        // System.out.println(getMazePathsWithDiag(1, 1, 3, 3));
        // System.out.println(getMazePathsSP(1, 1, 3, 3));

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testCases = Integer.parseInt(br.readLine());
        BigInteger[] arr = new BigInteger[testCases];
        for(int i = 0; i < testCases; i++) {
            arr[i] = new BigInteger(br.readLine());
        }
        for(BigInteger currValue : arr) {
            BigInteger temp = new BigInteger(currValue.toString());
            BigInteger sum = BigInteger.ZERO;
            while(!temp.equals(BigInteger.ZERO)) {
                BigInteger digit = temp.mod(BigInteger.TEN);
                sum = sum.add(digit);
                temp = temp.divide(BigInteger.TEN);
            }
            if(currValue.mod(sum).equals(BigInteger.ZERO)) {
                System.out.println("Yes");
            } else {
                System.out.println("No");
            }
        }
        
    }
}



