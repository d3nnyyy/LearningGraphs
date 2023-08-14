package ua.dtsebulia.graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class DetectACycleBFS {

    public static void main(String[] args) {

        ArrayList<ArrayList<Integer>> adjList = new ArrayList<>();
        int numVertices = 4;

        for (int i = 0; i < numVertices; i++) {
            adjList.add(new ArrayList<>());
        }

        // Add edges to the adjacency list
        addEdge(adjList, 0, 1);
        addEdge(adjList, 1, 2);
        addEdge(adjList, 2, 3);
        addEdge(adjList, 3, 0);

        DetectACycleBFS cycleDetector = new DetectACycleBFS();
        boolean hasCycle = cycleDetector.isCycle(adjList);

        if (hasCycle) {
            System.out.println("The graph contains a cycle.");
        } else {
            System.out.println("The graph does not contain a cycle.");
        }
    }

    private static void addEdge(ArrayList<ArrayList<Integer>> adjList, int u, int v) {
        adjList.get(u).add(v);
        adjList.get(v).add(u);

    }

    public boolean isCycle(ArrayList<ArrayList<Integer>> adjList) {

        boolean[] visitedArray = new boolean[adjList.size()];
        for (int i = 0; i < adjList.size(); i++) {
            if (!visitedArray[i]) {
                if (detectACycle(i, adjList, visitedArray)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean detectACycle(int startingPos, ArrayList<ArrayList<Integer>> adjList, boolean[] visitedArray) {

        visitedArray[startingPos] = true;
        Queue<Pair> queue= new LinkedList<>();
        queue.add(new Pair(startingPos, -1));

        while (!queue.isEmpty()) {

            int node = queue.peek().first;
            int parent = queue.peek().second;

            queue.remove();

            for (var adjNode : adjList.get(node)) {

                if (!visitedArray[adjNode]) {

                    visitedArray[adjNode] = true;
                    queue.add(new Pair(adjNode, node));

                } else if (parent != adjNode) {
                    return true;
                }

            }

        }
        return false;

    }

    private class Pair {
        int first;
        int second;

        public Pair(int first, int second) {
            this.first = first;
            this.second = second;
        }
    }
}
