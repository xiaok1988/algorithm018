package xiaok1988.minesweeper;

public class Solution {
    public char[][] updateBoard(char[][] board, int[] click) {
        if (click[0] >= board.length || click[0] < 0) {
            return board;
        }
        if (click[1] >= board[0].length || click[1] < 0) {
            return board;
        }
        if (board[click[0]][click[1]] == 'M') {
            board[click[0]][click[1]] = 'X';
            return board;
        } else if (board[click[0]][click[1]] == 'E') {
            if (hasMineNeighbour(board, click) != 0) {
                board[click[0]][click[1]] = (char) (hasMineNeighbour(board, click) + '0');
            } else {
                board[click[0]][click[1]] = 'B';
                updateBoard(board, new int[]{click[0] - 1, click[1]});
                updateBoard(board, new int[]{click[0] - 1, click[1] - 1});
                updateBoard(board, new int[]{click[0] - 1, click[1] + 1});
                updateBoard(board, new int[]{click[0] + 1, click[1]});
                updateBoard(board, new int[]{click[0] + 1, click[1] - 1});
                updateBoard(board, new int[]{click[0] + 1, click[1] + 1});
                updateBoard(board, new int[]{click[0], click[1] - 1});
                updateBoard(board, new int[]{click[0], click[1] + 1});
            }
        }
        return board;
    }
    private int hasMineNeighbour(char[][] board, int[] click) {
        int y = click[0];
        int x = click[1];
        int count = 0;
        if (x - 1 >= 0) {
            if (board[y][x-1]=='M') {
                count ++;
            }
            if (y - 1 >= 0) {
                if(board[y-1][x-1] == 'M') {
                    count++;
                }
            }
            if (y +1 <= board.length - 1) {
                if(board[y+1][x-1] == 'M') {
                    count ++;
                }
            }
        }

        if (x + 1 <= board[0].length - 1) {
            if (board[y][x+1]=='M') {
                count ++;
            }
            if (y - 1 >= 0) {
                if(board[y-1][x+1] == 'M') {
                    count++;
                }
            }
            if (y +1 <= board.length - 1) {
                if(board[y+1][x+1] == 'M') {
                    count ++;
                }
            }
        }

        if (board[y][x]=='M') {
            count++;
        }
        if (y - 1 >= 0) {
            if(board[y-1][x] == 'M') {
                count++;
            }
        }
        if (y +1 <= board.length - 1) {
            if(board[y+1][x] == 'M') {
                count ++;
            }
        }
        return count;
    }
}