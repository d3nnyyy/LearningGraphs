package ua.dtsebulia.graph;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class DistanceOfNearestCellHaving1 {

    public static void main(String[] args) {
        int[][] grid = {{0,0,0},{0,1,0},{0,0,0}};
        System.out.println(Arrays.deepToString(nearest(grid)));
    }

    public static int[][] nearest(int[][] grid) {

        int n = grid.length;
        int m = grid[0].length;

        int[][] visited = new int[n][m];
        int[][] distance = new int[n][m];

        Queue<Node> q = new LinkedList<>();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 1) {
                    q.add(new Node(i,j,0));
                    visited[i][j] = 1;
                } else {
                    visited[i][j] = 0;
                }
            }

        }

        int[] deltaRow = {1,-1,0,0};
        int[] deltaColumn = {0,0,1,-1};

        while (!q.isEmpty()) {

            int row = q.peek().first;
            int column = q.peek().second;
            int steps = q.peek().third;

            q.remove();
            distance[row][column] = steps;

            for (int i = 0; i < 4; i++) {
                int neighborRow = row + deltaRow[i];
                int neighborColumn = column + deltaColumn[i];
                if (neighborRow >= 0 && neighborRow < n
                        && neighborColumn >= 0 && neighborColumn < m
                        && visited[neighborRow][neighborColumn] == 0) {
                    visited[neighborRow][neighborColumn] = 1;
                    q.add(new Node(neighborRow, neighborColumn, steps+1));
                }

            }
        }

        return distance;
    }

    private static class Node {
        int first;
        int second;
        int third;

        public Node(int first, int second, int third) {
            this.first = first;
            this.second = second;
            this.third = third;
        }
    }
}
