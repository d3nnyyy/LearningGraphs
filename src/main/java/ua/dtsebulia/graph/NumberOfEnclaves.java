package ua.dtsebulia.graph;

import java.util.LinkedList;
import java.util.Queue;

public class NumberOfEnclaves {

    public static int numberOfEnclaves(int[][] grid) {

        Queue<Pair> queue = new LinkedList<>();

        int n = grid.length;
        int m = grid[0].length;

        boolean[][] vis = new boolean[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (i == 0 || j == 0 || i == n - 1 || j == m - 1) {
                    if (grid[i][j] == 1) {
                        queue.add(new Pair(i, j));
                        vis[i][j] = true;
                    }
                }
            }
        }

        int[] deltaRow = {-1, 1, 0, 0};
        int[] deltaCol = {0, 0, -1, 1};

        while (!queue.isEmpty()) {

            int row = queue.peek().first;
            int col = queue.peek().second;
            queue.remove();

            for (int i = 0; i < 4; i++) {

                int nRow = row + deltaRow[i];
                int nCol = col + deltaCol[i];

                if (nRow >= 0 && nRow < n && nCol >= 0 && nCol < m && !vis[nRow][nCol] && grid[nRow][nCol] == 1) {
                    queue.add(new Pair(nRow, nCol));
                    vis[nRow][nCol] = true;
                }

            }

        }

        int counter = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 1 && !vis[i][j]) {
                    counter++;
                }
            }
        }

        return counter;


    }

    private static class Pair {
        int first;
        int second;

        public Pair(int first, int second) {
            this.first = first;
            this.second = second;
        }
    }
}
