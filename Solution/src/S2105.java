import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Set;
import java.util.StringTokenizer;

public class S2105 {
	
	public static int T = 10;
	public static int[][] map;
	public static int answer;
	public static int[] dr = {1, -1, 1, -1};
	public static int[] dc = {1, 1, -1, -1};
	public static int n;
	public static Set<Integer> deserts;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		br.readLine();
		
		for(int t = 1; t <= T; t ++) {
			n = Integer.parseInt(br.readLine());
			map = new int[n][n];
			answer = -1;
			
			for(int i = 0; i < n; i ++) {
				st = new StringTokenizer(br.readLine());
				for(int j = 0; j < n; j ++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			for(int rlength = 1; rlength < n; rlength ++) {
				 maxAdd(rlength, n - rlength);
			}
			
		}
	}
	private static void maxAdd(int rlength, int llength) {
		
	}
	
	private static boolean isVaild(int r, int c) {
		if(r >= 0 && r < n && c >= 0 && c < n) return true;
		return false;
	}
}
