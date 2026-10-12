package bfs_dfs;

import java.util.ArrayDeque;
import java.util.Queue;

public class Island {

    static int N = 4;
    static int M = 5;

    static int[][] map = {
            {1, 1, 0, 0, 1},
            {1, 0, 0, 1, 1},
            {0, 0, 1, 0, 0},
            {0, 0, 1, 1, 0}
    };

    static int[] dr = {-1, -1, -1, 0, 0, 1, 1, 1};
    static int[] dc = {-1, 0, 1, -1, 1, -1, 0, 1};

    static boolean[][] visited = new boolean[N][M];
    public static void main(String[] args) {

        int answer = 0;
        for(int c = 0; c < N ; c ++) {
            for(int d = 0; d < M; d ++) {
                if(map[c][d] == 1 && !visited[c][d]) {
                    bfs(c, d);
                    answer++;
                }
            }
        }
        System.out.println(answer);
    }

    public static void bfs(int col, int row) {
        Queue<int[]> q = new ArrayDeque<>();

        q.offer(new int[] {col, row});
        visited[col][row] = true;

        while(!q.isEmpty()) {
            int[] arr = q.poll();

            for(int i = 0; i < 8; i++) {
                int nc = arr[1] + dc[i];
                int nr = arr[0] + dr[i];

                if(nc >= 0 && nc < M && nr >= 0 && nr < N && map[nc][nr] == 1) {
                    if(!visited[nc][nr]) {
                        q.add(new int[] {nc, nr});
                        visited[nc][nr] = true;
                    }
                }
            }

        }
    }
}

