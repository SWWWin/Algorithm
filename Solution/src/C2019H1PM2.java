import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

import sun.security.krb5.internal.HostAddress;

// dfs로 후보 검색
// bfs로 횟수 검색

class Location{
	int r;
	int c;
	
	public Location(int r, int c) {
		this.r = r;
		this.c = c;
	}
}
public class C2019H1PM2 {
	static int N;
	static int M;
	static int[][] map;
	static boolean[][] visited;
	
	static int[] dr = {-1, 1, 0, 0};
	static int[] dc = {0, 0, -1, 1};
	
	static HashSet<Location> locs ;
 	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		int[][] map = new int[N][N];
		boolean[][] visited = new boolean[N][N];
		locs = new HashSet<>();
		for(int r = 0; r < N; r ++) {
			st = new StringTokenizer(br.readLine());
			for(int c = 0; c < N; c ++) {
				map[r][c] = Integer.parseInt(st.nextToken());
				if(map[r][c] == 0) {
					visited[r][c] = true;
				} else if(map[r][c] == 2) {
					locs.add(new Location(r, c));
				}
			}
		}
		
		HashSet<Location> pickHos = dfs(0, new HashSet<>());
		
		
		
	}
	
	public static HashSet<Location> dfs(int depth, HashSet<Location> pickHos) { // 후보 검색 후 횟수 검색으로 넘김
		
		if(depth == M) {
			return pickHos;
		}
		
		for(int i = 0; )
	}
	
	
}
