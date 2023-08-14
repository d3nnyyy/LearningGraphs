package ua.dtsebulia.graph;

import java.util.ArrayList;
import java.util.List;

import static ua.dtsebulia.graph.BFS.traverseWithBFS;
import static ua.dtsebulia.graph.DFS.traverseWithDFS;
import static ua.dtsebulia.graph.NumberOfIslands.numIslands;
import static ua.dtsebulia.graph.NumberOfProvinces.numProvinces;
import static ua.dtsebulia.graph.RottingOranges.rottingOranges;

public class Main {

    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

        adj.add(new ArrayList<>());
        adj.add(new ArrayList<>(List.of(2, 3))); //1
        adj.add(new ArrayList<>(List.of(1, 4, 5))); //2
        adj.add(new ArrayList<>(List.of(1, 6))); //3
        adj.add(new ArrayList<>(List.of(2, 7, 8))); //4
        adj.add(new ArrayList<>(List.of(2, 8))); //5
        adj.add(new ArrayList<>(List.of(3, 9, 10))); //6
        adj.add(new ArrayList<>(List.of(4, 11))); //7
        adj.add(new ArrayList<>(List.of(4, 5, 11))); //8
        adj.add(new ArrayList<>(List.of(6, 11))); //9
        adj.add(new ArrayList<>(List.of(6, 11))); //10
        adj.add(new ArrayList<>(List.of(7, 8, 9, 10))); //11

        int startVertex = 1;
        System.out.println("BFS Traversal: " + traverseWithBFS(startVertex, adj));
        System.out.println("DFS Traversal: " + traverseWithDFS(startVertex, adj));

        ArrayList<ArrayList<Integer>> adjacencyMatrix = new ArrayList<>();

        // Adding rows to the adjacency matrix
        for (int i = 0; i < 4; i++) {
            ArrayList<Integer> row = new ArrayList<>();
            for (int j = 0; j < 4; j++) {
                row.add(0); // Initialize with 0 (no edges)
            }
            adjacencyMatrix.add(row);
        }

        // Adding edges
        adjacencyMatrix.get(0).set(1, 1);
        adjacencyMatrix.get(1).set(0, 1);

        adjacencyMatrix.get(1).set(2, 1);
        adjacencyMatrix.get(2).set(1, 1);

        adjacencyMatrix.get(3).set(3, 1);

        int provinces = numProvinces(adjacencyMatrix);
        System.out.println("Number of provinces: " + provinces);

        char[][] grid = {
                {'1', '1', '0', '0', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '1', '0', '0'},
                {'0', '0', '0', '1', '1'}
        };

        int numIslands = numIslands(grid);
        System.out.println("Number of islands: " + numIslands);

        int[][] grid2 = {
                {2, 1, 1},
                {1, 1, 0},
                {0, 1, 1}
        };

        int time = rottingOranges(grid2);
        if (time == -1) {
            System.out.println("All fresh oranges cannot be rotten.");
        } else {
            System.out.println("Time taken: " + time);
        }
    }

}
