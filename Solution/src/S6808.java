import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class S6808 {
	static int[] ky_card;
	static int[] iy_card;
	static boolean[] visited;
	static int win;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		
		int T = Integer.parseInt(br.readLine());
		
		for(int test_case = 1; test_case <= T; test_case ++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			ky_card = new int[9];
			iy_card = new int[9];
			boolean[] cnt = new boolean[19];
			win = 0;
			
			for(int card = 0; card < 9; card ++) {
				ky_card[card] = Integer.parseInt(st.nextToken());
				cnt[ky_card[card]] = true;
			}
			
			 
			for(int i = 1, index = 0; i <= 18; i ++) {
				if(!cnt[i]) {
					iy_card[index] = i;
					index ++;
				}
			}
			
			for(int i = 0; i < 9; i ++) {
				visited = new boolean[9];
				dfs(i, 0, 0);
			}
			
			int q = 1;
			
			for(int i = 1; i <= 9; i ++) {
				q *= i;
			}
			System.out.println("#" + test_case + " " + win + " " + (q - win));
		}
		
	}
	private static void dfs(int i, int depth, int score) {
		 
		if(depth == 8) {
			score += ky_card[depth] > iy_card[i]? ky_card[depth] + iy_card[i] : 0;
			if(score >= 86) {
				win ++;
			}
			return;
		}
		
		if(visited[i]) return;
		
		
		
		score += ky_card[depth] > iy_card[i]? ky_card[depth] + iy_card[i] : 0;
		visited[i] = true;
		
		for(int k = 0; k < 9; k ++) {
			if(!visited[k]) {
				dfs(k, depth + 1, score);
			}
			
			
		}
		
		visited[i] = false;
		
	}
}
