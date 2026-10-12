import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

class Core {
    int col;
    int row;

    public Core(int col, int row) {
        this.col = col;
        this.row = row;
    }
}
public class S1767_1 {
    static int N;
    static ArrayList<Core> cores;
    static int minWire, maxCore;
    static int[] dc = {1, -1 , 0, 0};
    static int[] dr = {0, 0, 1, -1};
    static int[][] map;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st ;
        int T = Integer.parseInt(br.readLine());

        for(int t = 1; t <= T; t ++) {
            N = Integer.parseInt(br.readLine());
            cores = new ArrayList<>();
            map = new int[N][N];

            for(int col = 0; col < N; col ++) {
                st = new StringTokenizer(br.readLine());
                for(int row = 0; row < N ; row ++) {
                    int a = Integer.parseInt(st.nextToken());
                    map[col][row] = a;

                    if(a == 1) {
                        if(col != 0 && col != N - 1 &&
                                row != 0 && row != N - 1) {
                            Core core = new Core(col, row);
                            cores.add(core);
                        }
                    }


                }
            }

            maxCore = 0;
            minWire = Integer.MAX_VALUE;
            dfs(0, 0, 0);
            System.out.println("#" + t + " " + minWire);

        }
    }

    public static void dfs(int idx, int nowCore, int nowWire) {
        if(idx == cores.size()) {
            if(nowCore > maxCore) {
                maxCore = nowCore;
                minWire = nowWire;
            } else if(nowCore == maxCore) {
                minWire = Math.min(minWire, nowWire);
            }

            return;
        }

        int r = cores.get(idx).row;
        int c = cores.get(idx).col;

        for(int i = 0; i < 4; i ++) {
            int length = canConnect(r, c, i);

            if(length == -1) {
                continue;
            }

            makeWire(r, c, i, 2);
            dfs(idx + 1, nowCore + 1, nowWire + length);
            makeWire(r, c, i, 0);
        }

        dfs(idx + 1, nowCore, nowWire);
    }

    public static int canConnect(int r, int c, int i) {
        int nr = r + dr[i];
        int nc = c + dc[i];

        int length = 0;
        while (nr >= 0 && nr < N && nc >= 0 && nc < N) {
            if (map[nc][nr] != 0) {
                return -1;
            }

            length++;

            nr += dr[i];
            nc += dc[i];

        }
        return length;
    }

    public static void makeWire(int r, int c, int i, int length) {
        int nr = r + dr[i];
        int nc = c + dc[i];

        while (nr >= 0 && nr < N && nc >= 0 && nc < N) {
            map[nc][nr] = length;
            nr += dr[i];
            nc += dc[i];
        }
    }
}
