public class Test_04 {

    public static int solution(String S) {
        System.err.println("Tip: Use System.err.println() to write debug messages on the output tab.");
      
        // set last_char to 'c' (because the first character needs to be a)
        char last_char = 'c';

        // set current string index to 0
        int curr_index = 0;

        // set total_insertions to 0
        int total_insertions = 0;

        // iterate over the string
        while (curr_index < S.length()) {

            // get current character
            char curr_char = S.charAt(curr_index);

            // if the last character is c and the current character is not a
            if (last_char == 'c' && curr_char != 'a') {
                last_char = 'a';
                total_insertions++;
                String dummy = S.substring(0, curr_index) + 'a' + S.substring(curr_index);
                System.err.println("dummy: " + dummy);
            } else if (last_char == 'a' && curr_char != 'b') {
                // if the last character is a and the current character is not b
                last_char = 'b';
                total_insertions++;
               String dummy = S.substring(0, curr_index) + 'a' + S.substring(curr_index);
                System.err.println("dummy: " + dummy);
            } else if (last_char == 'b' && curr_char != 'c') {
                // if the last character is b and the current character is not c
                last_char = 'c';
                total_insertions++;
               String dummy = S.substring(0, curr_index) + 'a' + S.substring(curr_index);
                System.err.println("dummy: " + dummy);
            } else {
                // if the last character and the current characters are in sequence
                last_char = curr_char;
                curr_index++;
               String dummy = S.substring(0, curr_index) + 'a' + S.substring(curr_index);
                System.err.println("dummy: " + dummy);
            }

        }
        return total_insertions;
  }

    public static void main(String[] args) {
        System.out.println("Total insertions for 'aabcc' are" + solution("aabcc"));
        // cout<<endl<<"Total insertions for 'abcabcabca' are:
        // "<<solution("abcabcabca")<<endl;
        // cout<<endl<<"Total insertions for 'bcaaa' are: "<<solution("bcaaa")<<endl;

    }

}