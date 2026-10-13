import java.util.ArrayDeque;
import java.util.Queue;

public class P7603 {
	public static void main(String[] args) {
		solution(new int[] {-5,0,2,1,2}, new int[][] {{0, 1}, {3, 4}, {2, 3}, {0, 3}});
	}
	
	public static long solution(int[] a, int[][] edges) {
        long answer = 0;
        int N = a.length;
        int[] leafCheck = new int[N];
        boolean[] visited = new boolean[N];
        long[] weight = new long[N];
       
        long add = 0;
        for (int i = 0; i < N; i++) {
            weight[i] = a[i];
            add += weight[i];
        }
        if (add != 0) return -1;
        
        for(int i = 0; i < edges.length; i ++) {
        	leafCheck[edges[i][0]] ++;
        	leafCheck[edges[i][1]] ++;
        }
        
        Queue<Integer> q = new ArrayDeque<>();
        
        for(int i = 0; i < N; i ++) {
        	if(leafCheck[i] == 1) {
        		q.offer(i);
        		
        	}
        }
        
        while (!q.isEmpty()) {
            int now = q.poll();
            if (visited[now]) continue;

            visited[now] = true;

            for (int i = 0; i < edges.length; i++) {
                int next = -1;

                if (edges[i][0] == now) {
                    next = edges[i][1];
                } else if (edges[i][1] == now) {
                    next = edges[i][0];
                }

                if (next == -1 || visited[next]) continue;

                answer += Math.abs(weight[now]);
                weight[next] += weight[now];
                weight[now] = 0;

                leafCheck[next]--;

                if (leafCheck[next] == 1) {
                    q.offer(next);
                }
            }
        }
        
        return answer;
    }
	
	
}
