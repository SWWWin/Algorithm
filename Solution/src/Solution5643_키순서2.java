import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution5643_키순서2 {
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
                if(adj[i][i] == -1) gtDFS(i);

            }

            for(int i = 1; i <= N; i ++) {
                if(adj[i][0] + adj[0][i] == N - 1) ans ++;
            }
            System.out.println("+" + t + " " + ans);
        }
    }

    static void gtDFS(int cur) {

        for (int i = 1; i <= N; i ++) {
            if(adj[cur][i] == 1) { // cur보다 i가 크다 - 인접정점이면

                //탐색된 정점이 아니면
                if(adj[i][0] == -1) gtDFS(i);
                // 정점이 탐색되었으면
                // 탐색된 정점의 결과를 나와의 관계로 매핑 // cur<i, i <j -> cur < j

                if(adj[i][0] >0) {// i보다 큰 관계의 다른 정점이 있다면
                    for(int j = 1; j <= N; j ++) {
                        if(adj[i][j] == 1) adj[cur][j] = 1;
                    }
                }
            } // end if 인접 정점
        } //for i

        int cnt = 0;
        for(int i = 1; i <= N; i ++) {
            cnt += adj[cur][i];
        }

        adj[cur][0] = cnt; // cur보다 큰 학생 수 저장
    }

}
