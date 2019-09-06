import java.util.ArrayList;

public class KeyWord {
	final String[] code = {"", "abc", "def", "ghi", "jkl","mno","pqr", "stu", "vwx", "yz"};
	public ArrayList<String> keyword(String str){
		ArrayList<String> ls = new ArrayList<>();
		if(str.length() == 0) {
			ls.add("");
			return ls;
		}
		char c = str.charAt(0);
		String resStr = str.substring(1);
		ArrayList<String> prevRes = keyword(resStr);
		String code = this.code[c - '0'];
		for(String val : prevRes) {
			for(int i = 0; i < code.length(); i++) {
				ls.add(code.charAt(i) + val);
			}
		}
		return ls;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
