package ua.dtsebulia.graph;

public class FloodFill {

    public static int[][] floodFill(int startingRow, int startingColumn, int[][] grid, int color) {

        int n = grid.length;
        int m = grid[0].length;
        int initialColor = grid[startingRow][startingColumn];

        int[][] visitedMatrix = new int[n][m];

        dfs(startingRow, startingColumn, visitedMatrix, grid, color, initialColor);

        return grid;

    }

    private static void dfs(int startingRow, int startingColumn, int[][] visitedMatrix, int[][] grid, int color, int initialColor) {

        int n = grid.length;
        int m = grid[0].length;

        if (startingRow < 0 || startingRow >= n || startingColumn < 0 || startingColumn >= m || visitedMatrix[startingRow][startingColumn] == 1 || grid[startingRow][startingColumn] != initialColor) {
            return;
        }

        grid[startingRow][startingColumn] = color;

        visitedMatrix[startingRow][startingColumn] = 1;

        int[] deltaRow = {-1, 1, 0, 0};
        int[] deltaCol = {0, 0, -1, 1};

        for (int d = 0; d < 4; d++) {

            int neighborRow = startingRow + deltaRow[d];
            int neighborCol = startingColumn + deltaCol[d];
            dfs(neighborRow, neighborCol, visitedMatrix, grid, color, initialColor);
        }

    }
    
}
