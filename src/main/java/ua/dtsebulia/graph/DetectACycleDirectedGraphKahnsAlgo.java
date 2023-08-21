package ua.dtsebulia.graph;

import java.util.ArrayList;
import java.util.List;

public class DetectACycleDirectedGraphKahnsAlgo {

    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

        adj.add(new ArrayList<>());
        adj.add(new ArrayList<>(List.of(2))); //1
        adj.add(new ArrayList<>(List.of(3))); //2
        adj.add(new ArrayList<>(List.of(4, 5))); //3
        adj.add(new ArrayList<>(List.of(2))); //4
        adj.add(new ArrayList<>()); //5

        System.out.println(isCycle(adj));
    }

    public static boolean isCycle(ArrayList<ArrayList<Integer>> adj) {

        ArrayList<Integer> topoSort = KahnsAlgorithm.sort(adj);

        return topoSort.size() == adj.size();

    }

}
