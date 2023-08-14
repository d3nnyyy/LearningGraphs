package ua.dtsebulia.graph;

public class NumberOfIslands {

    public static int numIslands(char[][] grid) {

        int n = grid.length;
        int m = grid[0].length;

        int[][] visitedMatrix = new int[n][m];
        int counter = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (visitedMatrix[i][j] == 0 && grid[i][j] == '1') {
                    counter++;
                    dfs(i, j, visitedMatrix, grid);
                }
            }
        }
        return counter;
    }

    private static void dfs(int i, int j, int[][] visitedMatrix, char[][] grid) {

        int n = grid.length;
        int m = grid[0].length;

        if (i < 0 || i >= n || j < 0 || j >= m || visitedMatrix[i][j] == 1 || grid[i][j] == '0') {
            return;
        }

        visitedMatrix[i][j] = 1;

        int[] deltaRow = {-1, 1, 0, 0};
        int[] deltaCol = {0, 0, -1, 1};


        for (int d = 0; d < 4; d++) {

            int neighborRow = i + deltaRow[d];
            int neighborCol = j + deltaCol[d];
            dfs(neighborRow, neighborCol, visitedMatrix, grid);
        }
    }

}
