import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.StringTokenizer;

public class S1226_1 {
    static int N = 16;
    static char map[][];
    static int[] dc = {1, -1, 0, 0};
    static int[] dr = {0, 0, 1, -1};
    static boolean[][] visited;
    public static void main(String[] args) throws IOException {

        for(int t = 1; t <= 10; t ++) {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

            br.readLine(); // 테스트 케이스 번호 읽기

            map = new char[N][N];
            visited = new boolean[N][N];

            int startC = 0;
            int startR = 0;

            for(int col = 0; col < N; col ++) {
                String str = br.readLine();

                for(int row = 0; row < N; row ++) {
                    map[col][row] = str.charAt(row);
                    if(map[col][row] == '2') {
                        startR = row;
                        startC = col;
                    }
                }

            }

            visited[startC][startR] = true;
            boolean answer = dfs(startC, startR);
            System.out.println("#" + t + " " + (answer?1:0));
        }
    }

    public static boolean dfs(int c, int r) {
        if(map[c][r] == '3') { // 새로 들어온 것이 도착지인 경우
            return true;
        }

        for(int idx = 0; idx < 4; idx ++) {
            int nc = c + dc[idx];
            int nr = r + dr[idx];

            if(nc >= 0 && nc < N && nr >= 0 && nr < N && map[nc][nr] != '1' && !visited[nc][nr]) {
                visited[nc][nr] = true;
                if(dfs(nc, nr)) {
                    return true;
                }

            }
        }
        return false;
    }
}
