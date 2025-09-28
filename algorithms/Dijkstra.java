package algorithms;

import java.util.*;

public class Dijkstra {
    public static class Edge { public final int to; public final int w; public Edge(int t, int w){ this.to=t; this.w=w; } }
    public static Map<Integer,Integer> shortestPath(Map<Integer, List<Edge>> g, int s) {
        Map<Integer,Integer> dist = new HashMap<>();
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));
        dist.put(s, 0); pq.add(new int[]{s, 0});
        while(!pq.isEmpty()) {
            int[] cur = pq.poll();
            int v = cur[0], d = cur[1];
            if (d != dist.get(v)) continue;
            for (Edge e: g.getOrDefault(v, Collections.emptyList())) {
                int nd = d + e.w;
                if (!dist.containsKey(e.to) || nd < dist.get(e.to)) {
                    dist.put(e.to, nd);
                    pq.add(new int[]{e.to, nd});
                }
            }
        }
        return dist;
    }
}
