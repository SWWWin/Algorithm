import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;
// 모든 땅마다 하면 n * m * m의 시간 복잡도를 가져서 시간 초과가 난다....
/*
 * 다중 시작점을 가진다고 생각하고 bfs를 수행!
 * 
 * 
 */
public class S10966 {
	static int[] dx = {-1, 1, 0, 0};
	static int[] dy = {0, 0, -1, 1};
	static int N;
	static int M;
	static char[][] arr;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		
		for(int t = 1; t <= T; t ++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			arr = new char[N][M];
			ArrayList<int[]> places = new ArrayList<>();
			int[][] minVisit = new int[N][M];
		
			
			for(int n = 0; n < N; n++) {
				String str = br.readLine();
				for(int m = 0; m < M; m ++) {
					minVisit[n][m] = Integer.MAX_VALUE;
					arr[n][m] = str.charAt(m);
					if(arr[n][m] == 'W') {
						places.add(new int[] {n, m, 0});
						minVisit[n][m] = 0;
					}
				}
			}
			
			int answer = 0;
			Queue<int[]> q = new ArrayDeque<>();
			for(int[] place: places) {
				q.add(place);
			}
			
			
			
			while(!q.isEmpty()) {
				
				int[] now = q.poll();
				
		
				for(int dir = 0 ; dir < 4; dir ++) {
					int nr = now[0] + dx[dir];
					int nc = now[1] + dy[dir];
					
					if(isVaild(nr, nc)&& minVisit[nr][nc] == Integer.MAX_VALUE) {
						q.add(new int[] {nr, nc, now[2] + 1});
						minVisit[nr][nc] = now[2] + 1;
					}
				}

			}

			for(int n = 0; n < N; n ++) {
				for(int m = 0; m < M; m ++) {
					if(arr[n][m] == 'L') {
						answer += minVisit[n][m];
					}
				}
			}
			System.out.println("#" + t + " " + answer);
			
		}
	}
	
	public static boolean isVaild(int r, int c) {
		if(r >= 0 && r < N && c >= 0 && c < M && arr[r][c] == 'L') return true;
		return false;
	}
}
