import java.util.*;

/**
 * Given an integer array nums, return all the triplets [nums[i], nums[j],
 * nums[k]] such that i != j, i != k, and j != k, and nums[i] + nums[j] +
 * nums[k] == 0.
 * 
 * Notice that the solution set must not contain duplicate triplets.
 * 
 * Example 1:
 * Input: nums = [-1,0,1,2,-1,-4]
 * Output: [[-1,-1,2],[-1,0,1]]
 * Explanation:
 * nums[0] + nums[1] + nums[2] = (-1) + 0 + 1 = 0.
 * nums[1] + nums[2] + nums[4] = 0 + 1 + (-1) = 0.
 * nums[0] + nums[3] + nums[4] = (-1) + 2 + (-1) = 0.
 * The distinct triplets are [-1,0,1] and [-1,-1,2].
 * Notice that the order of the output and the order of the triplets does not
 * matter.
 * 
 * Example 2:
 * Input: nums = [0,1,1]
 * Output: []
 * Explanation: The only possible triplet does not sum up to 0.
 * Example 3:
 * 
 * Input: nums = [0,0,0]
 * Output: [[0,0,0]]
 * Explanation: The only possible triplet sums up to 0.
 */

public class Problem_09 {

    public static List<List<Integer>> threeSum(int[] nums) {

        // TODO: Implement this method
        // we can't have duplicate triplets
        // Hint: Use two pointers to solve this problem
        // Hint: Sort the array first
        // Hint: Use a for loop to iterate through the array
        // Hint: Use a while loop to iterate through the array
        List<List<Integer>> result = new ArrayList<>();
        int[] resultArray;
        Arrays.sort(nums);

        for (int i = 0; i < nums.length; i++) {
            int left = i + 1;
            int right = nums.length - 1;
            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];
                if (sum == 0) {
                    resultArray = new int[] { nums[i], nums[left], nums[right] };
                    // System.out.println(Arrays.toString(resultArray));
                    left++;
                    right--;
                } else if (sum < 0) {
                    left++;
                } else {
                    right--;
                }

                result.add(Arrays.asList(nums[i], nums[left], nums[right]));
            }

            return result;
        }
    }

    public static void main(String[] args) {
        int[] nums = { -1, 0, 1, 2, -1, -4 };
        // threeSum(nums); // expected output = [[-1,-1,2],[-1,0,1]]
        System.out.println(threeSum(nums)); // expected output = [[-1,-1,2],[-1,0,1]]
    }

}
