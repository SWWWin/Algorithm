import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_1 {
	static int[] dir = {0,1,2,3}; // »óÇÏÁÂ¿ì
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		
		for(int test_case = 1; test_case <= T; test_case++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			int H = Integer.parseInt(st.nextToken());
			int W = Integer.parseInt(st.nextToken());
			
			char[][] map = new char[H][W];
			
			int nowH = 0;
			int nowW = 0;
			int dir = 0;
			
			for(int h = 0; h < H; h ++) {
				String str = br.readLine();
				for(int w = 0; w < W; w ++) {
					map[h][w] = str.charAt(w);
					if(map[h][w] == '^' || map[h][w] == 'v' || map[h][w] == '<' || map[h][w] == '>') {
						nowH = h;
						nowW = w;
						if(map[h][w] == '^') dir = 0;
						else if(map[h][w] == 'v') dir = 1;
						else if(map[h][w] == '<') dir = 2;
						else if(map[h][w] == '>') dir = 3;
					}
				}
			}
			
			int N = Integer.parseInt(br.readLine());
			
			String cmds = br.readLine();
			for(int n = 0; n < N; n ++) {
				char cmd = cmds.charAt(n);
				switch(cmd) {
				case 'U':
					dir = 0;
					map[nowH][nowW] = '^';
					if(nowH > 0 && map[nowH-1][nowW] == '.') {
						map[nowH][nowW] = '.';
				        nowH--;
				        map[nowH][nowW] = '^';
					}
					break;
				case 'D':
					dir = 1;
					map[nowH][nowW] = 'v';
					if(nowH < H-1 && map[nowH+1][nowW] == '.') {
						map[nowH][nowW] = '.';
						++nowH;
						map[nowH][nowW] = 'v';
					}
					break;
				case 'L':
					dir = 2;
					map[nowH][nowW] = '<';
					if(nowW > 0 && map[nowH][nowW-1] == '.') {
						map[nowH][nowW] = '.';
						--nowW;
						map[nowH][nowW] = '<';
					}
					break;
				case 'R':
					dir = 3;
					map[nowH][nowW] = '^';
					if(nowW < W-1 && map[nowH][nowW+1] == '.') {
						map[nowH][nowW] = '.';
						++nowW;
						map[nowH][nowW] = '^';
					}
					break;
				case 'S':
				    int shootH = nowH;
				    int shootW = nowW;

				    while(true) {
				        switch(dir) {
				        case 0:
				            shootH--;
				            break;
				        case 1:
				            shootH++;
				            break;
				        case 2:
				            shootW--;
				            break;
				        case 3:
				            shootW++;
				            break;
				        }

				        if(shootH < 0 || shootH >= H || shootW < 0 || shootW >= W)
				            break;

				        if(map[shootH][shootW] == '#') {
				            break;
				        }

				        if(map[shootH][shootW] == '*') {
				            map[shootH][shootW] = '.';
				            break;
				        }
				    }
				    break;					
					
				}
			}
			
			System.out.print("#" + test_case + " ");
			for(int i = 0; i < H; i ++) {
				for(int j = 0; j < W; j ++) {
					System.out.print(map[i][j]);
				}
				System.out.println();
			}
			
		}
	}
}
