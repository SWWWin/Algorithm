import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

import com.sun.imageio.plugins.common.InputStreamAdapter;

public class P1873 {
	static int dr[] = {-1, 0, 1, 0};// 이동 방향에 따른 델타
	static int dc[] = {0, 1, 0, -1};
	static final String TANK_SYMBOLS = "^>v<";
	static final String DIRS = "URDL";
	
	static int H, W, r, c, dir; // 맵의 크기 전차의위치, 방향
	static char[][] map; // 게임 맵
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int TC = Integer.parseInt(in.readLine());
		
		StringTokenizer st = null;
		StringBuilder sb = new StringBuilder();
		
		for(int tc = 1; tc <= TC; tc ++) {
			st = new StringTokenizer(in.readLine());
			H = Integer.parseInt(st.nextToken());
			W = Integer.parseInt(st.nextToken());
			map = new char[H][];
			r = c = dir = 0;
			for(int i = 0; i < H; i ++) {
				map[i] = in.readLine().toCharArray();
			}
			
			in.readLine();
			char[] command = in.readLine().toCharArray();
			
			play(command);
		}
	}
	
	private static void play(char[] command) {
		
	}
}
