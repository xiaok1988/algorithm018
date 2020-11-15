package xiaok1988.numberofislands;

public class Solution {

    public void dfs(int i, int j, char[][] grid) {
        int nr = grid.length;
        int nc = grid[0].length;

        if (i < 0 || j < 0 || i >= nr || j >= nc || grid[i][j] == '0') {
            return ;
        }

        grid[i][j] = '0';

        dfs(i + 1, j, grid);
        dfs(i - 1, j, grid);
        dfs(i, j + 1, grid);
        dfs(i , j - 1, grid);
    }


    public int numIslands(char[][] grid) {
        if (grid == null || grid[0] == null || grid.length == 0 || grid[0].length == 0) {
            return 0;
        }

        int nr = grid.length;
        int nc = grid[0].length;

        int num = 0;
        for (int i = 0; i < nr; i++) {
            for (int j = 0; j < nc; j++) {
                if (grid[i][j] == '1') {
                    num++;
                    dfs(i, j, grid);
                }
            }
        }
        return num;
    }

}