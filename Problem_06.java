/**
 * We are given a string text of length N consisting of the letters 'a', 'b' or
 * 'c'. We can insert any of those letters before or after any letter in the
 * string.
 * 
 * The goal is to insert letters into text so that it will follow the pattern
 * "abcabca..."; i.e. it should start with a letter 'a', letter 'a' should be
 * followed by 'b', letter 'b' should be followed by 'c', and letter 'c' by 'a'.
 * The string may end with any of those three letters.
 * 
 * What is the minimum number of letters we need to insert into text?
 * 
 * Write a function:
 * 
 * int solution(String text);
 * 
 * that, given a string text of length N, returns the minimum number of
 * insertions needed to make text follow the described pattern.
 * 
 * Examples:
 * 
 * For text = "aabcc" we need to insert letters 'b' and 'c' between the pair of
 * letters 'a', and then insert letters 'a' and 'b' between the two letters 'c'.
 * This way we obtain the string "abcabcabc" and the function should return 4.
 * For text = "abcabcabca", we do not need to insert any letters. The string
 * already follows the required pattern, so the function should return 0. Note
 * that text does not need to end with letter 'c'.
 * For text = "bcaaa", letter 'a' should be inserted at the beginning of text,
 * and then letters 'b' and 'c' should be inserted between the two pairs of
 * letters 'a'. This way we obtain the string "abcabcabca" and the function
 * should return 5.
 * Assume that:
 * 
 * N is an integer within the range [1..100];
 * string text consists only of the following characters: "a", "b" and/or "c".
 * In your solution, focus on correctness. The performance of your solution will
 * not be the focus of the assessment.
 */

public class Problem_06 {

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