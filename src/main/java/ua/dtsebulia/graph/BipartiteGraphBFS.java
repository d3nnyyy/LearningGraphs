package ua.dtsebulia.graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BipartiteGraphBFS {

    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

        adj.add(new ArrayList<>());
        adj.add(new ArrayList<>(List.of(2, 3))); //1
        adj.add(new ArrayList<>(List.of(1, 4))); //2
        adj.add(new ArrayList<>(List.of(1, 5))); //3
        adj.add(new ArrayList<>(List.of(2, 6))); //4
        adj.add(new ArrayList<>(List.of(3, 6))); //5
        adj.add(new ArrayList<>(List.of(4, 5))); //6

        System.out.println("Is Bipartite? - " + isBipartite(1, adj));

    }

    public static boolean isBipartite(int start, ArrayList<ArrayList<Integer>> adj) {

        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);
        int[] color = new int[adj.size()];

        for (int i = 0; i < adj.size(); i++) {
            color[i] = -1;
        }

        color[start] = 0;
        while (!queue.isEmpty()) {

            int node = queue.peek();
            queue.remove();

            for (var it : adj.get(node)) {

                if (color[it] == -1 ) {
                    color[it] = 1 - color[node];
                    queue.add(it);
                } else if (color[it] == color[node]) {
                    return false;
                }

            }

        }

        return true;

    }

}
