package ua.dtsebulia.graph;

import java.util.ArrayList;
import java.util.List;

public class DFS {

    public static ArrayList<Integer> traverseWithDFS(int startingPosition, ArrayList<ArrayList<Integer>> adjList) {

        ArrayList<Integer> result = new ArrayList<>();
        boolean[] visitedArray = new boolean[adjList.size()];

        for (int i = 0; i < adjList.size(); i++) {
            if (!visitedArray[i]) {
                dfsAlgorithm(startingPosition, visitedArray, adjList, result);
            }
        }

        return result;

    }

    private static void dfsAlgorithm(int startingPosition, boolean[] visitedArray, ArrayList<ArrayList<Integer>> adjList, ArrayList<Integer> result) {

        visitedArray[startingPosition] = true;
        result.add(startingPosition);

        for (var item : adjList.get(startingPosition)) {
            if (!visitedArray[item]) {
                dfsAlgorithm(item, visitedArray, adjList, result);
            }
        }

    }

}
