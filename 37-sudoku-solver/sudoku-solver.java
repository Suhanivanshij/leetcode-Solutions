class Solution {
    public void solveSudoku(char[][] board) {
        solve(board);
    }

    static boolean solve(char[][] board) {
        int n = board.length;

        for (int row = 0; row < n; row++) {
            for (int col = 0; col < n; col++) {
                if (board[row][col] == '.') {
                    for (char number = '1'; number <= '9'; number++) {
                        if (isSafe(board, row, col, number)) {
                            board[row][col] = number;

                            if (solve(board)) {
                                return true;
                            } else {
                                board[row][col] = '.'; // backtrack
                            }
                        }
                    }
                    return false; // no valid number found
                }
            }
        }

        return true; // board is completely filled
    }

    static boolean isSafe(char[][] board, int row, int col, char num) {
        for (int i = 0; i < 9; i++) {
            if (board[row][i] == num || board[i][col] == num)
                return false;

            int subgridRow = 3 * (row / 3) + i / 3;
            int subgridCol = 3 * (col / 3) + i % 3;
            if (board[subgridRow][subgridCol] == num)
                return false;
        }

        return true;
    }

}