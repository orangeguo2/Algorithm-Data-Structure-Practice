import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PermutationII {
	public static List<List<Integer>> permutationUni(int[] num) {
		List<List<Integer>> res = new ArrayList<>();
		boolean[] used = new boolean[num.length];
		if (num == null || num.length == 0)
			return res;
		Arrays.sort(num);
		dfs(res, num, used, new ArrayList<>());
		return res;
	}

	public static void dfs(List<List<Integer>> res, int[] num, boolean[] used, List<Integer> ls) {
		if (ls.size() == num.length) {
			res.add(new ArrayList<Integer>(ls));// must create new memory
			return;
		}
		for (int i = 0; i < num.length; i++) {
			if (used[i])
				continue;
			if (i > 0 && num[i] == num[i - 1] && !used[i - 1])
				continue;
			ls.add(num[i]);
			used[i] = true;
			dfs(res, num, used, ls);
			used[i] = false;
			ls.remove(ls.size() - 1);

		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = { 0, 6, 8, 3, 5 };

	}

}
