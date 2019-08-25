import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class SharePurchase {
	public static int sharePurchase(String s){
		int pair = 0;
		int len = s.length();
		Set<Character> set = new HashSet<>();
		set.add('A');
		set.add('B');
		set.add('C');
		
		int left = 0, right = 0;
		int form = 0;
		Map<Character,Integer> winmap = new HashMap<>();
		
		while(right < s.length()) {
			char c = s.charAt(right);
			
			if(!winmap.containsKey(c) && set.contains(c)) {
				form++;
				winmap.put(c,1);
			}else if(winmap.containsKey(c)) {
					winmap.put(c, winmap.get(c)+1);
			}
			
			while(form == 3 && left <= right) {
				pair+= len - right;
				char cleft = s.charAt(left);
				if(!winmap.containsKey(cleft)) {left++;continue;}
				if(winmap.get(cleft) == 1) {
					winmap.remove(cleft);
					form--;
				}else {
					winmap.put(cleft, winmap.get(cleft) - 1);
				}
				left++;
			}
				right++;
		
		}

		return pair;
	}
		
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(sharePurchase("ABBCZBAC"));
	}

}
