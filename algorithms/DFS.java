package algorithms;

import java.util.*;

public class DFS {
    public static List<Integer> traverse(Map<Integer, List<Integer>> graph, int start) {
        List<Integer> order = new ArrayList<>();
        Set<Integer> seen = new HashSet<>();
        dfs(graph, start, seen, order);
        return order;
    }
    private static void dfs(Map<Integer, List<Integer>> g, int v, Set<Integer> seen, List<Integer> out) {
        if (seen.contains(v)) return;
        seen.add(v); out.add(v);
        for (int w : g.getOrDefault(v, Collections.emptyList())) dfs(g, w, seen, out);
    }
}
