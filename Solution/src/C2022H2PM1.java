import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

class Loc {
	int col;
	int row;
	
	public Loc(int col, int row) {
		super();
		this.col = col;
		this.row = row;
	}
}

public class C2022H2PM1 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int[][] map = new int[N][N];
		ArrayList<Loc> baseCamp = new ArrayList<>();
		Loc[] conv = new Loc[M];
		
		for(int c = 0; c < N; c ++) {
			st = new StringTokenizer(br.readLine());
			for(int r = 0; r < N; r ++) {
				map[c][r] = Integer.parseInt(st.nextToken());
				
				if(map[c][r] == 1) {
					Loc loc = new Loc(c, r);
					baseCamp.add(loc);
				}
			}
		}
		
		for(int m = 1; m <= M; m ++) {
			st = new StringTokenizer(br.readLine());
			
			int col = Integer.parseInt(st.nextToken()) - 1;
			int row = Integer.parseInt(st.nextToken()) - 1;
			
			map[col][row] = m;
			
			Loc loc = new Loc(col, row);
			conv[m - 1] = loc;
		}
		
		
	}
	
	public static int[] searchBaseCamp(Loc conv, ArrayList<Loc> baseCamp) {
		int min = 0;
		ArrayList<Loc> minLoc = new ArrayList<>();
		
		for(Loc base: baseCamp) {
			if(Math.sqrt(Math.pow((conv.col - base.col), 2) + Math.pow((conv.row - base.row), 2)) < min) {
				minLoc.add(base);
			}
		}
		
		
		
		return new int[2];
	}
}
