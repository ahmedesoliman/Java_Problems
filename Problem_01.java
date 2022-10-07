/**
 * 658. Find K Closest Elements

Given a sorted integer array arr, two integers k and x, return the k closest integers to x in the array. The result should also be sorted in ascending order.

An integer a is closer to x than an integer b if:

|a - x| < |b - x|, or
|a - x| == |b - x| and a < b
 

Example 1:

Input: arr = [1,2,3,4,5], k = 4, x = 3
Output: [1,2,3,4]
Example 2:

Input: arr = [1,2,3,4,5], k = 4, x = -1
Output: [1,2,3,4]
 

Constraints:

1 <= k <= arr.length
1 <= arr.length <= 104
arr is sorted in ascending order.
-104 <= arr[i], x <= 10^4
 */

// import java.lang.Math;
import java.util.ArrayList;
// import java.util.Collections;
import java.util.List;

public class Problem_01 {

    public static List<Integer> findClosestElements(int[] arr, int k, int x) {

        int left = 0, right = arr.length - k - 1;

        while (left <= right) { // binary search // O(log(n-k))

            int mid = left + (right - left) / 2; // mid point // O(1)

            if (x - arr[mid] > arr[mid + k] - x) { // if x is closer to arr[mid + k] // O(1)
                left = mid + 1; // move left to mid + 1 // O(1)

            } else { // if x is closer to arr[mid] // O(1)
                right = mid - 1; // mid is the rightmost element that is still in the range // O(1)
            }
        }
        List<Integer> ans = new ArrayList<>(); // O(1)
        for (int i = 0; i < k; i++) { // O(k)
            ans.add(arr[left + i]); // O(1)
        }
        return ans; // O(1)
    }

    static public void main(String[] args) {
        int[] arr1 = new int[] { 1, 2, 3, 4, 5, 7, 8 };
        int k1 = 4;
        int x1 = 3;
        List<Integer> returned1 = findClosestElements(arr1, k1, x1);

        System.out.println("Output should be [3,4,5,6] : " + returned1);

        int[] arr2 = new int[] { 1, 2, 3, 4, 5 };
        int k2 = 4;
        int x2 = 3;
        List<Integer> returned2 = findClosestElements(arr2, k2, x2);
        System.out.println("Output should be [1,2,3,4] : " + returned2);
    }
}
