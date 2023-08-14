package ua.dtsebulia.graph;

import java.util.ArrayList;
import java.util.List;

import static ua.dtsebulia.graph.BFS.traverseWithBFS;
import static ua.dtsebulia.graph.DFS.traverseWithDFS;

public class Main {

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
        adj.add(new ArrayList<>(List.of(13))); //12
        adj.add(new ArrayList<>(List.of(12))); //13

        int startVertex = 1;
        System.out.println(traverseWithBFS(startVertex, adj));
        System.out.println(traverseWithDFS(startVertex, adj));

    }

}
