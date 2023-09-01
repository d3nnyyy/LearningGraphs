package ua.dtsebulia.graph;

import java.util.*;

public class ShortestPathInUnDirGraphWithUnitWeights {

    public static int[] shortestPath(int[][] edges, int n, int m, int start) {

        AbstractList<ArrayList<Integer>> adj = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }

        for (var node : edges) {
            adj.get(node[0]).add(node[1]);
            adj.get(node[1]).add(node[0]);
        }

        int[] distance = new int[n];
        Arrays.fill(distance, (int) (1e9));
        Queue<Integer> q = new LinkedList<>();
        q.add(start);

        while (!q.isEmpty()) {

            int first = q.peek();
            q.remove();

            for (var node : adj.get(first)) {
                if (distance[first] + 1 < distance[node]) {
                    distance[node] = distance[first] + 1;
                }
                q.add(node);
            }
        }

        for (int i = 0; i < n; i++) {
            if (distance[i] == 1e9) distance[i] = -1;
        }
        return distance;
    }

}
