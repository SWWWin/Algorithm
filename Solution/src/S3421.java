import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class S3421 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int TC = Integer.parseInt(br.readLine());
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		int[][] arr = new int[M][2];
		
		for(int m = 0; m < M; m ++) {
			st = new StringTokenizer(br.readLine());
			arr[m][0] = Integer.parseInt(st.nextToken());
			arr[m][1] = Integer.parseInt(st.nextToken());
		}
		
		
	}
}
