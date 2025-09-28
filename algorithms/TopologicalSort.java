package algorithms;

import java.util.*;

public class TopologicalSort {
    public static List<Integer> sort(Map<Integer, List<Integer>> g) {
        Map<Integer,Integer> indeg = new HashMap<>();
        for (int v : g.keySet()) indeg.putIfAbsent(v, 0);
        for (var entry: g.entrySet()) {
            for (int w : entry.getValue()) indeg.put(w, indeg.getOrDefault(w, 0) + 1);
        }
        Deque<Integer> q = new ArrayDeque<>();
        for (var e: indeg.entrySet()) if (e.getValue() == 0) q.add(e.getKey());
        List<Integer> order = new ArrayList<>();
        while (!q.isEmpty()) {
            int v = q.remove();
            order.add(v);
            for (int w : g.getOrDefault(v, Collections.emptyList())) {
                indeg.put(w, indeg.get(w) - 1);
                if (indeg.get(w) == 0) q.add(w);
            }
        }
        if (order.size() != indeg.size()) throw new IllegalStateException("Graph has a cycle");
        return order;
    }
}
