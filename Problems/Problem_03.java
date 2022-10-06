package Problems;

/**
 * Given an integer array nums, return an array answer such that answer[i] is
 * equal to the product of all the elements of nums except nums[i].
 * The product of any prefix or suffix of nums is guaranteed to fit in a 32-bit
 * integer.
 * You must write an algorithm that runs in O(n) time and without using the
 * division operation.
 * Example 1:
 * Input: nums = [1,2,3,4]
 * Output: [24,12,8,6]
 * 
 * Example 2:
 * Input: nums = [-1,1,0,-3,3]
 * Output: [0,0,9,0,0]
 */
public class Problem_03 {
    public int[] productExceptSelf(int[] nums) {
        int[] result = new int[nums.length]; // create an array of the same size as the input array

        int prefix = 1; // initialize the prefix to 1
        for (int i = 0; i < nums.length; i++) { // loop through the array
            result[i] = prefix; // set the result at the current index to the prefix
            prefix *= nums[i]; // multiply the prefix by the current value in the array
        }
        
        int postfix = 1; // initialize the postfix to 1
        for (int i = nums.length; i > 0; i--) { // loop through the array backwards
            result[i - 1] *= postfix; // multiply the result at the current index by the postfix
            postfix *= nums[i - 1]; // multiply the postfix by the current value in the array
        }
        return result;

    }
}
