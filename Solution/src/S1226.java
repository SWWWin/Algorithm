import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class S1226 {
	static boolean[][] visited;
	static int[][] arr;
	final static int N = 16;
	static int[] dC = {-1, 1, 0, 0};
	static int[] dR = {0, 0, -1, 1};
	
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for(int test_case = 1; test_case <= 10; test_case ++) {
			
			arr = new int[N][N];
			int[] start = new int[2];
			visited = new boolean[N][N];
			

			br.readLine();
			for(int c = 0; c < N; c ++) {
				
				String token = br.readLine();
				for(int r = 0; r < N; r ++) {
					arr[c][r] = token.charAt(r) - '0';
					if(arr[c][r] == 2) {
						start[0] = c;
						start[1] = r;
					}
				}
			}
			
			int answer = dfs(start[0], start[1]);
			System.out.println("#" + test_case + " " + answer);
		}
		
	}

	private static int dfs(int col, int row) {
		Deque<int[]> stack = new ArrayDeque<>();
		
		stack.push(new int[] {col, row});
		visited[col][row] = true;
		
		while(!stack.isEmpty()) {
			int[] cur = stack.pop();
			
			int c = cur[0];
			int r = cur[1];
			
			if(arr[c][r] == 3) {
				return 1;
			}
			
			for(int i = 0; i < 4; i ++) {
				int nextC = c + dC[i];
				int nextR = r + dR[i];
				
				if (nextC < 0 || nextC >= N ||nextR < 0 || nextR >= N) {
				    continue;
				}
				
				if(arr[nextC][nextR] == 1) {
					continue;
				}
				
				if(visited[nextC][nextR]) {
					continue;
				}
				
				
				stack.push(new int[] {nextC, nextR});
				visited[nextC][nextR] = true;
			}
			
			
		}
	
		return 0;
	}
}
