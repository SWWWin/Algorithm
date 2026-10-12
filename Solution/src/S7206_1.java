import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class S7206_1 {

    static HashMap<Long, Integer> memo;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for(int i = 1; i < T; i ++) {
            long N = Long.parseLong(br.readLine());

            memo = new HashMap<>();

            int answer = dfs(N);
            System.out.println("#" + i + " " + answer);
        }
    }

    static int dfs(long N) {
        if(N < 10) {
            return 0;
        }

        if(memo.containsKey(N)) {
            return memo.get(N);
        }

        int max = 0;
        String str = String.valueOf(N);

        for(int i = 1; i < str.length(); i ++) {
            long left = Integer.parseInt(str.substring(0, i));
            long right = Integer.parseInt(str.substring(i));

            long next = left * right;

            int count = 1 + dfs(next);

            max = Math.max(max, count);
        }

        memo.put(N, max);
        return max;
    }
}
