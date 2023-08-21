package ua.dtsebulia.graph;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;

public class EventualSafeNodesTopologicalSort {

    public ArrayList<Integer> safeNodes(ArrayList<ArrayList<Integer>> adj) {

        int v = adj.size();

        ArrayList<ArrayList<Integer>> reversedAdj = new ArrayList<>();

        for (int i = 0; i < v; i++) {
            reversedAdj.add(new ArrayList<>());
        }

        int[] indegree = new int[v];

        for (int i = 0; i < v; i++) {
            for (var node : adj.get(i)) {
                reversedAdj.get(node).add(i);
                indegree[i]++;
            }
        }

        Queue<Integer> queue = new LinkedList<>();
        ArrayList<Integer> safesNodes = new ArrayList<>();

        for (int i = 0; i < v; i++) {
            if (indegree[i] == 0) {
                queue.add(i);
            }
        }

        while (!queue.isEmpty()) {

            var firstNode = queue.peek();
            queue.remove();
            safesNodes.add(firstNode);

            for (var node : reversedAdj.get(firstNode)) {
                indegree[node]--;
                if (indegree[node] == 0) {
                    queue.add(node);
                }
            }

        }

        Collections.sort(safesNodes);
        return safesNodes;
    }

}
