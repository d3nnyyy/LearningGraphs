package ua.dtsebulia.graph;

import java.util.Arrays;

public class SurroundedRegions {

    public static void main(String[] args) {
        char[][] grid = {
                {'X', 'X', 'X', 'X'},
                {'O', 'O', 'O', 'X'},
                {'X', 'X', 'O', 'X'},
                {'X', 'X', 'O', 'X'},
                {'X', 'X', 'X', 'X'}
        };

        System.out.println(Arrays.deepToString(surroundedRegions(grid)));
    }

    public static char[][] surroundedRegions(char[][] grid) {

        int n = grid.length;
        int m = grid[0].length;

        boolean[][] visitedMatrix = new boolean[n][m];

        int[] deltaRow = {-1, 1, 0, 0};
        int[] deltaCol = {0, 0, -1, 1};

        for (int j = 0; j < m; j++) {

            if (!visitedMatrix[0][j] && grid[0][j] == 'O') {
                dfs(0, j, visitedMatrix, grid, deltaRow, deltaCol);
            }

            if (!visitedMatrix[n - 1][j] && grid[0][j] == 'O') {
                dfs(n - 1, j, visitedMatrix, grid, deltaRow, deltaCol);
            }

        }

        for (int i = 0; i < n; i++) {

            if (!visitedMatrix[i][0] && grid[i][0] == 'O') {
                dfs(i, 0, visitedMatrix, grid, deltaRow, deltaCol);
            }

            if (!visitedMatrix[i][m - 1] && grid[n - 1][0] == 'O') {
                dfs(i, m - 1, visitedMatrix, grid, deltaRow, deltaCol);
            }

        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (!visitedMatrix[i][j] && grid[i][j] == 'O') {
                    grid[i][j] = 'X';
                }
            }
        }

        return grid;
    }

    private static void dfs(int i, int j, boolean[][] visitedMatrix, char[][] grid, int[] deltaRow, int[] deltaCol) {

        visitedMatrix[i][j] = true;

        int n = grid.length;
        int m = grid[0].length;

        for (int d = 0; d < 4; d++) {

            int neighborRow = i + deltaRow[d];
            int neighborCol = j + deltaCol[d];

            if (neighborRow >= 0 && neighborRow < n && neighborCol >= 0 && neighborCol < m && !visitedMatrix[neighborRow][neighborCol] && grid[neighborRow][neighborCol] == 'O') {
            dfs(neighborRow, neighborCol, visitedMatrix, grid, deltaRow, deltaCol);
            }

        }

    }
}
