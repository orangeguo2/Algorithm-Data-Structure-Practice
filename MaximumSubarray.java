
public class MaximumSubarray {
	public int maxSubArrayOn(int[] nums) {
        if(nums == null || nums.length == 0) return 0;
        int n = nums.length;
        int currSum = nums[0], maxSum = nums[0];
        for(int i = 1; i < n; i++){
            currSum = Math.max(nums[i], currSum + nums[i]);
            maxSum = Math.max(maxSum, currSum);
            
        }
        return maxSum;
    }
	 public int crossSum(int[] nums, int left, int right, int p){
	        if(left == right) return nums[left];
	        
	        int leftSubSum = Integer.MIN_VALUE;
	        int currSum = 0;
	        for(int i = p; i > left - 1; i--){
	            currSum+=nums[i];
	            leftSubSum = Math.max(leftSubSum, currSum);
	        }
	        int rightSubSum = Integer.MIN_VALUE;
	        currSum = 0;
	        for(int i = p+1; i<right +1; i++){
	            currSum+=nums[i];
	            rightSubSum = Math.max(rightSubSum, currSum);
	        }
	        return leftSubSum + rightSubSum;
	    }
	    public int helper(int[] nums, int left, int right){
	        if(left == right) return nums[left];
	        int p = (left + right)/2;
	        int leftSum = helper(nums,left, p);
	        int rightSum = helper(nums,p+1,right);
	        int crossSum = crossSum(nums, left, right, p);
	        return Math.max(Math.max(leftSum, rightSum), crossSum);
	    }
	    
	    public int maxSubArrayDevidedConquer(int[] nums){
	        return helper(nums, 0, nums.length - 1);
	    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
