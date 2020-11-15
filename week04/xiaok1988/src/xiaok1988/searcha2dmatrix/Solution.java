package xiaok1988.searcha2dmatrix;

public class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }
        int nl = matrix.length;
        int nc = matrix[0].length;
        int num = nl * nc;
        int[] array = new int[num];
        for (int i = 0; i < nl; i++) {
            System.arraycopy(matrix[i], 0, array, i * nc, nc) ;
        }

        int low = 0, high = num - 1, middle = high / 2;
        if (target > array[num - 1] || target < array[0]) {
            return false;
        }
        while(low <= high) {
            if (array[middle] < target) {
                low = middle + 1;
                middle = (low + high) / 2;
            } else if (array[middle] > target) {
                high = middle - 1;
                middle = (low + high) / 2;
            } else {
                return true;
            }
        }
        return false;
    }
}
