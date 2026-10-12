package S3952;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class S3952 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb;
		int T = Integer.parseInt(br.readLine());
		
		for(int t = 1; t <= T; t ++) {
			sb = new StringBuilder();
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			
			int[] indegree = new int[N + 1];
			List<Integer>[] graph = new List[N + 1];
			
			for(int n = 1; n <= N; n ++) {
				graph[n] = new ArrayList<Integer>();
			}
			
			for(int m = 0; m < M; m ++) {
				st = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				graph[a].add(b);
				indegree[b] ++;
			}
			
			Queue<Integer> q = new ArrayDeque<Integer>();
			for(int n = 1; n <= N; n ++) {
				if(indegree[n] == 0) q.offer(n);
			}
			
			sb.append("#").append(t).append(" ");
			while(!q.isEmpty()) {
				int now = q.poll();
				sb.append(now).append(" ");
				for(int g: graph[now]) {
					indegree[g] --;
					
					if(indegree[g] == 0) {
						q.offer(g);
					}
				}
			}
			
			System.out.println(sb);
		}
	}
}
