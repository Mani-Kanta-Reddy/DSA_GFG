import java.util.*;
import java.io.*;

public class FindSecondLargest {
	public static void main(String[]args) {
		FastReader sc = new FastReader();
		int[] arr = Arrays.stream(sc.nextLine().split("\\s"))
					.map(Integer::new)
					.mapToInt(Integer::valueOf)
					.toArray();
		System.out.println(naiveFindSecondLargest(arr)); //O(n ^ 2)	
		System.out.println(efficientFindSecondLargest(arr));	
	}
	static int naiveFindSecondLargest(int[] arr) {
		//Find the firstLargest in the first scan:
		int idxOfFirstLargest = findIdxOfFirstLargest(arr);
		//In the second scan find the largest by not including the first largest:
		int idxOfSecondLargest = -1; //if there is no second largest (all elements of the array are same return -1)
		for(int i = 0; i < arr.length; i++) {
			if(arr[i] != arr[idxOfFirstLargest]) {
				if(idxOfSecondLargest == -1) 
					idxOfSecondLargest = i;
				if(arr[i] > arr[idxOfSecondLargest]) {
					idxOfSecondLargest = i;
				}
			}
		}		
		return idxOfSecondLargest;
	}
	static int findIdxOfFirstLargest(int[] arr) {
		int idxOfFirstLargest = 0; //assume first element is the largest and start:
		for(int i = 1; i < arr.length; i++) {
			if(arr[i] > arr[idxOfFirstLargest]) {
				idxOfFirstLargest = i;
			}
		}
		return idxOfFirstLargest;
	}
	static int efficientFindSecondLargest(int[] arr) {
		/*
		arr[i] > arr[idxOfFirstLargest] => idxOfSecondLargest = idxOfFirstLargest; idxOfFirstLargest = i;
		arr[i] == arr[idxOfFirstLargest] => Ignore
		arr[i] < arr[idxOfFirstLargest]
			| res == -1 => res = i;
			| arr[i] == arr[idxOfSecondLargest] => Ignore
			| arr[i] > arr[idxOfSecondLargest] => idxOfSecondLargest = i;
		*/
		int idxOfFirstLargest, idxOfSecondLargest;
		idxOfFirstLargest = 0;
		idxOfSecondLargest = -1; //corner-case if all the elements are equal
		//Start scanning the array:
		for(int i = 1; i < arr.length; i++) {
			if(arr[i] > arr[idxOfFirstLargest]) {
				idxOfSecondLargest = idxOfFirstLargest;
				idxOfFirstLargest = i;
			} else if(arr[i] != arr[idxOfFirstLargest]){
				if(idxOfSecondLargest == -1 || arr[i] > arr[idxOfSecondLargest]) 
					idxOfSecondLargest = i;	
			}
		}
		return idxOfSecondLargest;
	}
}