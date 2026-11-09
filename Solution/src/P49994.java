
public class P49994 {
	static int[] dr = {1, -1, 0, 0};
	static int[] dc = {0, 0, 1, -1};
	static boolean[][] way;
	public static void main(String[] args) {
		System.out.println(solution("LULLLLLLU"));
	}
	
	public static int solution(String dirs) {
	      int answer = 0;
	      int now[] = {5, 5}; // 현재 위치
	      
	      way = new boolean[10][10];
	      for(int i = 0; i < dirs.length(); i ++) {
	    	  char dir = dirs.charAt(i);
	    	  System.out.println();
	    	  switch (dir) {
			case 'U':
				int r = now[0] + dr[1];
				int c = now[1] + dc[1];
				if(isVaild(r, c) == false) break;
				now[0] = r;
				now[1] = c;
				way[now[0]][now[1]] = true;
				break;
			case 'D':
				r = now[0] + dr[0];
				c = now[1] + dc[0];
				if(isVaild(r, c) == false) break;
				now[0] = r;
				now[1] = c;
				way[now[0]][now[1]] = true;
				break;
			case 'R':
				r = now[0] + dr[2];
				c = now[1] + dc[2];
				if(isVaild(r, c) == false) break;
				now[0] = r;
				now[1] = c;
				way[now[0]][now[1]] = true;
				break;
			case 'L':
				r = now[0] + dr[3];
				c = now[1] + dc[3];
				if(isVaild(r, c) == false) break;
				now[0] = r;
				now[1] = c;
				way[now[0]][now[1]] = true;
				break;

			default:
				break;
			}
	      }
	      
	      for(int i = 0; i < 10; i ++) {
	    	  for(int j = 0; j < 10; j ++) {
	    		  if(way[i][j] == true) answer ++;
	    	  }
	      }
	      return answer;
	  }
	
	public static boolean isVaild(int r, int c) {
		if(r >= 0 && r < 10 && c >= 0 && c < 10) 
			return true;
		return false;
	}
}
