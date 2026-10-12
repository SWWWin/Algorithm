package pcs;

import java.util.Arrays;

public class Backtracking {
    static int N = 3;
    static int R = 2;
    static int[] arr = new int[R];
    static boolean[] visited = new boolean[N];
    static int[] list = {1,2,3};
    public static void main(String[] args) {
        dfs(0);
    }

    public static void dfs(int depth) {
        if(depth == R) {
            System.out.println(Arrays.toString(arr));
            return;
        }

        for(int i = 0; i < N; i ++) {
            if(visited[i] == true) {continue;}
            visited[i] = true;
            arr[depth] = list[i];
            dfs(depth + 1);
            visited[i] = false;
        }
    }
}
