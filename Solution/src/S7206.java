import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;


public class S7206 {
	static String start;
	static int answer;
	static Map<String, Integer> visited;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		
		for(int t = 1; t <= T; t ++) {
			start = br.readLine();
			answer = 0;
			StringBuilder sb = new StringBuilder();
			visited = new HashMap<>();
			
			if(start.length() == 1) {
				answer  = 0;
			} else {
				answer = solve(start);
			}
			
			sb.append("#").append(t).append(" ").append(answer);
			System.out.println(sb);
		}
		
		
	}
	

	private static int solve(String num) {
	    if(num.length() == 1) return 0;

	    if(visited.containsKey(num)) {
	        return visited.get(num);
	    }

	    int result = dfs(num, 1, 1, num.charAt(0) - '0', false);

	    visited.put(num, result);
	    return result;
	}
	
	
	private static int dfs(String num, int i, int left, int right, boolean cut) {
	    if(i == num.length()) {
	        if(!cut) return 0;

	        String result = Integer.toString(left * right);

	        return 1 + solve(result);
	    }

	    int digit = num.charAt(i) - '0';

	    int noCut = dfs(num, i + 1, left, right * 10 + digit, cut);
	    int doCut = dfs(num, i + 1, left * right, digit, true);

	    return Math.max(noCut, doCut);
	}
}
