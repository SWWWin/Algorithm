import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class S1952_DFS {
	static int[] use;
	static int day, month, threeMonth, year;
	static int answer;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for(int t = 1; t <= T; t ++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			day = Integer.parseInt(st.nextToken());
			month = Integer.parseInt(st.nextToken());
			threeMonth = Integer.parseInt(st.nextToken());
			year = Integer.parseInt(st.nextToken());
			
			use = new int[12];
			answer = Integer.MAX_VALUE;
			
			st = new StringTokenizer(br.readLine());
			for(int i = 0; i < 12; i ++) {
				use[i] = Integer.parseInt(st.nextToken());
			}
			
			dfs(0, 0);
			
			System.out.println("#" + t + " " + answer);
		}
	}
	private static void dfs(int now, int cost) {
		if(cost >= answer) return;
		if(now >= 12) {
			answer = Math.min(answer, cost);
			return;
		}
		
		dfs(now + 1, cost + use[now] * day);
		dfs(now + 1, cost + month);
		dfs(now + 3, cost + threeMonth);
		dfs(12, cost + year);
	}
}
