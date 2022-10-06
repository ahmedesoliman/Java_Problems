
import java.util.*;

class Test_01 {

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