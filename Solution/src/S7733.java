//import java.io.BufferedReader;
//import java.io.IOException;
//import java.io.InputStreamReader;
//import java.util.ArrayDeque;
//import java.util.Queue;
//import java.util.StringTokenizer;
//
//class Node {
//    int col;
//    int row;
//
//    public Node(int col, int row) {
//        this.col = col;
//        this.row = row;
//    }
//}
//
//public class S7733 {
//
//    static int[] dc = {1, -1, 0, 0};
//    static int[] dr = {0, 0, 1, -1};
//
//    public static void main(String[] args) throws IOException {
//
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        StringTokenizer st;
//
//        int T = Integer.parseInt(br.readLine());
//
//        for (int t = 1; t <= T; t++) {
//
//            int N = Integer.parseInt(br.readLine());
//
//            int[][] cheese = new int[N][N];
//
//            int max = 0;
//
//            // 치즈 입력
//            for (int col = 0; col < N; col++) {
//
//                st = new StringTokenizer(br.readLine());
//
//                for (int row = 0; row < N; row++) {
//
//                    cheese[col][row] = Integer.parseInt(st.nextToken());
//
//                    max = Math.max(max, cheese[col][row]);
//                }
//            }
//
//            int answer = 0;
//
//            for(int depth = 1; depth <= max; depth ++) {
//                boolean[][] visited = new boolean[N][N];
//                int count = 0;
//                for(int c = 0; c < N; c ++) {
//                    for(int r = 0; r < N; r ++) {
//
//                        if (cheese[c][r] <= depth) continue;
//                        if (visited[c][r]) continue;
//
//                        Queue<P77486.Node> q = new ArrayDeque<>();
//                        q.add(new P77486.Node(c, r));
//
//                        while(!q.isEmpty()) {
//                            P77486.Node now = q.poll();
//
//                            for(int i = 0; i < 4; i ++) {
//                                int nc = now.col + dc[i];
//                                int nr = now.row + dr[i];
//
//                                if(nc < 0 || nc >= N || nr < 0 || nr >= N || visited[nc][nr]) continue;
//
//                                if(cheese[nc][nr] <= depth) continue;
//
//                                visited[nc][nr] = true;
//                                q.add(new P77486.Node(nc, nr));
//                            }
//
//
//                        }
//
//                        count ++;
//                    }
//                }
//                answer = Math.max(answer, count);
//            }
//
//            System.out.println("#" + t + " " + answer);
//        }
//    }
//}