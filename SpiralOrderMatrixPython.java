import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class SpiralOrderMatrixPython {
	
	/**
     * 运用埃拉托色筛选法筛选出所有小于等于n的质数
     */

    public static boolean[] buildPrime(int n) {
         boolean[] isPrime= new boolean[n + 1];
        //初始化，默认所有都是质数
        for (int i = 0; i <= n; i++) {
            isPrime[i] = true;
        }
        isPrime[0] = false;
        isPrime[1] = false;
        //筛选，将所有质数的倍数都标记为非质数(最初只知道2是质数)
        for (int i = 2; i * i < n; i++) {
            if (isPrime[i]) {
                for (int j = 2; i * j <= n; j++) {
                    isPrime[i * j] = false;
                }
            }
        }
        return isPrime;
    }

	public static List<Integer> spiralOrderMatrix_BuildPrime(int[][] matrix) {
		ArrayList<Integer> ans = new ArrayList<>();
		if(matrix == null || matrix.length == 0||matrix[0].length == 0) return ans;
		
		boolean[] isPrime = buildPrime((int)Math.pow(10,6));
		
		int k = 0;
		for(int i = 0; i < matrix.length * matrix[0].length;) {
			int c = k, r = k;
			if(c>=matrix[0].length - k) break;
			while(c<matrix[0].length - k){
				int tmp = matrix[k][c++];
				if(isPrime[tmp])
					ans.add(tmp);i++;
					}
			c--; r++;
			if(r>=matrix.length - k) break;
				while(r < matrix.length - k) {
					int tmp = matrix[r++][c];
					if(isPrime[tmp])ans.add(tmp);i++;}
			c--;r--;
			if(c< k) break;
				while(c>=k) {
					int tmp =matrix[r][c--];
					if(isPrime[tmp]) ans.add(tmp);i++;}
				r--;c++;
			if(r<=k) break;
				while(r>k) {
					int tmp = matrix[r--][c];
					if(isPrime[tmp]) ans.add(tmp);i++;}
				k++;
			}
		
		
		return ans;
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] test = {{2,3,5},{7,8,9},{11,13,17}};
		List<Integer> ls =  spiralOrderMatrix_BuildPrime(test);
		for(int e: ls)
			System.out.print(e+" ");
	}

}
