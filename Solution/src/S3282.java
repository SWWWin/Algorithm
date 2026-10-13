import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class S3282 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for(int t = 1; t <= T; t ++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int K = Integer.parseInt(st.nextToken());
			
			int[][] arr = new int[N + 1][2];
			int[][] knapsack = new int[N + 1][K + 1];
			
			for(int n = 1; n <= N; n ++) {
				st = new StringTokenizer(br.readLine());
				arr[n][0] = Integer.parseInt(st.nextToken());
				arr[n][1] = Integer.parseInt(st.nextToken());
			}
			
			for(int n = 1; n <= N; n ++) {
				for(int k = 1; k <= K; k ++) {
					if(arr[n][0] > k) {
						knapsack[n][k] = knapsack[n - 1][k];
					} else {
						knapsack[n][k] = Math.max(knapsack[n-1][k], knapsack[n-1][k - arr[n][0]] + arr[n][1]);
					}
				}
			}
			System.out.println("#" + t + " " + knapsack[N][K]);
		}
	}
}
