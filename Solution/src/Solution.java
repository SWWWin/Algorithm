import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		
		for(int test_case = 1; test_case <= T; test_case++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			int H = Integer.parseInt(st.nextToken());
			int W = Integer.parseInt(st.nextToken());
			
			int[][] map = new int[H][W];
			
			int nowH = 0;
			int nowW = 0;
			
			for(int h = 0; h < H; h ++) {
				String str = br.readLine();
				for(int w = 0; w < W; w ++) {
					map[h][w] = str.charAt(w);
					if(map[h][w] == '^' || map[h][w] == 'v' || map[h][w] == '<' || map[h][w] == '>') {
						nowH = h;
						nowW = w;
					}
				}
			}
			
			int N = Integer.parseInt(br.readLine());
			
			String cmds = br.readLine();
			for(int n = 0; n < N; n ++) {
				char cmd = cmds.charAt(n);
				switch(cmd) {
				case 'U':
					map[nowH][nowW] = '^';
					if(nowH >= 0 && map[nowH-1][nowW] == '.') {
						nowH --;
					}
					break;
				case 'D':
					map[nowH][nowW] = 'v';
					if(nowH < H && map[nowH+1][nowW] == '.') {
						nowH ++;
					}
					break;
				case 'L':
					map[nowH][nowW] = '<';
					if(nowW >= 0 && map[nowH][nowW-1] == '.') {
						nowW --;
					}
					break;
				case 'R':
					map[nowH][nowW] = '^';
					if(nowW < W && map[nowH][nowW+1] == '.') {
						nowW ++;
					}
					break;
				case 'S':
					
				}
			}
		}
	}
}
