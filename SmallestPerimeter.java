import java.util.Arrays;
import java.util.Scanner;

public class SmallestPerimeter {
	public static int smallPer(int[] arr) {
		if(arr.length < 3) return -1;
		int min = Integer.MAX_VALUE;
		boolean changed = false;
		Arrays.sort(arr);
		for(int i = 2; i < arr.length; i++) {
			int smthird = findValid(i, arr);
			if(smthird != -1 && min >= smthird + arr[i] + arr[i - 1]) {
				min = smthird + arr[i] + arr[i - 1];
				changed = true;
			}
		}
		if(!changed) return -1;
		return min;
	}
	public static int findValid(int longidx, int[] arr) {
		int l = 0, r = longidx - 2;
		while(l<=r) {
			int mid = l + (r - l)/2;
			if(arr[mid] + arr[longidx - 1] <= arr[longidx]) {
				l = mid + 1;
			}else {
				r = mid - 1;
			}
		}
		if(l == longidx - 1) return -1;
		return arr[l];
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 int[] arr = {0,6,8,3,5};
		 System.out.println(smallPer(arr));
	}

}
