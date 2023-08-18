import java.util.ArrayList;
import java.util.List;

public class Solution {
    private List<List<String>> output = new ArrayList<>();
    private char[][] board;
    private int n;

    public List<List<String>> solveNQueens(int n) {
        this.n = n;
        board = new char[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = '.';
            }
        }
        backtrack(0);
        return output;
    }

    private boolean is_valid(int row, int col) {
        // Check the column
        for (int i = 0; i < row; i++) {
            if (board[i][col] == 'Q') return false;
        }
        // Check upper left diagonal
        for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--) {
            if (board[i][j] == 'Q') return false;
        }
        // Check upper right diagonal
        for (int i = row - 1, j = col + 1; i >= 0 && j < n; i--, j++) {
            if (board[i][j] == 'Q') return false;
        }
        return true;
    }

    private void backtrack(int row) {
        if (row == n) {
            List<String> currentBoard = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                currentBoard.add(new String(board[i]));
            }
            output.add(currentBoard);
            return;
        }

        for (int col = 0; col < n; col++) {
            if (is_valid(row, col)) {
                board[row][col] = 'Q';
                backtrack(row + 1);
                board[row][col] = '.';
            }
        }
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        List<List<String>> result = sol.solveNQueens(4);
        for (List<String> board : result) {
            for (String row : board) {
                System.out.println(row);
            }
            System.out.println();
        }
    }
}
