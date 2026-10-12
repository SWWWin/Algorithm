import java.io.*;
import java.util.*;

public class S9229_1 {

    static int N, M;
    static boolean[][] notTogether;
    static int answer;

    public static void main(String[] args) throws Exception {

        BufferedReader br =
                new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        for (int tc = 1; tc <= T; tc++) {

            StringTokenizer st =
                    new StringTokenizer(br.readLine());

            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());

            notTogether = new boolean[N + 1][N + 1];

            for (int i = 0; i < M; i++) {

                st = new StringTokenizer(br.readLine());

                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());

                notTogether[a][b] = true;
                notTogether[b][a] = true;
            }

            answer = 0;

            dfs(1, new boolean[N + 1]);

            System.out.println("#" + tc + " " + answer);
        }
    }

    static void dfs(int index, boolean[] selected) {

        if (index == N + 1) {

            answer++;
            return;
        }

        dfs(index + 1, selected);

        boolean possible = true;

        for (int i = 1; i < index; i++) {

            if (selected[i] && notTogether[index][i]) {
                possible = false;
                break;
            }
        }


        if (possible) {

            selected[index] = true;

            dfs(index + 1, selected);

            selected[index] = false;
        }
    }
}