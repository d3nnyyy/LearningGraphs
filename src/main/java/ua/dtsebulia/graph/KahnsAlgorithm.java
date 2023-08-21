package ua.dtsebulia.graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class KahnsAlgorithm {

    public static ArrayList<Integer> sort(ArrayList<ArrayList<Integer>> adj) {

        int v = adj.size();

        int[] indegree = new int[v];

        for (int i = 0; i < v; i++) {
            for (var node : adj.get(i)) {
                indegree[node]++;
            }
        }

        Queue<Integer> queue = new LinkedList<>();

        for (int i = 0; i < v; i++) {
            if (indegree[i] == 0) {
                queue.add(i);
            }
        }

        ArrayList<Integer> topoResult = new ArrayList<>();

        while (!queue.isEmpty()) {

            int node = queue.peek();
            queue.remove();
            topoResult.add(node);

            for (var it : adj.get(node)) {
                indegree[it]--;
                if (indegree[it] == 0) {
                    queue.add(it);
                }
            }

        }

        return topoResult;

    }

}
