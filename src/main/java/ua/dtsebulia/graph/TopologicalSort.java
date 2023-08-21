package ua.dtsebulia.graph;

import java.util.ArrayList;
import java.util.Stack;

public class TopologicalSort {

    public static int[] sort(ArrayList<ArrayList<Integer>> adj) {

        int V = adj.size();
        boolean[] vis = new boolean[V];
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < V; i++) {
            if (!vis[i]) {
                dfs(i, vis, stack, adj);
            }
        }

        int[] res = new int[V];
        int i = 0;

        while (!stack.empty()) {
            res[i++] = stack.peek();
            stack.pop();
        }

        return res;

    }

    private static void dfs(int i, boolean[] vis, Stack<Integer> stack, ArrayList<ArrayList<Integer>> adj) {

        vis[i] = true;

        for (var node : adj.get(i)) {
            if (!vis[node]) {
                dfs(node, vis, stack, adj);
            }
        }
        stack.push(i);

    }

}
