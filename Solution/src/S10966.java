import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.StringTokenizer;

public class S10966 {
	static int[] dx = {-1, 1, 0, 0};
	static int[] dy = {0, 0, -1, 1};
	static int N;
	static int M;
	static boolean[][] visited;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		
		for(int t = 1; t <= T; t ++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			char[][] arr = new char[N][M];
			ArrayList<int[]> places = new ArrayList<>();
			
		
			
			for(int n = 0; n < N; n++) {
				String str = br.readLine();
				for(int m = 0; m < M; m ++) {
					arr[n][m] = str.charAt(m);
					if(arr[n][m] == 'L') {
						places.add(new int[] {n, m, 0});
					}
				}
			}
			
			int answer = 0;
			Queue<int[]> q;
			for(int[] place: places) {
				q = new ArrayDeque<>();
				
				q.add(place);
				
				visited = new boolean[N][M];
				
				visited[place[0]][place[1]] = true;
				
				while(!q.isEmpty()) {
					
					int[] now = q.poll();
					
					if(arr[now[0]][now[1]] == 'W') {
						answer += now[2];
						break;
					}
					else now[2] += 1;
					for(int dir = 0 ; dir < 4; dir ++) {
						int nr = now[0] + dx[dir];
						int nc = now[1] + dy[dir];
						
						if(isVaild(nr, nc)) {
							q.add(new int[] {nr, nc, now[2]});
							visited[nr][nc] = true;
						}
					}
				}
				

				
			}
			
			System.out.println("#" + t + " " + answer);
			
		}
	}
	
	public static boolean isVaild(int r, int c) {
		if(r >= 0 && r < N && c >= 0 && c < M && !visited[r][c]) return true;
		return false;
	}
}
