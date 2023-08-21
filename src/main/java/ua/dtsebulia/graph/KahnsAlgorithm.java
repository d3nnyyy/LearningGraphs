package ua.dtsebulia.graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class KahnsAlgorithm {

    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

        adj.add(new ArrayList<>());
        adj.add(new ArrayList<>()); //1
        adj.add(new ArrayList<>(List.of(3))); //2
        adj.add(new ArrayList<>(List.of(1))); //3
        adj.add(new ArrayList<>(List.of(0,1))); //4
        adj.add(new ArrayList<>(List.of(0,2))); //5

        System.out.println(sort(adj));
    }

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
