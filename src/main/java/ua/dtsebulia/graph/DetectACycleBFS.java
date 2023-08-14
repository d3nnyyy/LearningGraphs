package ua.dtsebulia.graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class DetectACycleBFS {

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
