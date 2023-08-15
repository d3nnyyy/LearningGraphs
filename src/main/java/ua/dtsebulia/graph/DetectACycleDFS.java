package ua.dtsebulia.graph;

import java.util.ArrayList;

public class DetectACycleDFS {

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

        boolean hasCycle = isCycle(adjList);

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

    private static boolean dfs(int node, int parent, boolean[] visited, ArrayList<ArrayList<Integer>> adjList) {

        visited[node] = true;
        for (var adjNode : adjList.get(node)) {
            if (!visited[adjNode]) {
                if (dfs(adjNode, node, visited, adjList)) {
                    return true;
                }
            } else if (adjNode != parent) {
                return true;
            }
        }
        return false;
    }

    public static boolean isCycle(ArrayList<ArrayList<Integer>> adjList) {

        boolean[] visited = new boolean[adjList.size()];
        for (int i = 0; i < adjList.size(); i++) {
            if (!visited[i]) {
                if (dfs(i,-1,visited, adjList)) {
                    return true;
                }
            }
        }
        return false;
    }

}
