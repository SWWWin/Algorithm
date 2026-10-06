package P118669;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

class Edge {
	int to;
	int weight;
	
	public Edge(int to, int weight) {
		super();
		this.to = to;
		this.weight = weight;
	}
}

public class P118669 {
	public int[] solution(int n, int[][] paths, int[] gates, int[] summits) {
        
        Arrays.sort(summits);
        ArrayList<Edge>[] graph = new ArrayList[n + 1];
        
        for(int i = 1; i <= n; i ++) {
        	graph[i] = new ArrayList<>();
        }
        
        for(int p = 0; p < paths.length; p ++) {
        	int from = paths[p][0];
        	int to = paths[p][1];
        	int weight = paths[p][2];
        	
        	graph[from].add(new Edge(to, weight));
        	graph[to].add(new Edge(from, weight));
        }
        
        int[] intensity = new int[n + 1];
        Arrays.fill(intensity, Integer.MAX_VALUE);
        
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> Integer.compare(a[1], b[1]));
        
        for(int gate: gates) {
        	intensity[gate] = 0;
        	pq.offer(new int[] {gate, 0});
        }
        
        boolean[] isSummit = new boolean[n + 1];
        for(int s: summits) {
        	isSummit[s] = true;
        }
        
        while(!pq.isEmpty() ) {
        	int[] cur = pq.poll();
        	
        	int now = cur[0];
        	int curIn = cur[1];
        	
        	if(curIn != intensity[now]) {
        		continue;
        	}
        	
        	if(isSummit[now]) {
        		continue;
        	}
        	
        	for(Edge edge: graph[now]) {
        		int nextIn = Math.max(curIn, edge.weight);
        		
        		if(nextIn < intensity[edge.to]) {
        			intensity[edge.to] = nextIn;
        			
        			pq.offer(new int[] {edge.to, nextIn});
        		}
        	}
        }
        
        int minSummit = 0;
        int minIntensity = Integer.MAX_VALUE;

        for (int summit : summits) {
            if (intensity[summit] < minIntensity) {
                minSummit = summit;
                minIntensity = intensity[summit];
            }
        }

        return new int[] {minSummit, minIntensity};
        
    }
}
