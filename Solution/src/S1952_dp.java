import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class S1952_dp {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for(int t = 1; t <= T; t ++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			int day = Integer.parseInt(st.nextToken());
			int month = Integer.parseInt(st.nextToken());
			int threeMonth = Integer.parseInt(st.nextToken());
			int year = Integer.parseInt(st.nextToken());
			
			int[] use = new int[12];
			
			st = new StringTokenizer(br.readLine());
			for(int i = 0; i < 12; i ++) {
				use[i] = Integer.parseInt(st.nextToken());
			}
			
			int[] dp = new int[13];
			
			for(int i = 1; i <= 12; i ++) {
				dp[i] = Math.min(dp[i -1] + use[i -1] * day, dp[i - 1] + month);
				dp[i] = Math.min(dp[i], dp[i >= 0 ? i : 0] + threeMonth);
			}
			
			int answer = Math.min(dp[12], year);
			
			System.out.println("#" + t + " " + answer);
		}
	}
}
