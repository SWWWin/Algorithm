import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.StringTokenizer;

public class S10966 {
	static int[] dx = {-1, 1, 0, 0};
	static int[] dy = {0, 0, -1, 1};
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		
		for(int t = 1; t <= T; t ++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			char[][] arr = new char[N][M];
			ArrayList<int[]> places = new ArrayList<>();
			
		
			
			for(int n = 0; n < N; n++) {
				String str = br.readLine();
				for(int m = 0; m < M; m ++) {
					arr[n][m] = str.charAt(m);
					if(arr[n][m] == 'L') {
						places.add(new int[] {n, m});
					}
				}
			}
			
			Queue<int[]> q;
			for(int[] place: places) {
				q = new ArrayDeque<>();
				
				q.add(place);
				
				boolean visied ;
				
			}
			
		}
	}
}
