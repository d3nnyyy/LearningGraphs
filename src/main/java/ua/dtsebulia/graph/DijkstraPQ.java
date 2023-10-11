package ua.dtsebulia.graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

public class DijkstraPQ {

    public static void main(String[] args) {

        int V = 5;
        ArrayList<ArrayList<ArrayList<Integer>>> adj = new ArrayList<>(V);
        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }

        adj.get(0).add(new ArrayList<>(Arrays.asList(1, 2)));
        adj.get(0).add(new ArrayList<>(Arrays.asList(2, 4)));
        adj.get(1).add(new ArrayList<>(Arrays.asList(2, 1)));
        adj.get(1).add(new ArrayList<>(Arrays.asList(3, 7)));
        adj.get(2).add(new ArrayList<>(Arrays.asList(3, 2)));
        adj.get(2).add(new ArrayList<>(Arrays.asList(4, 6)));
        adj.get(3).add(new ArrayList<>(Arrays.asList(4, 1)));

        int sourceNode = 4;

        int[] distances = dijkstra(adj, sourceNode);

        for (int i = 0; i < V; i++) {
            System.out.println("Shortest distance from node " + sourceNode + " to node " + i + " is " + distances[i]);
        }

    }

    public static int[] dijkstra(ArrayList<ArrayList<ArrayList<Integer>>> adj, int s) {

        int v = adj.size();
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        int[] dist = new int[v];

        Arrays.fill(dist, (int)1e9);
        dist[s] = 0;
        pq.add(new Pair(0, s));

        while (!pq.isEmpty()) {

            int distance = pq.peek().distance;
            int node = pq.peek().node;
            pq.remove();

            for (var it : adj.get(node)) {
                int edgeWeight = it.get(1);
                int adjNode = it.get(0);

                if (distance + edgeWeight < dist[adjNode]) {

                    dist[adjNode] = distance + edgeWeight;
                    pq.add(new Pair(dist[adjNode], adjNode));

                }
            }

        }
        return dist;

    }

    private static class Pair implements Comparable<Pair> {


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
