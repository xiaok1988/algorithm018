package surroundedregions;

class Solution {
    public void solve(char[][] board) {
        if (board.length == 0 || board[0].length == 0) {
            return;
        }
        int M = board.length;
        int N = board[0].length;

        for (int i = 0; i < M; i++) {
            dfs(board, i, 0);
            dfs(board, i, N - 1);
        }

        for (int j = 0; j < N; j++) {
            dfs(board, 0, j);
            dfs(board, M - 1, j);
        }

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == 'A') {
                    board[i][j] = 'O';
                } else if (board[i][j] == 'O') {
                    board[i][j] = 'X';
                }
            }
        }
    }

    private void dfs(char[][] board, int i, int j) {
        if (i < 0 || i > board.length - 1 || j < 0 || j > board[0].length - 1|| board[i][j] != 'O') {
            return;
        }
        board[i][j] = 'A';
        dfs(board, i + 1, j);
        dfs(board, i - 1, j);
        dfs(board, i, j + 1);
        dfs(board, i, j - 1);

    }
}

