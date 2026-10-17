import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class S5643 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        for(int t = 1; t <= T; t ++) {
            int N = Integer.parseInt(br.readLine());
            int M = Integer.parseInt(br.readLine());
            int answer = 0;
            int[][] graph = new int[N + 1][N + 1];

            for(int m = 0; m < M; m ++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                int small = Integer.parseInt(st.nextToken());
                int big = Integer.parseInt(st.nextToken());

                graph[small][big] = 1;
            }

            for(int layover = 1; layover <= N; layover ++) {
                for(int small = 1; small <= N; small ++) {
                    for(int big = 1; big <= N; big ++) {
                        if(graph[small][layover] == 1 && graph[layover][big] == 1) {
                            graph[small][big] = 1;
                        }
                    }
                }
            }

            for(int person = 1; person <= N; person ++) {
                int count = 0;
                for(int small = 1; small <= N; small ++) {
                    if(graph[small][person] == 1) count ++;
                }
                for(int big = 1; big <= N; big ++) {
                    if (graph[person][big] == 1) count++;
                }

                if(count == N - 1) {
                    answer ++;
                }
            }


            System.out.println("#" + t + " " + answer);
        }
    }
}
