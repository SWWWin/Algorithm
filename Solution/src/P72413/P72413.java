package P72413;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

class Edge {
	int to, weight;
	Edge(int to, int weight) {
		this.to = to;
		this.weight = weight;
	}
}

public class P72413 {
    public int solution(int n, int s, int a, int b, int[][] fares) {
    	
    	List<Edge>[] graph = new ArrayList[n];
    	
    	for(int i = 0; i < n ; i++) {
    		graph[i] = new ArrayList<Edge>();
    	}
    	
    	for(int[] fare: fares) {
    		int from = fare[0] - 1;
    		int to = fare[1] - 1;
    		int weight = fare[2];
    		
    		graph[from].add(new Edge(to, weight));
    		graph[to].add(new Edge(from, weight));
    	}
        
    	s--;
    	a--;
    	b--;
    	
	   int[] fromS = dijkstra(graph, s, n);
       int[] toA = dijkstra(graph, a, n);
       int[] toB = dijkstra(graph, b, n);

       int minValue = Integer.MAX_VALUE;

       for (int i = 0; i < n; i++) {
           minValue = Math.min(
               minValue,
               fromS[i] + toA[i] + toB[i]
           );
       }

       return minValue;
    }
    
    static int[] dijkstra(List<Edge>[] graph, int start, int n) {
    	int[] dist = new int[n];
    	Arrays.fill(dist, Integer.MAX_VALUE);
    	dist[start] = 0;
    	
    	PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> Integer.compare(a[1], b[1]));
    	pq.offer(new int[] {start, 0});
    	
    	while(!pq.isEmpty()) {
    		int[] cur = pq.poll();
    		int u = cur[0], d = cur[1];
    		
    		if(d != dist[u]) continue;
    		
    		for(Edge e : graph[u]) {
    			if(dist[u] + e.weight < dist[e.to]) {
    				dist[e.to] = dist[u] + e.weight;
    				pq.offer(new int[] {e.to, dist[e.to]});
    			}
    		}
    	}
		return dist;
    	
    }
}
