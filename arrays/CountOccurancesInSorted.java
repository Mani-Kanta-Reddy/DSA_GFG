package arrays;
import java.util.Arrays;

import utils.FastReader;

public class CountOccurancesInSorted {
	public static void main(String[] args) {
		FastReader sc = new FastReader();
		int[] arr = Arrays.stream(sc.nextLine().split("\\s"))
						  .map(Integer::parseInt)
						  .mapToInt(Integer::valueOf)
						  .toArray();
		final int target = sc.nextInt();
		System.out.println(countOccurancesInSorted(arr, target));
		System.out.println(countOccurancesUsingBinarySearch(arr, target));
	}
	static int countOccurancesUsingBinarySearch(int[] arr, int target) {
		/*
		The idea is to find firstOccurance & lastOccurance and do lastIdx - firstIdx + 1
		*/
		int firstIdx = findFirstOccurance(arr, target);
		int lastIdx = findLastOccurance(arr, target);
		return (lastIdx != -1) && (firstIdx != -1) ? lastIdx - firstIdx + 1 : -1;
	}
	static int findFirstOccurance(int[] arr, int target) {
		int start = 0; 
		int end = arr.length - 1;

		while(start <= end) {
			int mid = (start + end) / 2;
			if(target < arr[mid])
				end = mid - 1;
			else if(target > arr[mid])
				start = mid + 1;
			else {
				//which means target == mid now we've to check is this firstOccurance
				if(mid == 0 || arr[mid - 1] != arr[mid])
					return mid;
				end = mid - 1;
			}
		}
		return -1;
	}
	static int findLastOccurance(int[] arr, int target) {
		int start = 0;
		int end = arr.length - 1;

		while(start <= end) {
			int mid = (start + end) / 2;
			if(target < arr[mid])
				end = mid - 1;
			else if(target > arr[mid])
				start = mid + 1;
			else {
				//which means target == arr[mid] we've to check is this the last occurance
				if(mid == arr.length - 1 || arr[mid + 1] != arr[mid])
					return mid;
				start = mid + 1;
			}
		}
		return -1;
	}
	static int countOccurancesInSorted(int[] arr, int target) {
		int count = 0;
		for(int i = 0; i < arr.length - 1; i++) {
			if(arr[i] == target)
				count++;
		}
		return count;
	}
}