import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class P1767 {
	static int[][] arr;
	static int minScore;
	static int N;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		for(int t = 1; t <= T; t ++) {
			N = Integer.parseInt(br.readLine());
			minScore = Integer.MAX_VALUE;
			arr = new int[N][N];
			StringTokenizer st;
			ArrayList<int[]> core = new ArrayList<>();
			
			
			for(int h = 0; h < N; h ++) {
				st = new StringTokenizer(br.readLine());
				for(int w = 0; w < N; w ++) {
					arr[h][w] = Integer.parseInt(st.nextToken());
					
					if(arr[h][w] == 1) {
						int[] place = {h, w};
						core.add(place);
					}
				}
			}
			
			dfs(0,0,core);
		}
	}
	
	private static void dfs(int h, int w, ArrayList<int[]> core) {
		if(arr[h][w] != 0) return;
		
		for(int now = h; now < N; now ++) {
			arr[now][w] = 1;
		}
		dfs(h + 1, w + 1, core);
		for(int now = w; now < N; now ++) {
			arr[now][w] = 1;
		}
	}
}
