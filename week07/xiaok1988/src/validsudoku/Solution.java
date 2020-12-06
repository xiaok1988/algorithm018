package validsudoku;

import java.util.HashSet;
import java.util.Set;

class Solution {
    public boolean isValidSudoku(char[][] board) {
        if (board.length != 9 || board[0].length != 9) {
            return false;
        }
        //先判断每一行
        for (int i = 0; i < board.length; i++) {
            char[] line = board[i];
            Set<Character> set = new HashSet<>();
            for (int j = 0; j < line.length; j++) {
                if (board[i][j] == '.') {
                    continue;
                } else {
                    if (board[i][j] < '1' || board[i][j] > '9' || set.contains(board[i][j])) {
                        return false;
                    }
                    set.add(board[i][j]);
                }
            }
        }

        //再判断每一列
        for (int i = 0; i < board[0].length; i++) {
            char[] column = new char[9];
            for (int j = 0; j < board.length; j++) {
                column[j] = board[j][i];
            }
            Set<Character> set = new HashSet<>();
            for (int j = 0; j < column.length; j++) {
                if (board[j][i] == '.') {
                    continue;
                } else {
                    if (board[j][i] < '1' || board[j][i] > '9' || set.contains(board[j][i])) {
                        return false;
                    }
                    set.add(board[j][i]);
                }
            }

        }

        //最后判断每个方格
        for (int i = 0; i < 9; i++) {
            //the ith block
            char[] block = new char[9];
            int line = i / 3;
            int shu = i % 3;
            for (int j = 0; j < 9; j++) {
                int row = line * 3 + j / 3;
                int column = shu * 3 + j % 3;
                block[j] = board[row][column];
            }
            Set<Character> set = new HashSet<>();
            for (int j = 0; j < block.length; j++) {
                int row = line * 3 + j / 3;
                int column = shu * 3 + j % 3;
                if (board[row][column] == '.') {
                    continue;
                } else if (board[row][column] < '1' || board[row][column] > '9' || set.contains(board[row][column])) {
                    return false;
                }
                set.add(board[row][column]);
            }

        }
        return true;

    }
}

