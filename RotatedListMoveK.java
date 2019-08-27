import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RotatedListMoveK {
	/*
	 * 
	 * Given a sorted list of numbers which 
	 * has had some k numbers moved from the 
	 * front of the list to the end of the list, 
	 * write a program to find k (in O(log n) time)  
	 * */
	
	  public static int[] search(int[] num) {
			int start = 0, end = num.length - 1;
			int p = -1;
			while(start <= end){
				int mid = start + (end - start)/2;
				if(mid + 1 == num.length || num[mid] > num[mid + 1]) {
					p = mid + 1;
					break;
				}
						
				//if the first part is ordered
				if(num[start] <= num[mid]){
					start = mid + 1;
				}
				
				else{
					end = mid - 1;
				}
			}
			if(p == num.length) return new int[0];
			
			int[] res = new int[num.length - p];
			for(int i = p; i < num.length;i++) {
				res[i - p] = num[i];
			}

		
			return res;
	  }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] test = {2,2,3,4,1,2,2};
		test = search(test);
		if(test.length == 0) System.out.println("it is zero");
		for(int x : test)
			System.out.println(x);
	}

}
