class Solution {
    public int firstCompleteIndex(int[] arr, int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;

        // Maps to store the positions of numbers in the matrix
        int[][] position = new int[m * n + 1][2];

        // Fill the position map
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                position[mat[i][j]] = new int[]{i, j};
            }
        }

        // Arrays to track the paint counts for rows and columns
        int[] rowCount = new int[m];
        int[] colCount = new int[n];

        // Process the elements of arr
        for (int i = 0; i < arr.length; i++) {
            int num = arr[i];
            int row = position[num][0];
            int col = position[num][1];

            // Paint the cell
            rowCount[row]++;
            colCount[col]++;

            // Check if the row or column is fully painted
            if (rowCount[row] == n || colCount[col] == m) {
                return i;
            }
        }

        // If no row or column is fully painted, return -1
        return -1;
    }
}
