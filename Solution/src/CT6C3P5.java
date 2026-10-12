import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

import javax.management.Query;

public class CT6C3P5 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		int[][] arr = new int[M][2];
		
		for(int m = 0; m < M; m ++) {
			st = new StringTokenizer(br.readLine());
			arr[m][0] = Integer.parseInt(st.nextToken());
			arr[m][1] = Integer.parseInt(st.nextToken());
		}
		
		List<Integer>[] graph = new List[N + 1];
		
		for(int n = 1; n <= N; n ++) {
			graph[n] = new ArrayList<Integer>();
		}
		
		int left = 1;
		int right = M;
		int answer = -1;
		
		
		while(left <= right) {
			int mid = (left + right) / 2;
			
			int[] indegree = new int[N + 1];
			
			for(int n = 1; n <= N; n ++) {
				graph[n].clear();
			}
			
			for(int m = 0; m < mid; m ++) {
				int a = arr[m][0];
				int b = arr[m][1];
				
				graph[a].add(b);
				indegree[b] ++;
			}
			
			Queue<Integer> q = new ArrayDeque<>();
			
			for(int n = 1; n <= N; n ++) {
				if(indegree[n] == 0) q.offer(n);
			}
			
			int count = 0;
			
			while(!q.isEmpty()) {
				int now = q.poll();
				count ++;
				
				for(int next: graph[now]) {
					indegree[next] --;
					
					if(indegree[next] == 0) {
						q.offer(next);
					}
				}
				
			}
			
			if(count < N) {
				answer = mid;
				right = mid - 1;
			} else {
				left = mid + 1;
			}
			
		}
		System.out.println(answer == -1 ? "Consistent": answer);
		
	}
}
