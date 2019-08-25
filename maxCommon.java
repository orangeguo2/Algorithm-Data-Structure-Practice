import java.util.HashMap;
import java.util.Map;

public class maxCommon {
	public static int maxCommon(String s) {
		Map<Character, Integer> rightMap = new HashMap<>();//char, freq
		for(char c : s.toCharArray()) {
			rightMap.put(c, rightMap.getOrDefault(c, 0)+1);
		}
		
		int leftend = 0;
		int common = 0;
		int maxcom = 0;
		
		Map<Character, Integer> leftMap = new HashMap<>();//char, freq

		while(leftend < s.length()) {
			char c = s.charAt(leftend);
			if(leftMap.containsKey(c)) common-=Math.min(leftMap.get(c), rightMap.get(c));
			leftMap.put(c, leftMap.getOrDefault(c,0)+1);

			if(rightMap.get(c) == 1)
				rightMap.remove(c);
			else
				rightMap.put(c,rightMap.get(c)-1);
			if(rightMap.containsKey(c) && leftMap.containsKey(c))
				common+=Math.min(leftMap.get(c), rightMap.get(c));
			if(common > maxcom) {
				maxcom = common;
			}
			leftend++;
			
		}
		

		
		return maxcom;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(maxCommon("abcdecdefg"));
	}

}
