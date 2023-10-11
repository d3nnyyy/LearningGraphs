package ua.dtsebulia.graph;

import java.util.*;

public class PrintShortestPath {

    public static void main(String[] args) {

        int v = 5;
        int e = 6;

        int[][] edges = {
                {1, 2, 2},
                {2, 5, 5},
                {2, 3, 4},
                {1, 4, 1},
                {4, 3, 3},
                {3, 5, 1}
        };

        List<Integer> shortestPathResult = PrintShortestPath.shortestPath(v, e, edges);

        if (shortestPathResult.get(0) == -1) {
            System.out.println("No path found.");
        } else {
            System.out.print("Shortest Path: ");
            for (int node : shortestPathResult) {
                System.out.print(node + " ");
            }
            System.out.println();
        }
    }

    public static List<Integer> shortestPath(int v, int e, int[][] edges) {

        ArrayList<ArrayList<Pair>> adj = new ArrayList<>();

        for (int i = 0; i <= v; i++) {
            adj.add(new ArrayList<>());
        }

        for (int i = 0; i < e; i++) {
            adj.get(edges[i][0]).add(new Pair(edges[i][1], edges[i][2]));
            adj.get(edges[i][1]).add(new Pair(edges[i][0], edges[i][2]));
        }

        PriorityQueue<Pair> pq = new PriorityQueue<>();
        
        int[] dist = new int[v+1];
        int[] parent = new int[v+1];

        for (int i = 0; i <= v; i++) {
            dist[i] = (int)1e9;
            parent[i] = i;
        }

        dist[1] = 0;
        pq.add(new Pair(0,1));
        while (!pq.isEmpty()) {

            int distance = pq.peek().distance;
            int node = pq.peek().node;
            pq.remove();

            for (var it: adj.get(node)) {

                int adjNode = it.distance;
                int weight = it.node;

                if (distance + weight < dist[adjNode]) {

                    dist[adjNode] = distance + weight;
                    pq.add(new Pair(dist[adjNode], adjNode));
                    parent[adjNode] = node;

                }

            }
        }

        if (dist[v] == 1e9) return Collections.singletonList(-1);

        int node = v;
        LinkedList<Integer> res = new LinkedList<>();

        while (parent[node] != node) {
            res.addFirst(node);
            node = parent[node];
        }

        res.push(1);

        return res;
    }

    private static class Pair implements Comparable<Pair>{

        int distance;
        int node;

        public Pair(int distance, int node) {
            this.distance = distance;
            this.node = node;
        }

        @Override
        public int compareTo(Pair o) {
            return Integer.compare(this.distance, o.distance);
        }
    }
}
