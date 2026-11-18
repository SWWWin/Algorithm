import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

import com.sun.org.apache.bcel.internal.generic.LNEG;

class AnswerCandidate {
	int worth;
	int dir;
	int centerR;
	int centerC;
	
	public AnswerCandidate(int worth, int dir, int centerR, int centerC) {
		this.worth = worth;
		this.dir= dir;
		this.centerR = centerR;
		this.centerC = centerC;
	}
}

public class C2024H1AM1 {
	static int LENGTH = 5;
	static int TURN_SIZE = 3;
	static int M;
	static int K;
	static int[][] map;
	static int[] walls;
	static List<AnswerCandidate> candidates;
	static int[][] parentR;
	static int[][] parentC;
	static int[][] size;
	static int[] dr = {-1, 1, 0, 0};
	static int[] dc = {0, 0, -1, 1};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		K = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		map = new int[LENGTH][LENGTH];
		walls = new int[M];
		candidates = new ArrayList<>();
		parentR = new int[LENGTH][LENGTH];
		parentC = new int[LENGTH][LENGTH];
		size = new int[LENGTH][LENGTH];
		String answer = "";
		
		for(int r = 0; r < LENGTH; r ++) {
			st = new StringTokenizer(br.readLine());
			for(int c = 0; c < LENGTH; c ++) {
				map[r][c] = Integer.parseInt(st.nextToken());
			}
		}
		
		st = new StringTokenizer(br.readLine());
		
		for(int w = 0; w < M; w ++) {
			walls[w] = Integer.parseInt(st.nextToken());
		}
		
		for(int k = 0; k < K; k ++) {
			int bestScore = 0;
			
			for(int r = 1; r < 4; r ++) {
				for(int c = 1; c < 4; c ++) {
					for(int dir = 1; dir <= 3; dir ++) {
						rotate(dir, r, c);
						int score = addArtifact();
						rotate(4 - dir, r, c);
					}
				}
			}
		}
		
	}


	private static int addArtifact() {
	    int add = 0;

	    init();

	    for (int r = 0; r < LENGTH; r++) {
	        for (int c = 0; c < LENGTH; c++) {

	            for (int d = 0; d < 4; d++) {
	                int nr = r + dr[d];
	                int nc = c + dc[d];

	                if (nr < 0 || nr >= LENGTH ||
	                    nc < 0 || nc >= LENGTH) {
	                    continue;
	                }

	                if (map[r][c] == map[nr][nc]) {
	                    union(r, c, nr, nc);
	                }
	            }
	        }
	    }

	    for (int r = 0; r < LENGTH; r++) {
	        for (int c = 0; c < LENGTH; c++) {

	            int[] root = find(r, c);

	            if (root[0] == r && root[1] == c) {
	                if (size[r][c] >= 3) {
	                    add += size[r][c];
	                }
	            }
	        }
	    }

	    return add;
	}
	
	private static void init() {
	    for (int r = 0; r < LENGTH; r++) {
	        for (int c = 0; c < LENGTH; c++) {
	            parentR[r][c] = r;
	            parentC[r][c] = c;
	            size[r][c] = 1;
	        }
	    }
	}
	
	private static int[] find(int r, int c) {
		if(parentR[r][c] == r && parentC[r][c] == c) {
			return new int[]{r, c};
		}
		
		int[] root = find(parentR[r][c], parentC[r][c]);
		
		parentR[r][c] = root[0];
		parentC[r][c] = root[1];
		
		return root;
	}
	
	private static void union(int r1, int c1, int r2, int c2) {
	    int[] rootA = find(r1, c1);
	    int[] rootB = find(r2, c2);

	    if (rootA[0] == rootB[0] && rootA[1] == rootB[1]) {
	        return;
	    }

	    parentR[rootB[0]][rootB[1]] = rootA[0];
	    parentC[rootB[0]][rootB[1]] = rootA[1];

	    size[rootA[0]][rootA[1]] += size[rootB[0]][rootB[1]];
	}
	
	
	private static void rotate(int dir, int r, int c) { // 어느 방향으로 돌릴지, 중심의 좌표
		
	}
	
	private static int fill(int step) { // 몇 번쨰부터 채워야 하는지
		for (int r = 0; r < LENGTH; r++) {
	        for (int c = 0; c < LENGTH; c++) {
	        	if(map[r][c] == 0) {
	        		map[r][c] = walls[step % M];
	        	}
	        }
	    }
		
		return step;
	}
}
