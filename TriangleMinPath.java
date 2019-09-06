import java.util.List;

public class TriangleMinPath {
	public int minimumTotal(List<List<Integer>> triangle) {
		int[] dp = new int[triangle.get(triangle.size() - 1).size()];
		dp[0] = triangle.get(0).get(0);
		for (int row = 1; row < triangle.size(); row++) {
			for (int i = triangle.get(row).size() - 1; i >= 0; i--) {
				long lastPre = (i - 1 < 0) ? Integer.MAX_VALUE : dp[i - 1];
				long samePre = (i > triangle.get(row - 1).size() - 1) ? Integer.MAX_VALUE : dp[i];
				dp[i] = (int) Math.min(lastPre, samePre) + triangle.get(row).get(i);
			}
		}
		int min = dp[0];
		for (int i = 1; i < dp.length; i++) {
			min = Math.min(min, dp[i]);
		}
		return min;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
