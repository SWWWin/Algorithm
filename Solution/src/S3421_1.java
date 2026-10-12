import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class S3421_1 {
    static int answer;
    static int N, M;
    static int[][] menu;
    static boolean[] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader  br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        for(int T0 = 0;T0 < T;T0++){
            answer = 0;

            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            menu = new int[M][2];
            visited = new boolean[N];

            for(int m = 0; m < M; m ++) {
                st = new StringTokenizer(br.readLine());
                menu[m][0] = Integer.parseInt(st.nextToken());
                menu[m][1] = Integer.parseInt(st.nextToken());
            }

            dfs(0);

            System.out.println("#" + T0 + " " + answer);
        }
    }

    public static void dfs(int i) {
        if(N + 1 == i) {
            answer ++;
            return;
        }

        dfs(i + 1);

        boolean possible = true;

        for(int j = 0; j < M; j++) {
            int a = menu[j][0];
            int b = menu[j][1];

            if(i == a && visited[b]) {
                possible = false;
            }

            if(i == b && visited[a]) {
                possible = false;
            }
        }

        if(possible) {
            visited[i] = true;
            dfs(i + 1);
            visited[i] = false;
        }
    }
}
