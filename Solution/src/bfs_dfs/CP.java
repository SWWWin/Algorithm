package bfs_dfs;

import java.util.Scanner;

public class CP {
    static int N = 4;
    static int[][] map;
    static int blue, white;
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();

        map = new int[N][N];

        for (int r = 0; r < N; r++) {
            for (int c = 0; c < N; c++) {
                map[r][c] = sc.nextInt();
            }
        }

        divide(0, 0, N);

        System.out.println(white);
        System.out.println(blue);
    }

    public static void divide(int c, int r, int len) {
        if(isSameColor(c, r, len)) {
            if(map[c][r] == 0) {
                white ++;
            } else {
                blue ++;
            }

            return;
        }

        int half = len/2;
        divide(c, r, half);
        divide(c + half, r, half);
        divide(c, r + half, half);
        divide(c + half, r + half, half);
    }

    public static boolean isSameColor(int c, int r, int len) {
        int color = map[c][r];

        for(int i = c; i < c + len; i ++) {
            for(int j = r; j < r + len; j ++) {
                if(map[i][j] != color) return false;
            }
        }

        return true;
    }
}
