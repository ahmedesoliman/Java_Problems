
/**
 * You are given an array A representing heights of students. All the students are asked to stand in rows. 
 * The students arrive by one, sequentially (as their heights appear in A). 
 * For the i-th student, if there is a row in which all the students are taller than A[i], the student will stand in one of such rows. 
 * If there is no such row, the student will create a new row. Your task is to find the minimum number of rows created.
 * Write a function that, given a non-empty array A containing N integers, denoting the heights of the students, returns the minimum number of rows created.
 * For example, given A = [5, 4, 3, 6, 1], the function should return 2.
 * Students will arrive in sequential order from A[0] to A[N−1]. So, the first student will have height = 5, the second student will have height = 4, and so on.
 * For the first student, there is no row, so the student will create a new row.
 * Row1 = [5]
 * For the second student, all the students in Row1 have height greater than 4. So, the student will stand in Row1.
 * Row1 = [5, 4]
 * Similarly, for the third student, all the students in Row1 have height greater than 3. So, the student will stand in Row1.
 * Row1 = [5, 4, 3]
 * For the fourth student, there is no row in which all the students have height greater than 6. So, the student will create a new row.
 * Row1 = [5, 4, 3]
 * Row2 = [6]
 * For the fifth student, all the students in Row1 and Row2 have height greater than 1. So, the student can stand in either of the two rows.
 * Row1 = [5, 4, 3, 1]
 * Row2 = [6]
 * Since two rows are created, the function should return 2.
 * 
 *  Assume that:
 * N is an integer within the range [1..1,000]
 * each element of array A is an integer within the range [1..10,000]
 * In your solution, focus on correctness. The performance of your solution will not be the focus of the assessment
 */

import java.util.*;

class Problem_04 {

  // Vector<Vector<Integer>> map = new Vector<Vector<Integer>>();

  // static int solution(Integer[] arr) {

  // // Your solution goes here
  // Vector<Integer> v = new Vector<Integer>();

  // for (int i = 0; i < arr.length; i++){
  // if (arr[i] > v.get(0)) {
  // v.add(arr[i]);
  // Collections.sort(v);
  // }

  // }
  // }

  static int solution(Integer[] A) {
    // Your solution goes here.
    TreeMap<Integer, Integer> map = new TreeMap<>(); // key: num, value: count

    for (int i = 0; i < A.length; i++) { // O(n)

      Map.Entry<Integer, Integer> higher = map.higherEntry(A[i]); // O(logn)

      if (higher == null) { // no higher entry
        map.put(A[i], map.getOrDefault(A[i], 0) + 1); // O(logn)
      } else { // there is a higher entry
        if (higher.getValue() == 1) { // if the count of the higher entry is 1
          map.remove(higher.getKey()); // O(logn)
        } else { // if the count of the higher entry is not 1
          map.put(higher.getKey(), higher.getValue() - 1); // O(logn)
        } // end if
        map.put(A[i], map.getOrDefault(A[i], 0) + 1); // O(logn)
      }
    }

    int rows = 0;
    for (int value : map.values()) {
      rows += value;
    }
    return rows;
  }

  public static void main(String[] args) {

    Integer[] A = new Integer[] { 5, 2, 3, 6, 1 };
    System.out.println(solution(A));
  }
}