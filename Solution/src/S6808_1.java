import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class S6808_1 {
    static int[] ky_card = new int[9];
    static int[] iy_card = new int[9];
    static boolean[] iy_visited = new boolean[9];

    static int win;
    static int lose;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        for(int t = 1; t <= T; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            win = 0;
            lose = 0;

            boolean[] check = new boolean[19];

            for(int i = 0; i < 9; i++) {
                ky_card[i] = Integer.parseInt(st.nextToken());
                check[ky_card[i]] = true;
            }

            for(int i = 1, k = 0; i <= 18; i++) {
                if(!check[i]) {
                    iy_card[k++] = i;
                }
            }

            dfs(0, 0, 0);

            System.out.println("#" + t + " " + win + " " + lose);
        }
    }

    public static void dfs(int depth, int ky_score, int iy_score) {
        if(depth == 9) {
            if(ky_score > iy_score) {
                win++;
            } else if(ky_score < iy_score) {
                lose++;
            }
            return;
        }

        for(int i = 0; i < 9; i++) {
            if(!iy_visited[i]) {

                iy_visited[i] = true;

                int score = ky_card[depth] + iy_card[i];

                if(ky_card[depth] > iy_card[i]) {
                    dfs(depth + 1,
                            ky_score + score,
                            iy_score);
                } else {
                    dfs(depth + 1,
                            ky_score,
                            iy_score + score);
                }

                iy_visited[i] = false;
            }
        }
    }
}