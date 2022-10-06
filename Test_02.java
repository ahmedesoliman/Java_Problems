class Test_02 {

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