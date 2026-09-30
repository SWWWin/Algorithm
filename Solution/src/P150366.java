import java.util.ArrayList;

class Pos {
    int c;
    int r;

    Pos(int c, int r) {
        this.r = r;
        this.c = c;
    }
}



class Solution {
	static int N = 50;
	static String[][] graph = new String[N + 1][N + 1];
	static Pos[][] parents = new Pos[N + 1][N + 1];
	
	public String[] solution(String[] commands) {
        ArrayList<String> answerList = new ArrayList<>();
        
        for (int c = 1; c <= 50; c++) {
    for (int r = 1; r <= 50; r++) {
        graph[c][r] = null; // ²À Ãß°¡
        parents[c][r] = new Pos(c, r);
    }
}
        
        for(String command: commands) {
        	String[] str = command.split(" ");
        	
        	switch (str[0]) {
			case "UPDATE":
				if (str.length == 4) {
					int r = Integer.parseInt(str[1]);
					int c = Integer.parseInt(str[2]);
					Pos root = find(c, r);
					graph[root.c][root.r] = str[3];
				    
				} else {
				    for(int col = 1; col <= N; col ++) {
				    	for(int row = 1; row <= N; row ++) {
				    		if(graph[col][row] != null && graph[col][row].equals(str[1])) {
				    			graph[col][row] = str[2];
				    		}
				    	}
				    }
				}
				break;
				
			case "MERGE":
			    int r1 = Integer.parseInt(str[1]);
			    int c1 = Integer.parseInt(str[2]);
			    int r2 = Integer.parseInt(str[3]);
			    int c2 = Integer.parseInt(str[4]);

			    union(c1, r1, c2, r2);
			    break;
			case "UNMERGE":
				int r = Integer.parseInt(str[1]);
				int c = Integer.parseInt(str[2]);
				unmerge(c, r);
				
				break;
			case "PRINT": 
			    int row = Integer.parseInt(str[1]);
			    int col = Integer.parseInt(str[2]);

			    Pos root = find(col, row);

			    if (graph[root.c][root.r] == null) {
			        answerList.add("EMPTY");
			    } else {
			        answerList.add(graph[root.c][root.r]);
			    }
			    break;
			
			default:
				break;
			}
        }
        
        return answerList.toArray(new String[0]);
    }
	
	static Pos find(int c, int r) {
		Pos parent = parents[c][r];
		
		if(parent.r == r && parent.c == c) return parent;
		
		return parents[c][r] = find(parent.c, parent.r);
	}
	
	static boolean union(int c1, int r1, int c2, int r2) {
	    Pos px = find(c1, r1);
	    Pos py = find(c2, r2);

	    if (px.c == py.c && px.r == py.r) return false;

	    parents[py.c][py.r] = px;
	    
	    String value = graph[px.c][px.r];

	    if (value == null) {
	        value = graph[py.c][py.r];
	    }

	    for (int col = 1; col <= N; col++) {
	        for (int row = 1; row <= N; row++) {
	            Pos p = parents[col][row];

	            if ((p.c == px.c && p.r == px.r) ||
	                (p.c == py.c && p.r == py.r)) {
	                parents[col][row] = px;
	            }
	        }
	    }
	    graph[px.c][px.r] = value;
	    graph[py.c][py.r] = null;

	    return true;
	}
	
	static void unmerge(int c, int r) {
	    Pos root = find(c, r);
	    String value = graph[root.c][root.r];
	    
	    ArrayList<Pos> group = new ArrayList<>();
	    
	    for(int col = 1 ; col <= N; col ++) {
	    	for(int row = 1; row <= N; row ++) {
	    		Pos p = find(col, row);
	    		if(p.c == root.c && p.r == root.r) {
	    			group.add(new Pos(col, row));
	    		}
	    	}
	    }
	    
	    for(Pos g: group ) {
	    	parents[g.c][g.r] = new Pos(g.c, g.r);
	    	graph[g.c][g.r] = null;
	    }
	    
	    graph[c][r] = value;
	}
}
