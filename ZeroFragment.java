import java.util.*;

public class ZeroFragment {
	public int count(int[] A) {
		int c = 0;
		int l = A.length;
		int sum = 0;
		
		Map<Integer, Integer> map = new HashMap<>();//sum, count
		map.put(0, 1);
		for(int i = 0; i < l;i++) {
			sum+=A[i];
			if(map.containsKey(sum)) {
				if(c + map.get(sum) > Math.pow(10, 9))
					return -1;
				c+=map.get(sum);
			}
			map.put(sum, map.getOrDefault(sum, 0)+1);
		}
		return c;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ZeroFragment t = new ZeroFragment();
		int[] a1 = {2,-2,3,0,4,-7};
		int[] a2 = new int[100000];
		for(int i = 0; i < 100000; i++) {
			a2[i] = 0;
		}
		System.out.print(t.count(a2));
	}

}
