import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class S9229 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		
		
		for(int t = 1; t <= T; t ++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			
			int[] weights = new int[N];
			
			st = new StringTokenizer(br.readLine());
			for(int n = 0; n < N; n ++) {
				weights[n] = Integer.parseInt(st.nextToken());
			}
			
			Arrays.sort(weights);
			
			int start = 0;
			int end = N - 1;
			int answer = 0;
			while(start < end) {
				int sum = weights[start] + weights[end];
				if(M < sum) {
					end --;
				} else {
					answer = Math.max(answer, sum);
					start ++;
				}
				System.out.println(start + " " + end);
			}
			
			answer = answer == 0? -1: answer;
			System.out.println("#" + t + " " + answer);
		}
	}
}
