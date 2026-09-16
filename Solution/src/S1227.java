import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

class Node {
	int row;
	int col;
	
	public Node(int row, int col) {
		super();
		this.row = row;
		this.col = col;
	}
}

public class S1227 {
	static int N = 100;
	static int[][] map;
	static boolean[][] visited;
	
	static int[] dc = {-1, 1, 0, 0};
	static int[] dr = {0, 0, -1, 1};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb;
		for(int t = 1; t <= 10; t ++) {
			br.readLine();
			
			map = new int[N][N];
			visited = new boolean[N][N];
			boolean answer = false;
			
			Node start = new Node(0,0);
			for(int c = 0; c < N; c ++) {
				String str = br.readLine();
				for(int r = 0; r < N; r ++) {
					map[c][r] = str.charAt(r) - '0';
					
					if(map[c][r] == 2) {
						start.col = c;
						start.row = r;
					}
				}
			}
			
			Queue<Node> q = new ArrayDeque<>();
			
			
			q.add(start);
			visited[start.col][start.row] = true;
			
			while(!q.isEmpty()) {
				
				Node now = q.poll();
				
				if(map[now.col][now.row] == 3) {
					answer = true;
					break;
				}
				
				for(int d = 0; d < 4; d ++) {
					int nc = now.col + dc[d];
					int nr = now.row + dr[d];
					
					if(nc >= N || nc < 0 || nr >= N || nr < 0 || visited[nc][nr] || map[nc][nr] == 1) continue;
					
					Node nowNode = new Node(nr, nc);
					q.add(nowNode);
					visited[nc][nr] = true;
				}
			}
			
			sb = new StringBuilder();
			sb.append("#").append(t).append(" ").append(answer? 1: 0);
			System.out.println(sb);
			
		}
	}
}
