import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Queue;

public class P7603 {
	public static void main(String[] args) {
		solution(new int[] {-5,0,2,1,2}, new int[][] {{0, 1}, {3, 4}, {2, 3}, {0, 3}});
	}
	
	public static long solution(int[] a, int[][] edges) {
        long answer = 0;
        int N = a.length;
        long[] arr = new long[N];
        List<Integer>[] tree = new ArrayList[N];
        int[] leafCheck = new int[N];
        boolean[] visited = new boolean[N];

        for(int n = 0; n < N; n ++) {
        	tree[n] = new ArrayList<>();
        }
        

        long add = 0;
        for (int i = 0; i < N; i++) {
        	add += a[i];
        	arr[i] = a[i];
        }
        
        if (add != 0) return -1;
        
        for(int i = 0; i < edges.length; i ++) {
        	int from = edges[i][0];
        	int to = edges[i][1];
        	
        	tree[from].add(to);
        	tree[to].add(from);
        	
        	leafCheck[from] ++;
        	leafCheck[to] ++;
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
            


            for(int next: tree[now]) {
            	if(visited[next]) continue;
            	
            	arr[next] += arr[now];
            	answer += Math.abs(arr[now]);
            	
            	leafCheck[next] --;
            	
            	if(leafCheck[next] == 1) q.offer(next);
            }
        }
        
        return answer;
    }
	
	
}
