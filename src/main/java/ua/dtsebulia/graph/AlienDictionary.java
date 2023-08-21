package ua.dtsebulia.graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class AlienDictionary {

    public String findOrder(String[] dictionary, int n, int k) {

        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

        for (int i = 0; i < k; i++) {
            adj.add(new ArrayList<>());
        }

        for (int i = 0; i < n-1; i++) {
            String s1 = dictionary[i];
            String s2 = dictionary[i+1];

            int len = Math.min(s1.length(), s2.length());

            for (int ptr = 0; ptr < len; ptr++) {

                if (s1.charAt(ptr) != s2.charAt(ptr)) {
                    adj.get(s1.charAt(ptr)-'a').add(s2.charAt(ptr)-'a');
                    break;
                }

            }

        }

        ArrayList<Integer> topo = sort(adj);
        String answer = "";

        for (var it : topo) {
            answer += (char) (it + (int)('a'));
        }

        return answer;
    }

    private static ArrayList<Integer> sort(ArrayList<ArrayList<Integer>> adj) {

        int v = adj.size();

        int[] indegree = new int[v];

        for (int i = 0; i < v; i++) {
            for (var node : adj.get(i)) {
                indegree[node]++;
            }
        }

        Queue<Integer> queue = new LinkedList<>();

        for (int i = 0; i < v; i++) {
            if (indegree[i] == 0) {
                queue.add(i);
            }
        }

        ArrayList<Integer> topoResult = new ArrayList<>();

        while (!queue.isEmpty()) {

            int node = queue.peek();
            queue.remove();
            topoResult.add(node);

            for (var it : adj.get(node)) {
                indegree[it]--;
                if (indegree[it] == 0) {
                    queue.add(it);
                }
            }

        }

        return topoResult;

    }

}
