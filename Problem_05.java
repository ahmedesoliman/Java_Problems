/**
 * There are some processes that need to be executed. Amount of a load that
 * process causes on a server that runs it, is being represented by a single
 * integer. Total load caused on a server is the sum of the loads of all the
 * processes that run on that server. You have at your disposal two servers, on
 * which mentioned processes can be run. Your goal is to distribute given
 * processes between those two servers in the way that, absolute difference of
 * their loads will be minimized.
 * 
 * 
 * 
 * Write a function that, given an array A of N integers, of which represents
 * loads caused by successive processes, the function should return the minimum
 * absolute difference of server loads.
 * 
 * 
 * 
 * For example, given array A such that:
 * 
 * A[0] = 1
 * 
 * A[1] = 2
 * 
 * A[2] = 3
 * 
 * A[3] = 4
 * 
 * A[4] = 5
 * 
 * 
 * 
 * your function should return 1. We can distribute the processes with loads 1,
 * 2, 4 to the first server and 3, 5 to the second one, so that their total
 * loads will be 7 and 8, respectively, and the difference of their loads will
 * be equal to 1.
 * 
 * 
 * 
 * Assume that:
 * 
 * N is an integer within the range [1..1,000]
 * 
 * the sum of the elements of array A does not exceed 100,000
 * 
 * 
 * In your solution, focus on correctness. The performance of your solution will
 * not be the focus of the assessment.
 * 
 * 
 */

class Problem_05 {

    static int solution(Integer[] loads) {
        // put your solution here
        System.err.println("Tip: Use System.err.println() to write debug messages on the output tab.");

        // first we need to compute the overall server load

        int totalLoad = 0;
        int numOfservers = loads.length;

        for (int i = 0; i < loads.length; i++) {
            totalLoad += loads[i];

        }

        // second we need to find the required load

        int requiredLoad = totalLoad / 2;

        int subproblems[][] = new int[numOfservers + 1][requiredLoad + 1];

        for (int i = 1; i < numOfservers + 1; i++) {

            for (int j = 1; j < requiredLoad + 1; j++) {

                // If i-th loads is included
                if (loads[i - 1] > j)
                    subproblems[i][j] = subproblems[i - 1][j];

                // If i-th loads is excluded
                else
                    subproblems[i][j] = Math.max(subproblems[i - 1][j],
                            loads[i - 1] +
                                    subproblems[i - 1][j - loads[i - 1]]);
            }

        }

        return totalLoad - 2 * subproblems[numOfservers][requiredLoad];
    }

    public static void main(String[] args) {

        Integer[] loads = new Integer[] { 2, 2, 2, 2, 2 };

        System.out.println("Result: " + solution(loads));
    }
    // public static void main(String[] args) {
    // Scanner in = new Scanner(System.in);
    // Integer[] loads = getIntegerArray(in.next());

    // System.out.print(solution(loads));
    // }

    // private static Integer[] getIntegerArray(String str) {
    // return Stream.of(str.split("\\,"))
    // .map(Integer::valueOf)
    // .toArray(Integer[]::new);
    // }
}