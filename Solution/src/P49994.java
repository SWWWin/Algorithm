
public class P49994 {
	static int[] dr = {-1, 1, 0, 0};
	static int[] dc = {0, 0, 1, -1};
	static boolean[][][] way;
	public static void main(String[] args) {
		System.out.println(solution("LULLLLLLU"));
	}
	
	public static int solution(String dirs) {
	      int answer = 0;
	      int r = 5;
	      int c = 5;
	      
	      way = new boolean[10][10][4];
	      for(int i = 0; i < dirs.length(); i ++) {
	    	  int dir;

	            switch (dirs.charAt(i)) {
	                case 'U': dir = 0; break;
	                case 'D': dir = 1; break;
	                case 'R': dir = 2; break;
	                case 'L': dir = 3; break;
	                default: continue;
	            }
	            
	            int nr = r + dr[dir];
	            int nc = c + dc[dir];
	            
	            if(!isVaild(nr, nc)) continue;
	            
	            int id;
	            if(r == nr) {
	            	id = r * 10 + Math.min(c, nc);
	            } else {
	            	id = 110 + Math.min(r, nr) * 11 + c;
	            }
	            
	            int a = id / 40;
	            int b = (id % 40) / 4;
	            int d = id % 4;

	            if (!way[a][b][d]) {
	                way[a][b][d] = true;
	                answer++;
	            }

	            r = nr;
	            c = nc;
	      }
	      
	      
	      return answer;
	  }
	
	public static boolean isVaild(int r, int c) {
		if(r >= 0 && r <= 10 && c >= 0 && c <= 10) 
			return true;
		return false;
	}
}
