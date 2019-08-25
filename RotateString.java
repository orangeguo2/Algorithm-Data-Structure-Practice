
public class RotateString {
	public static String rotateTheString(String ostr, int[] dir, int[] amt) {
		if(ostr == null || ostr.length() == 0) return ostr;
		long total = 0;//negative for left, positive for right;
		int len = ostr.length();
			
		//handle all dir & amt together first
		for(int i = 0; i < dir.length;i++) {
			if(dir[i] == 0)
				total-=amt[i];
			else
				total+=amt[i];
				
		}
		if(total < 0) {total%=len; total -= len;}
		total %=len;
		int move = (int)total;
		StringBuilder sb = new StringBuilder(ostr);
		sb.reverse();
		StringBuilder firstPart = new StringBuilder(sb.subSequence(0, move));
		StringBuilder secondPart = new StringBuilder(sb.subSequence(move,len));
		firstPart.reverse();
		secondPart.reverse();
		return firstPart.append(secondPart).toString();
		
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(rotateTheString("ab", new int[] {0,1,0}, new int[] {2,1,2}));
	}

}
