/**
 * The deadline of this assignment is 09/25/2020 23:59 PST.
 * Please feel free to contact Yafei and Yaqi for any questions.
 */

public class Assignment2_2 {
    /**
     * Given an integer array nums, find the contiguous subarray (containing at least one number)
     * which has the largest sum and outprint its sum.
     *
     * Example 1:
     * Input: nums = [-2,1,-3,4,-1,2,1,-5,4]
     * Output: 6
     * Explanation: [4,-1,2,1] has the largest sum = 6.
     *
     * Example 2:
     * Input: nums = [1]
     * Output: 1
     */
    public int maxSubArray(int[] nums) {
    	if(nums == null || nums.length == 0) {
    		return 0; // corner case
    	}
    	
        int maxsum = nums[0];
        int cursum = nums[0];
        for(int i = 1; i < nums.length; i++) {
        	cursum = Math.max(cursum + nums[i], nums[i]);
        	maxsum = Math.max(maxsum, cursum);
        }
        return maxsum;
        
    }

    public static void main(String[] args) {
        int[] nums = new int[]{-9, 2, -3, 6, -1, 3, -4}; 
        Assignment2_2 solution = new Assignment2_2();
        int result = solution.maxSubArray(nums);
        System.out.println(result);
    }
}