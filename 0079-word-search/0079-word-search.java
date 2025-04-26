class Solution {
    public boolean exist(char[][] board, String word) {
        int rows = board.length;
        int cols = board[0].length;
        
        // Try starting from every cell
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (dfs(board, word, i, j, 0)) {
                    return true;
                }
            }
        }
        
        return false;
    }
    
    private boolean dfs(char[][] board, String word, int i, int j, int index) {
        // If all characters are found
        if (index == word.length()) {
            return true;
        }
        
        // If out of bounds or character doesn't match
        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length || 
            board[i][j] != word.charAt(index)) {
            return false;
        }
        
        // Mark the cell as visited
        char temp = board[i][j];
        board[i][j] = '#';  // Any special character not in the board
        
        // Explore neighbors: up, down, left, right
        boolean found = dfs(board, word, i+1, j, index+1) ||
                        dfs(board, word, i-1, j, index+1) ||
                        dfs(board, word, i, j+1, index+1) ||
                        dfs(board, word, i, j-1, index+1);
        
        // Restore the cell (backtracking)
        board[i][j] = temp;
        
        return found;
    }
}
