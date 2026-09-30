import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

class Edge {
	int from;
	int to;
	int weight;
	
	public Edge(int from, int to, int weight) {
		super();
		this.from = from;
		this.to = to;
		this.weight = weight;
	}
	
}

public class C2025ACPC {
	static int[] parents;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		parents = new int[N + 1];
		Edge[] edges = new Edge[M]; 
		
		for(int n = 1; n <= N; n ++) {
			parents[n] = n;
		}
		
		for(int m = 0; m < M; m ++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());
			
			edges[m] = new Edge(from, to, weight);
		}
		
		Arrays.sort(edges, (a, b) -> a.weight - b.weight);
		
		int mstNext = 1, edgeCount = 0;
		int playerNext = 1;
		
		for(Edge edge: edges) {
			if(mstNext == playerNext) continue;
			else {
				break;
			}
			
			
			if(union(edge.from, edge.to)) {
				edgeCount ++;
				mstNext = edge.to;
				if(edgeCount == N - 1) break;
			} 
			
			int minWay = 0;
			for(Edge e: edges) {
				if(edge.from == playerNext && minWay > edge.weight) {
					minWay = Math.min(minWay, edge.weight);
					playerNext = edge.to;
				}
			}
			
		}
		
	}

	public static int find(int x) {
		if(parents[x] == x) return parents[x];
		return parents[x] = find(parents[x]);
	}
	
	public static boolean union(int x, int y) {
		int px = find(x);
		int py = find(y);
		if(px == py) return false;
		
		parents[py] = px;
		return true;
	}
}