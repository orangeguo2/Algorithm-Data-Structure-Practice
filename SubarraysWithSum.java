import java.util.HashMap;
import java.util.Map;

public class SubarraysWithSum {
	 public int numSubarraysWithSum(int[] A, int S) {
			int allsum = 0;
			for(int x : A) allsum+=x;
			
		// indexes[i] = location of i-th one (1 indexed)
			int[] index = new int[allsum + 2];
			int indind = 0;
			index[indind++] = -1;
			for(int i = 0; i < A.length; i++)
				if(A[i] == 1)
					index[indind++] = i;
			index[indind] = A.length;
			
			int ans = 0;
			if(S == 0){
			for(int i = 0; i < index.length - 1; i++){
				// w: number of zeros between consecutive ones
			int w = index[i+1] - index[i] - 1;
			ans+=w * (w+1)/2; // because 递减数列求和
			
		}
		return ans;
		}
		for(int i = 1; i < index.length - S; i++){
			int j = i + S - 1;
			int left = index[i] - index[i - 1];
			int right = index[j + 1] - index[j];
			ans += left * right;
		}
		return ans;
		    }
		
	 public int numSubarraysWithSum2(int[] A, int S) {
	        int sum=0;
	        int total=0;
	        Map<Integer,Integer> presum = new HashMap<>();
	        for(int i=0;i< A.length;i++){
	            sum += A[i];  
	            if(sum == S) total += 1;
	            if(presum.containsKey(sum-S)) total += presum.get(sum-S);
	            System.out.println("i is "+ i + " total is "+ total);
	            if(!presum.containsKey(sum)) presum.put(sum,1);
	            else presum.put(sum,presum.get(sum)+1);
	        }
	        return total;
	    }
	 
	 public int numSubarrayWithSum3(int[] A, int S){
			int iLo = 0, iHi = 0;
			int sumLo = 0, sumHi = 0;
			int ans = 0;
			for(int j = 0; j < A.length; j++){
			// While sumLo is too big, iLo++
		sumLo +=A[j];
			while(iLo < j && sumLo > S)
				sumLo -=A[iLo++];
			sumHi +=A[j];
			
			// While sumHi is too big, or equal and we can move, iHi++
			while(iHi < j && (sumHi > S || sumHi == S && A[iHi] == 0))
				sumHi -= A[iHi++];
			if(sumLo == S)
				ans += iHi - iLo + 1;
		}
		return ans;
		}


	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
