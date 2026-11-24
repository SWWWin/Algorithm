import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.StringTokenizer;

public class S2819 {
	static int[][] map;
	static int SIZE = 4;
	static int DEPTH = 6;
	
	static int[] dr = {1, -1, 0, 0};
	static int[] dc = {0, 0, 1, -1}; 
	static HashSet<String> makeNum;
	
 	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());
		
		for(int t = 1; t <= T; t ++) {
			makeNum = new HashSet<>();
			map = new int[SIZE][SIZE];
			
			for(int r = 0; r < SIZE; r ++) {
				st = new StringTokenizer(br.readLine());
				for(int c = 0; c < SIZE; c ++) {
					map[r][c] = Integer.parseInt(st.nextToken());
				}
			}
			
			for (int r = 0; r < SIZE; r++) {
			    for (int c = 0; c < SIZE; c++) {
			        dfs(0, r, c, "");
			    }
			}

			
			System.out.println("#" + t + " " + makeNum.size());
		}
		
		
		
	}

	private static void dfs(int depth, int r, int c, String nowMakeStr) {
		nowMakeStr += map[r][c];
		if(depth == DEPTH) {
			if(!makeNum.contains(nowMakeStr)) {
				makeNum.add(nowMakeStr);
				System.out.println(nowMakeStr);
			}
			
			return;
		}
		
		for(int dir = 0; dir < 4; dir ++) {
			if(isValid(r + dr[dir], c + dc[dir])) {
				dfs(depth + 1, r + dr[dir], c + dc[dir], nowMakeStr);
			}
		}
		
	
		
	}
	
	private static boolean isValid(int r, int c) {
		if(r >= 0 && r < SIZE && c >= 0 && c < SIZE) return true;
		return false;
	}
}
