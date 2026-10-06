package S1251;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import java.util.Arrays;
import java.util.StringTokenizer;

class Edge {
	int to;
	int weight;
	public Edge(int to, int weight) {
		super();
		this.to = to;
		this.weight = weight;
	} 
	
}

public class S1251 {
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());
		
		for(int t = 1; t <= T; t ++) {
			int N = Integer.parseInt(br.readLine());

			
			long[] x = new long[N + 1];
			long[] y = new long[N + 1];
			
			st = new StringTokenizer(br.readLine());
			
			for(int i = 0; i < N; i ++) {
				x[i] = Integer.parseInt(st.nextToken()); // xÁÂÇ¥
				
			}
			
			st = new StringTokenizer(br.readLine());
			
			for(int i = 0; i < N; i ++) {
				y[i] = Integer.parseInt(st.nextToken()); // yÁÂÇ¥
				
			}
			
			double tax = Double.parseDouble(br.readLine());
			StringBuilder sb = new StringBuilder();
			sb.append("#").append(t).append(" ").append(Math.round(prim(N, x, y) * tax));
			System.out.println(sb);
		}
	}
	
	static long prim(int N, long[] x, long[] y) {

	    boolean[] visited = new boolean[N];
	    long[] minEdge = new long[N];

	    Arrays.fill(minEdge, Long.MAX_VALUE);

	    minEdge[0] = 0;

	    long sum = 0;

	    for (int count = 0; count < N; count++) {

	        int cur = -1;
	        long min = Long.MAX_VALUE;

	        for (int i = 0; i < N; i++) {

	            if (!visited[i] && minEdge[i] < min) {
	                min = minEdge[i];
	                cur = i;
	            }
	        }

	        visited[cur] = true;
	        sum += minEdge[cur];

	        for (int next = 0; next < N; next++) {

	            if (visited[next]) {
	                continue;
	            }

	            long dx = x[cur] - x[next];
	            long dy = y[cur] - y[next];

	            long weight = dx * dx + dy * dy;

	            if (weight < minEdge[next]) {
	                minEdge[next] = weight;
	            }
	        }
	    }

	    return sum;
	}
}
