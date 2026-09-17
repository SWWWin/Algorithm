import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
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
	static int[] dc = {-1, 1, 0, 0};
	static int[] dr = {0, 0, -1, 1};
	static int N;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int[][] map = new int[N][N];
		ArrayList<Loc> baseCamp = new ArrayList<>();
		Loc[] conv = new Loc[M + 1];
		Loc[] playerLocation = new Loc[M + 1];
		
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
			conv[m] = loc;
		}
		
		int target = 1;
		while(isExist(conv)) {
			Loc[] baseArray = baseCamp.toArray(new Loc[0]);
			Loc loc = searchBaseCamp(conv[target], baseArray);
			playerLocation[target] = loc;
			
			int i = 1;
			while(target > 0) {
				playerLocation[target - i] = movePlayer(conv[target - i], playerLocation[target - i]);
				if(conv[i].col == playerLocation[i].col && conv[i].row == playerLocation[i].row) {
					conv[i] = null;
				}
			}
			
			target ++;
		}
		
		System.out.println(target);
		
	}
	
	public static Loc search(Loc conv, Loc[] baseCamp) {

	    Loc answer = new Loc(0, 0);
	    int min = Integer.MAX_VALUE;

	    for (int i = 0; i < baseCamp.length; i++) {

	        boolean[][] visited = new boolean[N][N];
	        Queue<Loc> way = new ArrayDeque<>();

	        way.add(baseCamp[i]);
	        visited[baseCamp[i].col][baseCamp[i].row] = true;

	        int length = 0;
	        boolean find = false;

	        while (!way.isEmpty()) {

	            int size = way.size();

	            for (int s = 0; s < size; s++) {

	                Loc cur = way.poll();

	                if (conv.col == cur.col && conv.row == cur.row) {
	                    find = true;
	                    break;
	                }

	                for (int dir = 0; dir < 4; dir++) {

	                    int nc = cur.col + dc[dir];
	                    int nr = cur.row + dr[dir];

	                    if (nc >= 0 && nc < N &&
	                        nr >= 0 && nr < N &&
	                        !visited[nc][nr]) {

	                        visited[nc][nr] = true;
	                        way.add(new Loc(nc, nr));
	                    }
	                }
	            }

	            if (find) break;

	            length++;
	        }

	        if (min > length) {
	            min = length;
	            answer = baseCamp[i];
	        }
	    }

	    return answer;
	}
	
	public static Loc movePlayer(Loc conv, Loc playerLocation) {
		
		double min = Double.MAX_VALUE;
		Loc loc = new Loc(0,0);
		for(int dir = 0; dir < 4; dir ++) {
			int nc = playerLocation.col + dc[dir];
			int nr = playerLocation.row + dr[dir];
			double length = Math.sqrt(Math.pow((conv.col - nc), 2) + Math.pow((conv.row - nr), 2));
			
			if(min > length) {
				min = length;
				loc = new Loc(nc, nr);
			}
		}
		
		
		return loc;
	}
	
	public static boolean isExist(Loc[] conv) {
		for(Loc con: conv) {
			if(con != null) return true;
		}
		
		return false;
	}
}
