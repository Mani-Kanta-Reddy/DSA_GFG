package recursion;

import java.util.Arrays;
import utils.FastReader;

public class RopeCutting {
	public static void main(String[] args) {
		FastReader sc = new FastReader();
		/*
		You're given a rope of lenght 'l' and an array of int with which you can only cut the rope
		Now find the the max pieces you can make
		Eg: l = 17 and [11, 7, 9]
													17
									  /  			|  						\	
									 6   			10  					8
								   / | \	  	/  |  		\ 		   		/ | \
								  -5 -1	-3	 	-1  3   	 	1          -3 1 -1
											 	   / | \	   /  | \       / | \
											 	  -8 -4 -6   -10 -6 -8    -10 -6 -8

		*/
		Integer[] arr = Arrays.stream(sc.nextLine().split("\\s")).map(Integer::parseInt).toArray(Integer[]::new);
		int n = arr[0];
		int a = arr[1];
		int b = arr[2];
		int c = arr[3];

		System.out.println(findMaxCuts(n, a, b, c));
	}
	static int findMaxCuts(int n, int a, int b, int c) {
		//recursive sol:

		//base-case:
		if(n == 0) return 0;
		if(n < 0) return -1; 

		//recursive-case:
		int res = Math.max(findMaxCuts(n - a, a, b, c), Math.max(findMaxCuts(n - b, a, b, c), findMaxCuts(n - c, a, b, c)));

		if(res == -1) return -1;

		return res + 1;
	}
}