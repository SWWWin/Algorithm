import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class S1486_1 {
    static int[] heights;
    static int B, N;
    static int answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for(int t = 1; t <= T; t ++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            B = Integer.parseInt(st.nextToken());

            heights = new int[N];

            st = new StringTokenizer(br.readLine());
            for(int i = 0; i < N; i ++) {
                heights[i] = Integer.parseInt(st.nextToken());
            }

            answer = Integer.MAX_VALUE;
            dfs(0, 0);

            System.out.println("#" + t + " " + (answer - B));
        }
    }

    public static void dfs(int idx, int h) {
        if(idx == N) {
            if(h >= B) {
                answer = Math.min(answer, h);
            }

            return;
        }


        dfs(idx + 1, h + heights[idx]);
        dfs(idx + 1, h);

    }
}
