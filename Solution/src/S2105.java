
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class S2105 {

    public static int T;
    public static int[][] map;
    public static int answer;
    public static int[] dr = {1, 1, -1, -1};
    public static int[] dc = {1, -1, -1, 1};
    public static int n;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(
                new InputStreamReader(System.in));
        StringTokenizer st;
        T = Integer.parseInt(br.readLine());

        for (int t = 1; t <= T; t++) {
            n = Integer.parseInt(br.readLine());
            map = new int[n][n];
            answer = -1;

            for (int i = 0; i < n; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < n; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            for (int rlength = 1; rlength < n; rlength++) {
                for (int llength = 1; rlength + llength < n; llength++) {
                    for (int i = 0; i < n; i++) {
                        for (int j = 0; j < n; j++) {
                            int result = add(i, j, rlength, llength);
                            answer = Math.max(answer, result);
                        }
                    }
                }
            }

            System.out.println("#" + t + " " + answer);
        }
    }

    private static int add(int startR, int startC,
                           int rlength, int llength) {

        Set<Integer> deserts = new HashSet<>();

        int nowR = startR;
        int nowL = startC;

        deserts.add(map[nowR][nowL]);
        int[] dirs = {rlength, llength, rlength, llength};

        for(int dir = 0; dir < dirs.length; dir ++) {
        	for (int r = 0; r < dirs[dir]; r++) {
                int nR = nowR + dr[dir];
                int nL = nowL + dc[dir];

                if (!isValid(nR, nL)) return -1;

                nowR = nR;
                nowL = nL;

                if (dir == 3 && r == dirs[dir] - 1) {
                    if (nowR != startR || nowL != startC) {
                        return -1;
                    }
                    continue;
                }

                if (deserts.contains(map[nowR][nowL])) {
                    return -1;
                }


                deserts.add(map[nowR][nowL]);
            }

        }
        

        return deserts.size();
    }

    private static boolean isValid(int r, int c) {
        return r >= 0 && r < n && c >= 0 && c < n;
    }
}
