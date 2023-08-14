package ua.dtsebulia.graph;

import java.util.ArrayList;
import java.util.List;

public class DFS {

    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

        adj.add(new ArrayList<>());
        adj.add(new ArrayList<>(List.of(2, 3))); //1
        adj.add(new ArrayList<>(List.of(1, 4, 5))); //2
        adj.add(new ArrayList<>(List.of(1, 6))); //3
        adj.add(new ArrayList<>(List.of(2, 7, 8))); //4
        adj.add(new ArrayList<>(List.of(2, 8))); //5
        adj.add(new ArrayList<>(List.of(3, 9, 10))); //6
        adj.add(new ArrayList<>(List.of(4, 11))); //7
        adj.add(new ArrayList<>(List.of(4, 5, 11))); //8
        adj.add(new ArrayList<>(List.of(6, 11))); //9
        adj.add(new ArrayList<>(List.of(6, 11))); //10
        adj.add(new ArrayList<>(List.of(7, 8, 9, 10))); //11

        int startVertex = 1;
        System.out.println(traverseWithDFS(startVertex, adj));

    }

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
