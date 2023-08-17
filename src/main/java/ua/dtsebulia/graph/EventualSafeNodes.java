package ua.dtsebulia.graph;

import java.util.ArrayList;

public class EventualSafeNodes {

    private static boolean dfsCheckForCycle(int i, ArrayList<ArrayList<Integer>> adj, boolean[] vis, boolean[] visPath, boolean[] markedSafeNodes) {

        vis[i] = true;
        visPath[i] = true;

        for (var node : adj.get(i)) {

            if (!vis[node]) {

                if (dfsCheckForCycle(node, adj, vis, visPath, markedSafeNodes)) return true;

            } else if (visPath[node]) {
                return true;
            }

        }

        markedSafeNodes[i] = true;
        visPath[i] = false;
        return false;

    }

    public static ArrayList<Integer> findSafeNodes(ArrayList<ArrayList<Integer>> adjList) {

        boolean[] vis = new boolean[adjList.size()];
        boolean[] visPath = new boolean[adjList.size()];
        boolean[] markedSafeNodes = new boolean[adjList.size()];

        ArrayList<Integer> safeNodes= new ArrayList<>();

        for (int i = 0; i < adjList.size(); i++) {
            if (!vis[i]) {
                dfsCheckForCycle(i, adjList, vis, visPath, markedSafeNodes);
            }
        }

        for (int i = 0; i < adjList.size(); i++) {
            if (markedSafeNodes[i]) {
                safeNodes.add(i);
            }
        }
        return safeNodes;
    }

}
