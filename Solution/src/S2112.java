import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class S2112 {
	static int[][] film;
	static int D, W, K;
	static int answer;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		
		for(int t = 1; t <= T; t ++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			D = Integer.parseInt(st.nextToken()); // 두께
			W = Integer.parseInt(st.nextToken()); // 가로 크기
			K = Integer.parseInt(st.nextToken()); // 합격 기준
			
			film = new int[D][W];
			answer = K;
			
			for(int d = 0; d < D; d ++) {
				st = new StringTokenizer(br.readLine());
				for(int w = 0; w < W; w ++) {
					film[d][w] = Integer.parseInt(st.nextToken());
				}
			}
			
			dfs(0, 0);
			
			System.out.println("#" + t + " " + answer);
						
		}
	}
	
	private static void dfs(int depth, int change) {
		if(change >= answer) return;
		
	    if (depth == D) {
	        if (check(film)) {
	            answer = Math.min(answer, change);
	        }
	        return;
	    }
	    
	    int[] original = film[depth].clone();
	    
	    // 1. 현재 행을 변경하지 않음
	    dfs(depth + 1, change);

	    // 2. 현재 행을 A(0)로 변경
	    Arrays.fill(film[depth], 0);
	    dfs(depth + 1, change + 1);

	    // 3. 현재 행을 B(1)로 변경
	    Arrays.fill(film[depth], 1);
	    dfs(depth + 1, change + 1);

	    // 원래 행 복구
	    film[depth] = original;
	}

	static boolean check(int[][] film) {
		if (K == 1) return true;
	    for (int w = 0; w < W; w++) {
	        int passCheck = 1;
	        boolean pass = false;

	        for (int d = 1; d < D; d++) {

	            if (film[d][w] == film[d - 1][w]) {
	                passCheck++;
	            } else {
	                passCheck = 1;
	            }

	            if (passCheck >= K) {
	                pass = true;
	                break;
	            }
	        }

	        if (!pass) return false;
	    }

	    return true;
	}
}
