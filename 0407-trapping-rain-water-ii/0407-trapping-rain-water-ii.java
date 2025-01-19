import java.util.PriorityQueue;

class Solution {
    public int trapRainWater(int[][] heightMap) {
        // Base case: If the height map is empty or has less than 3 rows/columns
        if (heightMap == null || heightMap.length < 3 || heightMap[0].length < 3) {
            return 0;
        }

        int m = heightMap.length;    // Number of rows
        int n = heightMap[0].length; // Number of columns

        // Min-heap to store boundary cells by height
        PriorityQueue<Cell> minHeap = new PriorityQueue<>((a, b) -> a.height - b.height);
        
        // Visited array to track cells that are already processed
        boolean[][] visited = new boolean[m][n];

        // Add all boundary cells to the min-heap
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 || i == m - 1 || j == 0 || j == n - 1) {
                    minHeap.offer(new Cell(i, j, heightMap[i][j]));
                    visited[i][j] = true;
                }
            }
        }

        int trappedWater = 0; // Total water trapped
        int[][] directions = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}}; // Four possible directions

        // Process cells in the min-heap
        while (!minHeap.isEmpty()) {
            Cell cell = minHeap.poll();

            // Traverse neighboring cells
            for (int[] dir : directions) {
                int newRow = cell.row + dir[0];
                int newCol = cell.col + dir[1];

                // Check bounds and if the cell is already visited
                if (newRow >= 0 && newRow < m && newCol >= 0 && newCol < n && !visited[newRow][newCol]) {
                    // Calculate trapped water for the current cell
                    trappedWater += Math.max(0, cell.height - heightMap[newRow][newCol]);

                    // Update the neighbor cell's height to the maximum of its own height or the current boundary height
                    minHeap.offer(new Cell(newRow, newCol, Math.max(cell.height, heightMap[newRow][newCol])));
                    
                    // Mark the cell as visited
                    visited[newRow][newCol] = true;
                }
            }
        }

        return trappedWater;
    }

    // Helper class to represent a cell in the grid
    private static class Cell {
        int row, col, height;

        Cell(int row, int col, int height) {
            this.row = row;
            this.col = col;
            this.height = height;
        }
    }
}
