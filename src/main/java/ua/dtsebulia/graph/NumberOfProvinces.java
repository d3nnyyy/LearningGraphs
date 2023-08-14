package ua.dtsebulia.graph;

import java.util.ArrayList;

public class NumberOfProvinces {

    static int numProvinces(ArrayList<ArrayList<Integer>> adjacencyMatrix) {

        int V = adjacencyMatrix.size();

        ArrayList<ArrayList<Integer>> adjacencyList = new ArrayList<>();

        for (int i = 0; i < V; i++) {
            adjacencyList.add(new ArrayList<>());
        }

        //turning matrix into list
        for (int i = 0; i < V; i++) {
            for (int j = 0; j < V; j++) {

                if (adjacencyMatrix.get(i).get(j) == 1 && i != j) {

                    adjacencyMatrix.get(i).add(j);
                    adjacencyMatrix.get(j).add(i);

                }

            }
        }

        int[] visitedArray = new int[V];
        int counter = 0;

        for (int i = 0; i < V; i++) {
            if (visitedArray[i] == 0) {
                counter++;
                dsf(i, adjacencyList, visitedArray);
            }
        }

        return counter;
    }

    private static void dsf(int i, ArrayList<ArrayList<Integer>> adjacencyList, int[] visitedArray) {

        visitedArray[i] = 1;
        for (var it : adjacencyList.get(i)) {
            if (visitedArray[it] == 0) {
                dsf(it, adjacencyList, visitedArray);
            }
        }

    }

}

