package friendcircles;

class Solution {
    private void backtrack(int[][] M, boolean[] visited, int i) {
        for (int j  = 0; j < M[i].length; j++) {
            if (M[i][j] == 1 && visited[j] == false) {
                visited[j] = true;
                backtrack(M, visited, j);
            }
        }
    }
    public int findCircleNum(int[][] M) {
        boolean[] visited = new boolean[M.length];
        int count = 0;
        for (int i = 0; i < M.length; i++) {
            if (!visited[i]) {
                backtrack(M, visited, i);
                count++;
            }
        }
        return count;
    }
}
