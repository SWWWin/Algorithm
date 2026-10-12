package pcs;

import java.util.Arrays;

public class nextPermutation {
    static int N = 3;
    static int[] arr = {10, 20, 30};
    static boolean[] visited = new boolean[3];
    static int[] result = new int[3];
    public static void main(String[] args) {
        bfs(0);
    }

    private static void bfs(int i) {
        if(i == 3) {
            for (int x : result) {
                System.out.print(x + " ");
            }
            System.out.println();
            return;
        }

        for(int j = 0; j < 3; j ++) {
            if(visited[j]) continue;
            visited[j] = true;
            result[i] = arr[j];
            bfs(i + 1);
            visited[j] = false;
        }
    }
}
