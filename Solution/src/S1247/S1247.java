package S1247;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class Edge {
	int weight;
	Edge next;
	
	public Edge(int weight, Edge next) {
		super();
		this.weight = weight;
		this.next = next;
	}
	
}

public class S1247 {
	static int minDis;
	static boolean[] visited;
	static int[][] cus;
	static int comX, comY, homeX, homeY, N;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		
		for(int t = 1; t <= T; t ++) {
			N = Integer.parseInt(br.readLine());
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			comX = Integer.parseInt(st.nextToken());
			comY = Integer.parseInt(st.nextToken());
			homeX = Integer.parseInt(st.nextToken());
			homeY = Integer.parseInt(st.nextToken());
			
			cus = new int[N][2];
			minDis = Integer.MAX_VALUE;
			visited = new boolean[N];
			
			
			for(int n = 0; n < N; n ++) {
				cus[n][0] = Integer.parseInt(st.nextToken());
				cus[n][1] = Integer.parseInt(st.nextToken());
			}
			
			dfs(0, comX, comY, 0);
			System.out.println("#" + t + " " + minDis);
		}
	}
	private static void dfs(int depth, int x, int y, int add) {
		if(add >= minDis) {
            return;
        }
		
		if(depth == N) {
			add += Math.abs(x - homeX) + Math.abs(y - homeY);
			
			minDis = Math.min(minDis, add);
			
			return;
		}
		
		for(int i = 0; i < N; i ++) {
			if(visited[i]) continue;
			
			visited[i] = true;
			
			int nextX = cus[i][0];
			int nextY = cus[i][1];
			
			int distance = Math.abs(x - nextX) + Math.abs(y - nextY);
			dfs(depth + 1, nextX, nextY, distance + add);
			visited[i] = false;
		}
		
		
		
	}
}
