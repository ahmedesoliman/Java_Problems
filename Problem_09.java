import java.util.*;

/**
 * Given an integer array nums, return all the triplets [nums[i], nums[right],
 * nums[left]] such that i != right, i != left, and right != left, and nums[i] + nums[right] +
 * nums[left] == 0.
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
        Arrays.sort(nums);
 
        ArrayList<List<Integer>> result = new ArrayList<>();
     
        for (int i = 0; i < nums.length; i++) {
            int right = i + 1;
            int left = nums.length - 1;
     
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
     
            while (right < left) {
                if (left < nums.length - 1 && nums[left] == nums[left + 1]) {
                    left--;
                    continue;
                }
     
                if (nums[i] + nums[right] + nums[left] > 0) {
                    left--;
                } else if (nums[i] + nums[right] + nums[left] < 0) {
                    right++;
                } else {
                    ArrayList<Integer> temp = new ArrayList<>();
                    temp.add(nums[i]);
                    temp.add(nums[right]);
                    temp.add(nums[left]);
                    result.add(temp);
                    right++;
                    left--;
                }
            }
        }
     
        return result;
    }

    public static void main(String[] args) {
        int[] nums = { -1, 0, 1, 2, -1, -4 };
        // threeSum(nums); // expected output = [[-1,-1,2],[-1,0,1]]
        System.out.println(threeSum(nums)); // expected output = [[-1,-1,2],[-1,0,1]]
    }

}
