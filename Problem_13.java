
/**
 * Given an array of intervals intervals where intervals[i] = [starti, endi], return the minimum number of intervals you need to remove to make the rest of the intervals non-overlapping.

 

Example 1:

Input: intervals = [[1,2],[2,3],[3,4],[1,3]]
Output: 1
Explanation: [1,3] can be removed and the rest of the intervals are non-overlapping.
Example 2:

Input: intervals = [[1,2],[1,2],[1,2]]
Output: 2
Explanation: You need to remove two [1,2] to make the rest of the intervals non-overlapping.
Example 3:

Input: intervals = [[1,2],[2,3]]
Output: 0
Explanation: You don't need to remove any of the intervals since they're already non-overlapping.
*/

import java.util.*;

class Problem_13 {
    public int eraseOverlapIntervals(int[][] intervals) {

        Arrays.sort(intervals, (a, b) -> (a[0] - b[0]));
        int count = 0;
        // we start with the first interval
        int preEnd = intervals[0][1];
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] >= preEnd) {
                // if no overlap(start value of current >= end value of previous one), we just
                // update last interval to current one
                // because we know current one end value must greater than previous one
                preEnd = intervals[i][1];
            } else {
                // if overlap, we delete the one with larger end value
                count++;
                preEnd = Math.min(preEnd, intervals[i][1]);
            }
        }

        return count;
    }
}