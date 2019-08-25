import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class SpiralOrderMatrix {
	
	
	/**
     * 运用埃拉托色筛选法筛选出所有小于等于n的质数
     */
    public static boolean[] sieveOfEratosthenes(int n) {
        boolean[] isPrime = new boolean[n + 1];
        //初始化，默认所有都是质数
        for (int i = 0; i <= n; i++) {
            isPrime[i] = true;
        }
        isPrime[0] = false;
        isPrime[1] = false;
        //筛选，将所有质数的倍数都标记为非质数(最初只知道2是质数)
        for (int i = 2; i <= n / i; i++) {
            if (isPrime[i]) {
                for (int j = 2; j <= n/i; j++) {
                    isPrime[i * j] = false;
                }
            }
        }
        return isPrime;
    }
    
	//hashset build all prime 10^6
	//include 10^6
	public static Set<Integer> buildPrime(int n){
		Set<Integer> primeSet = new HashSet<>();
		
		int[] primeNums = new int[n/2+1];
		int sqrtroot;
		int cursor = 0;
		boolean isPrime;
		
		for(int i = 2; i <=n; i++) {
			sqrtroot = (int)Math.sqrt(i);
			isPrime = true;
			for(int j = 0; j < cursor; j++) {
				if(primeNums[j] > sqrtroot)
					break;
				if(i%primeNums[j] == 0) {
					isPrime = false;
					break;
				}
					
			}
			if(isPrime)
				primeNums[cursor++] = i;
			
		}
		for(int i = 0 ; i < cursor; i++) {
			primeSet.add(primeNums[i]);
		}
		return primeSet;	
	}
	
	public static List<Integer> spiralOrderMatrix_BuildPrime(int[][] matrix) {
		ArrayList<Integer> ans = new ArrayList<>();
		if(matrix == null || matrix.length == 0||matrix[0].length == 0) return ans;
		
		int k = 0;
		for(int i = 0; i < matrix.length * matrix[0].length;) {
			int c = k, r = k;
			if(c>=matrix[0].length - k) break;
			while(c<matrix[0].length - k){
				int tmp = matrix[k][c++];
				if(isPrime(tmp))
					ans.add(tmp);i++;
					}
			c--; r++;
			if(r>=matrix.length - k) break;
				while(r < matrix.length - k) {
					int tmp = matrix[r++][c];
					if(isPrime(tmp))ans.add(tmp);i++;}
			c--;r--;
			if(c< k) break;
				while(c>=k) {
					int tmp =matrix[r][c--];
					if(isPrime(tmp)) ans.add(tmp);i++;}
				r--;c++;
			if(r<=k) break;
				while(r>k) {
					int tmp = matrix[r--][c];
					if(isPrime(tmp)) ans.add(tmp);i++;}
				k++;
			}
		
		
		return ans;
		
	}
	
	
	static int[] res;
	
	public static boolean isPrime(int num) {
		int start = 0, end = res.length-1;
		while(start <=end) {
			int mid = start + (end - start)/2;
			if(res[mid] == num)
				return true;
			else if(res[mid] < num) {
				start = mid + 1;
			}else
				end = mid - 1;
		}
		return false;
	}
	
	public static boolean isPrimeSqrt(int n) {
		if (n < 2) {
            return false;
        }
		if(n == 2 || n ==3) return true;
		if(n%2 == 0) return false;
		if(n%6!=1 && n%6!=5) return false;
        int squareRoot=1;
        while(squareRoot*squareRoot<n){
            squareRoot++;
        }
        for (int i = 2; i  <= squareRoot; i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
	}
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] test = {{2,3,5},{7,8,9},{11,13,17}};
		Set<Integer> set =  buildPrime(20);
		for(int e: set)
			System.out.print(e+" ");
		System.out.println(" ");
		boolean[] re = sieveOfEratosthenes(20);
		for(int i = 0; i < re.length; i++) {
			if(re[i]) System.out.print(i+" ");
		}
	}

}
