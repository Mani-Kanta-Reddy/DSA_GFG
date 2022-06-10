package arrays;
import java.util.*;

import utils.FastReader;

public class MoveZeroesToEnd {
	public static void main(String[] args) {
		FastReader sc = new FastReader();
		int[] arr = Arrays.stream(sc.nextLine().split("\\s"))
						  .map(Integer::parseInt)
						  .mapToInt(Integer::valueOf)
						  .toArray();
		//moveZeroesToEnd(arr);
		//System.out.println(Arrays.toString(arr));		
		// moveZeroesToEndOrderPreservedNaive(arr);
		moveZeroesToEndPreserveOrderEfficient(arr);
		System.out.println(Arrays.toString(arr));
	}
	static void moveZeroesToEnd(int[] arr) {
		//two pointer approach order not-maintained
		for(int i = 0, j = arr.length - 1; i < arr.length; i++) {
			if(arr[i] == 0 && arr[j] != 0) {
				int temp = arr[i];
				arr[i] = arr[j];
				arr[j] = temp;
				j--;
			}
		}
	}
	static void moveZeroesToEndOrderPreservedNaive(int[] arr) {
		//start scan from left if arr[i] is 0 then swap it with first non-zero ele after ith idx break
		for(int i = 0; i < arr.length; i++) {
			if(arr[i] == 0) {
				//find the first non-zero idx to i's right
				for(int j = i + 1; j < arr.length; j++) {
					if(arr[j] != 0) {
						swap(arr, i, j);
						break;
					}
				}			
			}
		}
	}
	static void swap(int[] arr, int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}
	static void moveZeroesToEndPreserveOrderEfficient(int[] arr) {
		/*
		The idea goes like this :
		if you've moved the zeroes to end in the first n - 1 elements and now you can
		decide on if the n'th element to move to end or not
		if n'th element is non-zero you move it a head else leave as is
		*/
		int pointer = 0;
		for(int i = 0; i < arr.length; i++) {
			if(arr[i] != 0) {
				swap(arr, i, pointer);
				pointer++;
			}
		}
	}
}