
public class FirstBadVersion {
	public static int findFirstBadVersion(boolean[] version) {
		int lo = 0, hi = version.length-1;
		while(lo < hi) {
			int mid = lo + (hi - lo)/2;
			if(version[mid])
				lo = mid + 1;
			else
				hi = mid;
		}
		return lo;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		boolean[] version = {true, false, false, false};
	
		System.out.printf("%d", findFirstBadVersion(version));
	}

}
