import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class S3752 {
    static int[] question;
    static int N;
    static boolean[] visited;
    static boolean[][] checked;

    public static void main(String[] args) throws Exception {
        BufferedReader br =
                new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        for (int t = 1; t <= T; t++) {
            N = Integer.parseInt(br.readLine());
            question = new int[N];

            StringTokenizer st = new StringTokenizer(br.readLine());
            int sum = 0;

            for (int i = 0; i < N; i++) {
                question[i] = Integer.parseInt(st.nextToken());
                sum += question[i];
            }

            visited = new boolean[sum + 1];
            checked = new boolean[N + 1][sum + 1];

            dfs(0, 0);

            int answer = 0;
            for (int score = 0; score <= sum; score++) {
                if (visited[score]) answer++;
            }

            sb.append('#').append(t).append(' ')
              .append(answer).append('\n');
        }

        System.out.print(sb);
    }

    private static void dfs(int depth, int score) {
        // 같은 문제 위치에서 같은 점수로 탐색했다면 생략
        if (checked[depth][score]) return;
        checked[depth][score] = true;

        if (depth == N) {
            visited[score] = true;
            return;
        }

        dfs(depth + 1, score + question[depth]); // 맞힘
        dfs(depth + 1, score);                   // 틀림
    }
}