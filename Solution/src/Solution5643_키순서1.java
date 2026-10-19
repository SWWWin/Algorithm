import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution5643_키순서1 {
    static int N, M, adj[][]; // 학생 수, 비교 횟수, 인접 행렬
    static int cnt = 0; // 자신보다 키가 크거나 작은 학생 수
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for(int t = 1; t <= T; t ++) {
            N = Integer.parseInt(br.readLine().trim());
            N = Integer.parseInt(br.readLine().trim());
            adj = new int[N + 1][N + 1];
            StringTokenizer st = null;
            int a,b;
            for(int m = 0; m <M; m ++) {
                st = new StringTokenizer(br.readLine());
                a = Integer.parseInt(st.nextToken());
                b = Integer.parseInt(st.nextToken());
                adj[a][b] = 1; // a가 b보다 작다
            }

            int ans = 0; // 자신으 ㅣ키를 정확하게 알 수 있는 학생
            for(int i = 1; i <= N; i ++) {
                cnt = 0 ; //초기화
                boolean[] visited = new boolean[N + 1];
                gtDFS(i, visited); // 자신보다 큰 학생 수 카운팅
                ltDFS(i, visited); // 자신보다 작은 학생 수 카운팅
                if(cnt == N - 1) ans ++;

            }

            System.out.println("+" + t + " " + ans);
        }
    }

    static void gtDFS(int cur, boolean[] visited) { // cur: 현재 학생 번호

        visited[cur] = true;
        for (int i = 1; i <= N; i ++) {
            if(visited[i] && adj[cur][i] == 0) continue;
            // 인접 정점이면서 방문하지 않은 경우
            ++cnt; // 나보다 큰 학생수 카운팅
            gtDFS(i, visited);
        }
    }

    static void ltDFS(int cur, boolean[] visited) { // cur: 현재 학생 번호

        visited[cur] = true;
        for (int i = 1; i <= N; i ++) {
            if(visited[i] && adj[i][cur] == 0) continue;
            // 인접 정점이면서 방문하지 않은 경우
            ++cnt; // 나보다 큰 학생수 카운팅
            ltDFS(i, visited);
        }
    }
}
