package ua.dtsebulia.graph;

import java.util.ArrayList;

public class DetectACycleDirectedGraphDFS {

    public static boolean isCyclic(ArrayList<ArrayList<Integer>> adjList) {

        boolean[] vis = new boolean[adjList.size()];
        boolean[] pathVis = new boolean[adjList.size()];

        for (int i = 0; i < adjList.size(); i++) {
            if (!vis[i]) {
                if (dfs(i, vis, pathVis, adjList)) return true;
            }
        }
        return false;
    }

    private static boolean dfs(int i, boolean[] vis, boolean[] pathVis, ArrayList<ArrayList<Integer>> adjList) {

        vis[i] = true;
        pathVis[i] = true;

        for (var node : adjList.get(i)) {

            if (!vis[i]) {

                if (dfs(node, vis, pathVis, adjList)) return true;

            } else if (pathVis[node]) {
                return true;
            }

        }

        pathVis[i] = false;
        return false;
    }

}
