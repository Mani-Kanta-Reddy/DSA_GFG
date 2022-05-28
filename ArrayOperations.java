import java.util.*;
import java.io.*;

public class ArrayOperations {
	public static void main(String[] args) {
		int[] arr = new int[7];
		arr[0] = 1;
		arr[1] = 2;
		arr[2] = 4;
		arr[3] = 5; // arr = [1,2,4,5,_,_,_]
		System.out.println("Before Everything => " + Arrays.toString(arr));
		int pos = 3;
		int ele = 3;
		insertAtPos(arr, pos, ele);
		System.out.println("Inserted 3 at idx 3 -> " + Arrays.toString(arr));
		deleteAtPos(arr, pos);
		System.out.println("Deleted Elem at position " + pos + Arrays.toString(arr));
		ele = 5;
		deleteEle(arr, ele);
		System.out.println("Deleted Element: " + ele + Arrays.toString(arr));
	}
	static int[] insertAtPos(int[] arr, int pos, int ele) {
		//position starts form 1 unlike index which starts from 0
		int i = 0;
		for(i = arr.length - 1; i > pos - 1; i--) {
			arr[i] = arr[i - 1];
		}
		arr[i] = ele;
		return arr;
	}
	static int[] deleteAtPos(int[] arr, int pos) {
		//please note postion starts from 1 unline index which starts form 0
		for(int i = pos - 1; i < arr.length - 1; i++) {
			arr[i] = arr[i + 1];
		}
		return arr;
	}
	static int[] deleteEle(int[] arr, int ele) {
		//first find the idx of the first occurrance of this ele in the array:
		int i = 0;
		while(arr[i] != ele) {
			i++;
		}
		//now we got the idx of it's first occurrance time to delete
		for(int j = i; j < arr.length - 1; j++) {
			arr[j] = arr[j + 1];
		}
		return arr;
	}
}