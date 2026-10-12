import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Knight {
	int r;
	int c;
	int h;
	int w;
	int k;
	
	public Knight(int r, int c, int h, int w, int k) {
		super();
		this.r = r;
		this.c = c;
		this.h = h;
		this.w = w;
		this.k = k;
	}
}

public class C2023H2AM1 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int L = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(st.nextToken());
		int Q = Integer.parseInt(st.nextToken());
		
		int[][] map = new int[L+ 1][L + 1];
		
		for(int i = 1; i <= L; i ++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 1; j <= L; j ++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		Knight[] knights = new Knight[N];
		
		for(int n = 0; n < N; n ++) {
			st = new StringTokenizer(br.readLine());
			int r = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			int h = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			int k = Integer.parseInt(st.nextToken());
			
			knights[n] = new Knight(r, c, h, w, k);
		}
		
		int[][] arr = new int[Q][2];
		
		for(int q = 0; q < Q; q ++) {
			st = new StringTokenizer(br.readLine());
			arr[q][0] = Integer.parseInt(st.nextToken());
			arr[q][1] = Integer.parseInt(st.nextToken());
		}
		
		
	}
}
