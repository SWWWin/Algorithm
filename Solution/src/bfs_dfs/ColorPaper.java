package bfs_dfs;


import java.util.Scanner;

public class ColorPaper {

    static int N;
    static int[][] map;

    static int white = 0;
    static int blue = 0;

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

    public static void divide(int r, int c, int size) {

        // 현재 영역이 모두 같은 색인지 확인
        if (isSameColor(r, c, size)) {

            if (map[r][c] == 0) {
                white++;
            } else {
                blue++;
            }

            return;
        }

        // 색이 섞여 있으면 4등분
        int half = size / 2;

        // 왼쪽 위
        divide(r, c, half);

        // 오른쪽 위
        divide(r, c + half, half);

        // 왼쪽 아래
        divide(r + half, c, half);

        // 오른쪽 아래
        divide(r + half, c + half, half);
    }

    public static boolean isSameColor(int r, int c, int size) {

        int color = map[r][c];

        for (int i = r; i < r + size; i++) {
            for (int j = c; j < c + size; j++) {

                if (map[i][j] != color) {
                    return false;
                }
            }
        }

        return true;
    }
}