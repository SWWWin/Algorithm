import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class S2117 {

	static int N, M;
	static int[][] map;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		StringTokenizer st;
		
		
		for(int t = 1; t <= T; t ++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			map = new int[N][N];
			int answer = 1;
			
			for(int col = 0; col < N; col ++) {
				st = new StringTokenizer(br.readLine());
				for(int row = 0; row < N; row ++) {
					map[col][row] = Integer.parseInt(st.nextToken());
				}
			}
			
			for(int k = 2; k <= N + 1; k ++) {
				int cost = k * k + (k - 1) * (k - 1);
				for (int r = 0; r < N; r++) {
				    for (int c = 0; c < N; c++) {
				        int count = 0;
				        
				        for(int dr = -(k - 1); dr <= k - 1; dr ++) {
				        	int width = k - 1 - Math.abs(dr);
				        	
				        	for(int dc = -width; dc <= width; dc ++) {
				        		int nr = r + dr;
				        		int nc = c + dc;
				        		
				        		if(isVaild(nr, nc)) {
				        			count ++;
				        		}
				        	}
				        }
				        
				        if (count * M >= cost) {
			                answer = Math.max(answer, count);
			            }
				    }
				}
			}
			
			System.out.println("#" + t + " " + answer);
		}
	}
	
	static boolean isVaild(int x, int y) {
		if(x >= 0 && x < N && y >= 0 && y < N && map[x][y] == 1) {
			return true;
		}
		return false;
	}
}
