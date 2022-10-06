import java.util.*;

public class Test_05 {
    public static int solution(int[] segments) {

        int sizeOfArr = segments.length;

        // if the array is empty, return 0 as the answer
        // a rectangle cannot be formed with no segments
        // a rectangle needs at least 4 segments to be formed
        if (sizeOfArr < 4) {
            return -1;
        }

        // We count the number of segments of each length.
        Map<Integer, Integer> countsMap = new HashMap<Integer, Integer>();

   
        for (int i = 0; i < segments.length; i++) { // O(n)
            countsMap.put(segments[i], countsMap.getOrDefault(segments[i], 0) + 1); // O(logn)
        }

        System.err.println(Arrays.asList(countsMap));

        // If count of any length is >= 4, then the minimum difference is 0, as a
        // rectangle can be constructed using same-length segments. Return 0. (This is the base case) 
        for (int key : countsMap.keySet()) {
            if (countsMap.get(key) >= 4) {
                return 0;
            }
        }

        // or else we do Remove all entries with counts less than 2. We do this because we need at least 2 segments of each length to form a rectangle.
        Set<Integer> keysToRemove = new HashSet<Integer>(); // O(1)
        for (int key : countsMap.keySet()) { // O(n)
            if (countsMap.get(key) < 2) { // if the count of the higher entry is 1
                keysToRemove.add(key); // O(logn)
            }
        }

        // remove all keys with counts less than 2
        for (int key : keysToRemove) { // O(n)
            countsMap.remove(key); // O(logn)
        } 

        // Sort all the keys. (This is the key to the solution)
        Object[] keys = countsMap.keySet().toArray(); // O(n)
        Arrays.sort(keys); // O(nlogn)

        System.out.println(Arrays.toString(keys)); 

        // Return the difference of last 2 elements (if size is >= 2).
        if (keys.length < 2) { // if there are less than 2 keys, return -1
            return -1;
        }
        return ((int) keys[keys.length - 1] - (int) keys[keys.length - 2]);
    }

    public static void main(String[] args) {

        int[] segments = new int[] { 2, 2, 2, 2, 2 };

        System.out.println("Result should be zero: " + solution(segments));
    }
}
