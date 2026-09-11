import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class S1486 {
	static int N, B, min;
	static int[] arr;
	static boolean[] visited;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb;
		int T = Integer.parseInt(br.readLine());
		
		StringTokenizer st;
		for(int t = 1; t <= T; t ++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			B = Integer.parseInt(st.nextToken());
			
			arr = new int[N];
			visited = new boolean[N];
			
			st = new StringTokenizer(br.readLine());
			
			for(int n = 0; n < N; n ++) {
				arr[n] = Integer.parseInt(st.nextToken());
			}
			
			
			min = Integer.MAX_VALUE;
			dfs(0, 0);
			sb = new StringBuilder();
			sb.append("#").append(t).append(" ").append(min - B);
			System.out.println(sb);
			
		}
	}
	private static void dfs(int search, int sum) {
		
		if(sum >= B) {
			min = Math.min(min, sum);
			return;
		}
		
		if (search == N) {
	        return;
	    }

		    dfs(search + 1, sum + arr[search]);

		    dfs(search + 1, sum);
		
		return;
	}
}
