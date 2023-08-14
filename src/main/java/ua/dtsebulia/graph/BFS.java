package ua.dtsebulia.graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BFS {

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
        System.out.println("BFS Traversal: " + traverseWithBFS(startVertex, adj));

    }

    public static ArrayList<Integer> traverseWithBFS(int startingPosition, ArrayList<ArrayList<Integer>> adjacencyList) {

        ArrayList<Integer> result = new ArrayList<>();
        boolean[] visitedArray = new boolean[adjacencyList.size()];
        visitedArray[startingPosition] = true;
        Queue<Integer> q = new LinkedList<>();
        q.add(startingPosition);

        while (!q.isEmpty()) {

            int node = q.poll();
            result.add(node);

            for (var it : adjacencyList.get(node)) {
                if (!visitedArray[it]) {
                    visitedArray[it] = true;
                    q.add(it);
                }
            }

        }
        return result;

    }

}
