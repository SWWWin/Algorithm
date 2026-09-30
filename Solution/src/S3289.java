import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class S3289 {
	static int[] parents;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb;
		int T = Integer.parseInt(br.readLine());
		
		for(int t = 1; t <= T; t ++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			sb = new StringBuilder();
			parents = new int[N + 1];
			
			for (int i = 1; i <= N; i++) {
			    parents[i] = i;
			}
			
			sb.append("#").append(t).append(" ");
			
			for(int m = 0; m < M; m ++) {
				st = new StringTokenizer(br.readLine());
				int operation = Integer.parseInt(st.nextToken());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				

				if(operation == 0) {
					union(a,b);
				} else {
					if(find(a) == find(b)) {
						sb.append(1);
					} else {
						sb.append(0);
					}
				}
				
				
			}
			
			System.out.println(sb);
		}
	}
	
	static int find(int x) {
		if(parents[x] == x) return x;
		return parents[x] = find(parents[x]);
	}
	
	static void union(int x, int y) {
		
		int px = find(x);
		int py = find(y);
		
		if(px == py) return;
		parents[py] = px;
	}
}
