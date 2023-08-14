package ua.dtsebulia.graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BFS {

    public static ArrayList<Integer> traverseWithBFS(int startingPosition, ArrayList<ArrayList<Integer>> adjacencyList) {

        ArrayList<Integer> result = new ArrayList<>();
        boolean[] visitedArray = new boolean[adjacencyList.size()];
        visitedArray[startingPosition] = true;
        Queue<Integer> q = new LinkedList<>();
        q.add(startingPosition);

        while (!q.isEmpty()) {

            int node = q.poll();
            result.add(node);

            for (var it: adjacencyList.get(node)) {
                if (!visitedArray[it]) {
                    visitedArray[it] = true;
                    q.add(it);
                }
            }

        }
        return result;

    }

}
