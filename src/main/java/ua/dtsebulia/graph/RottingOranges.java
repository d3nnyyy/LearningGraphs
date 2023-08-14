package ua.dtsebulia.graph;

import java.util.LinkedList;
import java.util.Queue;

public class RottingOranges {

    public static void main(String[] args) {
        int[][] grid = {
                {2, 1, 1},
                {1, 1, 0},
                {0, 1, 1}
        };

        int time = rottingOranges(grid);
        if (time == -1) {
            System.out.println("All fresh oranges cannot be rotten.");
        } else {
            System.out.println("Time taken: " + time);
        }
    }

    public static int rottingOranges(int[][] grid) {

        int n = grid.length;
        int m = grid[0].length;

        int[][] visitedMatrix = new int[n][m];
        Queue<Pair> queue = new LinkedList<>();
        int countFresh = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 2) {
                    queue.add(new Pair(i, j, 0));
                    visitedMatrix[i][j] = 2;
                }else {
                    visitedMatrix[i][j] = 0;
                }
                if (grid[i][j] == 1) countFresh++;
            }
        }

        int time = 0;
        int[] deltaRow = {-1, 1, 0, 0};
        int[] deltaCol = {0, 0, -1, 1};
        int cnt = 0;
        while (!queue.isEmpty()) {

            int row = queue.peek().row;
            int col = queue.peek().col;
            int t = queue.peek().time;
            time = Math.max(time, t);
            queue.remove();

            for (int i = 0; i < 4; i++) {
                int neighborRow = row + deltaRow[i];
                int neighborCol = col + deltaCol[i];
                if (neighborRow >= 0 && neighborRow < n && neighborCol >= 0 && neighborCol < m && visitedMatrix[neighborRow][neighborCol] != 2 && grid[neighborRow][neighborCol] == 1) {
                    queue.add(new Pair(neighborRow, neighborCol, t+1));
                    visitedMatrix[neighborRow][neighborCol] = 2;
                    cnt++;
                }
            }

        }

        if (cnt != countFresh) return -1;
        return time;
    }

    private static class Pair {
        int row;
        int col;
        int time;

        public Pair(int row, int col, int time) {
            this.row = row;
            this.col = col;
            this.time = time;
        }
    }

}
