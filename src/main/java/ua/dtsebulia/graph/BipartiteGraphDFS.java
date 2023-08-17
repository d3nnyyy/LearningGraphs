package ua.dtsebulia.graph;

import java.util.ArrayList;
import java.util.List;

public class BipartiteGraphDFS {

    public static void main(String[] args) {

        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

        adj.add(new ArrayList<>());
        adj.add(new ArrayList<>(List.of(2, 3))); //1
        adj.add(new ArrayList<>(List.of(1, 4))); //2
        adj.add(new ArrayList<>(List.of(1, 5))); //3
        adj.add(new ArrayList<>(List.of(2, 6))); //4
        adj.add(new ArrayList<>(List.of(3, 6))); //5
        adj.add(new ArrayList<>(List.of(4, 5))); //6

        System.out.println("Is Bipartite? - " + isBipartite(adj));

    }

    public static boolean isBipartite(ArrayList<ArrayList<Integer>> adjList) {

        int[] color = new int[adjList.size()];

        for (int i = 0; i < adjList.size(); i++) {
            color[i] = -1;
        }

        color[0] = 1;

        for (int i = 0; i < adjList.size(); i++) {
            if (color[i] == -1) {
                if (!dfs(i, 0, color, adjList)) return false;
            }
        }
        return true;
    }

    private static boolean dfs(int node, int col, int[] color, ArrayList<ArrayList<Integer>> adjList) {

        color[node] = col;

        for (int it : adjList.get(node)) {
            if (color[it] == -1) {
                if (!dfs(it, 1-col, color, adjList)) return false;
            } else if (color[it] == col) {
                return false;
            }
        }

        return true;
    }

}
