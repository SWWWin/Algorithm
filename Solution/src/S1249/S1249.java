package S1249;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;

import com.sun.imageio.plugins.common.InputStreamAdapter;

public class S1249 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		
		for(int t = 1; t <= T; t ++) {
			int N = Integer.parseInt(br.readLine());
			
			int[][] map = new int[N][N];
			
			for(int i = 0; i < N; i ++) {
				String str = br.readLine();
				for(int j = 0; j < N; j ++) {
					map[i][j] = str.charAt(j) - '0';
				}
			}
			
			int[][] dist = new int[N][N];
			

			for (int i = 0; i < N; i++) {
			    Arrays.fill(dist[i], Integer.MAX_VALUE);
			}
			int answer = 0;
			PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> Integer.compare(a[2], b[2]));
			
			pq.offer(new int[] {0, 0});
			
			while(!pq.isEmpty()) {
				int[] now = pq.poll();
				int nx = now[0];
				int ny = now[1];
				int restore = now[2];
				
				if(now[0] == N - 1 && now[1] == N - 1) {
					answer = restore;
					break;
				}
				
				
			}
			
			System.out.println("#" + t + " " + answer);
		}
	}
}
