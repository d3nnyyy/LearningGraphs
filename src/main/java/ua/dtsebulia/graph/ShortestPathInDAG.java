package ua.dtsebulia.graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

public class ShortestPathInDAG {

    public static int[] shortestPath(int[][] edges, int N, int M) {

        ArrayList<ArrayList<Pair>> adj = new ArrayList<>();

        for (int i = 0; i < M; i++) {
            int u = edges[i][0];
            int v = edges[i][1];
            int wt = edges[i][2];
            adj.get(u).add(new Pair(v, wt));
        }

        boolean vis[] = new boolean[N];
        Stack<Integer> stack = new Stack<>();


        for (int i = 0; i < N; i++) {
            if (!vis[i]) {
                topoSort(i,adj, vis, stack);
            }
        }

        int[] distance = new int[N];
        Arrays.fill(distance, (int) (1e9));

        distance[0] = 0;
        while (!stack.empty()) {
            int node = stack.peek();
            stack.pop();

            for (var it : adj.get(node)) {
                int v = it.first;
                int wt = it.second;

                if (distance[node] + wt < distance[v]) {
                    distance[v] = distance[node] + wt;
                }

            }

        }
        return distance;
    }

    private static void topoSort(int node, ArrayList<ArrayList<Pair>> adj, boolean[] vis, Stack<Integer> stack) {

        vis[node] = true;

        for (var it : adj.get(node)) {
            int v = it.first;
            if (!vis[v]) {
                topoSort(v, adj, vis, stack);
            }
        }

        stack.add(node);

    }

    private static class Pair {
        private final int first;
        private final int second;

        public Pair(int first, int second) {
            this.first = first;
            this.second = second;
        }
    }
}
