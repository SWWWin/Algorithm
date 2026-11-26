import java.util.Arrays;

public class P81302 {
	static int[] dr = {-1, 1, 0, 0, -1, -1, 1, 1};
	static int[] dc = {0, 0, -1, 1, -1, 1, -1, 1};
	
	public static void main(String[] args) {
		System.out.println(solution(new String[][] {{"POOOP", "OXXOX", "OPXPX", "OOXOX", "POXXP"}, {"POOPX", "OXPXP", "PXXXO", "OXXXO", "OOOPP"}, {"PXOPX", "OXOXP", "OXPOX", "OXXOP", "PXPOX"}, {"OOOXX", "XOOOX", "OOOXX", "OXOOX", "OOOOO"}, {"PXPXP", "XPXPX", "PXPXP", "XPXPX", "PXPXP"}}).toString());
	}
	
	public static int[] solution(String[][] places) {
        int[] answer = new int[5]; 
        Arrays.fill(answer, 1);;
        boolean valid = true;
        
        for(int turn = 0; turn < 5; turn ++) {
        	for(int r = 0; r < 5; r ++) {
        		for(int c = 0; c < 5; c ++) {
        			valid = isValid(turn, r, c, places);
        			if(!valid) {
        				answer[turn] = 0;
        				break;
        			}
        		}
        		
        		if(!valid) {
        			break;
        		}
        	}
        }
        return answer;
    }
	
	public static boolean isValid(int turn, int r, int c, String[][] places) {
		System.out.println(turn + " " + r + " " + c);
		for(int dir = 0; dir < 8; dir ++) {
			int nr = r + dr[dir];
			int nc = c + dc[dir];
			if(nr >= 0 && nr < 5 && nc >= 0 && nc < 5 && places[turn][nr].charAt(nc) == 'P') {
				if(places[turn][nr].charAt(nc) == places[turn][r].charAt(c) && (places[turn][nr].charAt(c) != 'X' || places[turn][r].charAt(nc) !='X')) {
					return false;
				}
			}
			
			if(dir < 4) {
				int nextR = nr + dr[dir];
				int nextC = nc + dc[dir];
				if(nextR >= 0 && nextR < 5 && nextC >= 0 && nextC < 5 && places[turn][nextR].charAt(nextC) == 'P') {
					if (places[turn][nextR].charAt(nextC) == places[turn][r].charAt(c)
					        && places[turn][nr].charAt(nc) == 'O') {
					    return false;
					}
					
				}
				
			}
		}
		return true;
	}
}
