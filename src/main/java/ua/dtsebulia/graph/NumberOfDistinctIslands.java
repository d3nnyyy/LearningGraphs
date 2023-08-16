package ua.dtsebulia.graph;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class NumberOfDistinctIslands {

    public static void main(String[] args) {

        int[][] grid = {
                {1,1,0,1,1},
                {1,0,0,0,0},
                {0,0,0,1,1},
                {1,1,0,1,0}
        };

        System.out.println(numDisIslands(grid));

    }

    public static int numDisIslands(int[][] grid) {

        int n = grid.length;
        int m = grid[0].length;

        boolean[][] vis = new boolean[n][m];

        Set<ArrayList<String>> set = new HashSet<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (!vis[i][j] && grid[i][j] == 1) {
                    ArrayList<String> list = new ArrayList<>();
                    dfs(i, j, vis, grid, list, i, j);
                    set.add(list);
                }
            }
        }
        return set.size();
    }

    private static String toString(int r, int c) {
        return Integer.toString(r) + " " + Integer.toString(c);
    }

    private static void dfs(int row, int col, boolean[][] vis, int[][] grid, ArrayList<String> list, int row0, int col0) {

        vis[row][col] = true;

        list.add(toString(row-row0, col-col0));

        int n = grid.length;
        int m = grid[0].length;

        int[] deltaRow = {-1, 1, 0, 0};
        int[] deltaCol = {0, 0, -1, 1};

        for (int i = 0; i < 4; i++) {

            int nRow = row + deltaRow[i];
            int nCol = col + deltaCol[i];

            if (nRow >= 0 && nRow < n && nCol >= 0 && nCol < m && !vis[nRow][nCol] && grid[nRow][nCol] == 1) {
                dfs(nRow, nCol, vis, grid, list, row0, col0);
            }

        }

    }

}
