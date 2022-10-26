/**
 * Given an m x n grid of characters board and a string word, return true if
 * word exists in the grid.
 * 
 * The word can be constructed from letters of sequentially adjacent cells,
 * where adjacent cells are horizontally or vertically neighboring. The same
 * letter cell may not be used more than once.
 * Input: board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]]
 * word = "ABCCED"
 * Output: true
 * 
 * Input: board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word
 * = "SEE"
 * Output: true
 * 
 * Input: board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word
 * = "ABCB"
 * Output: false
 */

class Problem_12 {

    private boolean found = false; // global variable to track if word is found

    public boolean exist(char[][] board, String word) {
        
        boolean[][] visited = new boolean[board.length][board[0].length]; // keep track of visited cells
        
        for (int i = 0; i < board.length; i++)
            for (int j = 0; j < board[0].length; j++)
                if (found)
                    break;
                else if (board[i][j] == word.charAt(0))
                    dfs(board, visited, word, i, j, 0);

        return found;
    }

    private void dfs(char[][] b, boolean[][] visited, String word, int r, int c, int ptr) {
        // logic
        visited[r][c] = true;
        ptr++;

        // base case
        if (ptr == word.length()) {
            found = true;
            return;
        }

        // dfs
        if (r + 1 < b.length && !visited[r + 1][c] && word.charAt(ptr) == b[r + 1][c]) // down
            dfs(b, visited, word, r + 1, c, ptr);
        if (!found && r - 1 >= 0 && !visited[r - 1][c] && word.charAt(ptr) == b[r - 1][c]) // up
            dfs(b, visited, word, r - 1, c, ptr);
        if (!found && c + 1 < b[0].length && !visited[r][c + 1] && word.charAt(ptr) == b[r][c + 1]) // right
            dfs(b, visited, word, r, c + 1, ptr);
        if (!found && c - 1 >= 0 && !visited[r][c - 1] && word.charAt(ptr) == b[r][c - 1]) // left
            dfs(b, visited, word, r, c - 1, ptr);

        // backtrack
        visited[r][c] = false;
        ptr--;
    }
}