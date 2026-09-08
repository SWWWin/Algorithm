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

			visited = new boolean[9];
			permutation(0, 0, 0, 0);
			
			int q = 1;
			
			for(int i = 1; i <= 9; i ++) {
				q *= i;
			}
			System.out.println("#" + test_case + " " + win + " " + (q - win));
		}
		
	}
	
	static void permutation(int cnt, int flag, int kScore, int iScore) {
		if(cnt == 9) {
			if(kScore > iScore) {
				++win;
			}
			return;
		}
		for (int i = 0; i < 9; i++) { // i: 선택할 수의 인덱스
			if((flag & 1 << i) != 0) continue; // i위치의 비트가 켜있다. 그러면 사용 중인 수이니 패스
			
			int sum = ky_card[cnt] + iy_card[i];
			permutation(cnt + 1, flag | 1 << i, kScore + ky_card[cnt]>iy_card[i]? sum: 0, iScore+(ky_card[cnt] < iy_card[i]? sum: 0));
		}
	}
	
//	private static void dfs(int depth, int score) {
//		if (depth == 9) {
//			if (score >= 86) {
//				win++;
//			}
//			return;
//		}
//
//		for (int i = 0; i < 9; i++) {
//			if (visited[i]) continue;
//
//			visited[i] = true;
//
//			if (ky_card[depth] > iy_card[i]) {
//				dfs(depth + 1, score + ky_card[depth] + iy_card[i]);
//			} else {
//				dfs(depth + 1, score);
//			}
//
//			visited[i] = false;
//		}
//	}
}
