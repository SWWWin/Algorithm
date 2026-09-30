import java.util.ArrayList;

/*
 *
 */
public class P60061 {
	static boolean[][] pillars;
	static boolean[][] beams;
	ArrayList<int[]> answer;
	public int[][] solution(int n, int[][] build_frame) {
        answer = new ArrayList<>(); // 가로, 세로 좌표, 기둥-보 여부
        
        pillars = new boolean[n + 2][n + 2];
        beams = new boolean[n + 2][n + 2];
        
        for(int bf = 0; bf < build_frame.length; bf ++) {
        	int x = build_frame[bf][0];
        	int y = build_frame[bf][1];
        	int a = build_frame[bf][2];
        	int b = build_frame[bf][3];
        	
        	if(b == 0) {
        		remove(x, y, a);
        	} else {
        		add(x, y, a);
        	}
        }
        
    	for(int row = 0; row <= n; row ++) {
    		for(int col = 0; col <= n; col ++) {
    			if(pillars[row][col]) {
    			    answer.add(new int[] {row, col, 0});
    			}

    			if(beams[row][col]) {
    			    answer.add(new int[] {row, col, 1});
    			}
    		}
    	}
    	
        // 결과 정렬 x 오름차순 - y 오름차순 - 기둥/보
        return answer.toArray(new int[0][0]);
    }
	
	private void remove(int x, int y, int a) {
		if(a == 0) {
			pillars[x][y] = false;
		} else {
			beams[x][y] = false;
		}
		
		 if (!isValid()) {
		        if (a == 0) {
		            pillars[x][y] = true;
		        } else {
		            beams[x][y] = true;
		        }
		    }
	}
	
	private boolean isValid() {
	    for (int x = 0; x < pillars.length; x++) {
	        for (int y = 0; y < pillars.length; y++) {

	            if (pillars[x][y]) {
	                if (!canPillar(x, y)) {
	                    return false;
	                }
	            }

	            if (beams[x][y]) {
	                if (!canBeam(x, y)) {
	                    return false;
	                }
	            }
	        }
	    }

	    return true;
	}

	private boolean canBeam(int x, int y) {
	    if (y > 0 && pillars[x][y - 1]) return true;
	    if (y > 0 && pillars[x + 1][y - 1]) return true;
	    if (x > 0 && beams[x - 1][y] && beams[x + 1][y]) return true;
	    return false;
	}

	private boolean canPillar(int x, int y) {
		if (y == 0) return true;
		if(pillars[x][y - 1]) return true;
		if(beams[x][y]) return true;
		if(x > 0 && beams[x - 1][y]) return true;
	    return false;
	}

	private void add(int x, int y, int a) {
		
		if(a == 0) {
			if(canPillar(x, y)) pillars[x][y] = true;
		} else {
			if(canBeam(x, y)) beams[x][y] = true;
		}
		
	}
}
