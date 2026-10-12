import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class C33 {

    /*
    n명의 친구, m개의 정보
    m줄에 걸쳐 두 사람의 키 정보 a, b
    a번이 b보다 키가 크다
     */

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        List<Integer>[] graph = new List[N + 1];
        int[] indegree = new int[N + 1];
        int answer = -1;
        for(int n = 1; n <= N; n ++) {
            graph[n] = new ArrayList<>();
        }

        for(int m = 0; m < M; m ++) {

            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            graph[a].add(b);
            indegree[b] ++;

            int[] temp = indegree.clone();

            Queue<Integer> q = new ArrayDeque<>();
            for(int n = 1; n <= N; n ++) {
                if(temp[n] == 0) {
                    q.add(n);
                }
            }

            int count = 0;
            while(!q.isEmpty()) {
                int now = q.poll();
                count ++;

                for(int next: graph[now]) {
                    temp[next] --;

                    if(temp[next] == 0) {
                        q.add(next);
                    }
                }
            }

            if (count < N && answer == -1) {
                answer = m + 1;
            }
        }

        System.out.println(answer == -1? "Consistent" : answer);
        }



}
