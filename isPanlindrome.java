
public class isPanlindrome {
	public static boolean isPan(String s) {
		int start = 0, end = s.length() - 1;
		while(start < end) {
			if(s.charAt(start) != s.charAt(end))
				return false;
			start++;
			end--;
		}
		return true;
		
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
			System.out.println(isPan(""));
	}

}
