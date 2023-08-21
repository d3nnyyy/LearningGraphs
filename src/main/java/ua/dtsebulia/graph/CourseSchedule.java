package ua.dtsebulia.graph;

import java.util.ArrayList;

public class CourseSchedule {

    public static boolean canFinish(int numCourses, int[][] prerequisites) {

        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

        for (int i = 0; i < numCourses; i++) {
            adj.add(new ArrayList<>());
        }
        int length = prerequisites.length;
        for (int i = 0; i < length; i++) {
            adj.get(prerequisites[i][0]).add(prerequisites[i][1]);
        }

        ArrayList<Integer> topoSort = KahnsAlgorithm.sort(adj);

        return topoSort.size() == numCourses;

    }

}
