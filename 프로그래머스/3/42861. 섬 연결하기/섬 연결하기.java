import java.util.*;

class Solution {
    public int solution(int n, int[][] costs) {
        List<Edge> edges = new ArrayList<>();
        for (int i = 0; i < costs.length; i++) {
            int from = costs[i][0];
            int to = costs[i][1];
            int cost = costs[i][2];
            edges.add(new Edge(from, to, cost));
        }
        
        Collections.sort(edges);
        int count = 0;
        int res = 0;
        int[] parents = new int[n];
        for (int i=  0; i < n; i++) {
            parents[i] = i;
        }
        
        for (Edge edge : edges) {
            int from = edge.from;
            int to = edge.to;
            int cost = edge.cost;
            if (find(parents, from) != find(parents, to)) {
                count++;
                union(parents, from ,to);
                res += cost;
            }
            if (count == n-1) {
                break;
            }
        }
        
        return res;   
    }
    
    private int find(int[] parents, int x) {
        if (parents[x] != x) {
            parents[x] = find(parents, parents[x]);
        }
        return parents[x];
    }
    
    private void union(int[] parents, int x, int y) {
        x = find(parents, x);
        y = find(parents, y);
        if (x > y) {
            parents[x] = y;
        } else {
            parents[y] = x;
        }
    }
    
}

class Edge implements Comparable<Edge> {
    int from;
    int to;
    int cost;
    
    public Edge(int from, int to, int cost) {
        this.from = from;
        this.to = to;
        this.cost = cost;
    }
    
    public int compareTo(Edge o) {
        return cost - o.cost;
    }
}