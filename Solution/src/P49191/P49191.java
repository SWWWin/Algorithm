package P49191;

import java.util.Arrays;

class Solution {
	static boolean[][] dist;
	
	public static void main(String[] args) {
		
	}
	
    public int solution(int n, int[][] results) {
    	dist = new boolean[n + 1][n + 1];
    	
    	
    	int answer = 0;
    	
    	// 세로가 가로를 이겼다는 뜻이라고 한다면
    	for(int r = 0; r < results.length; r ++) {
    		dist[results[r][0]][results[r][1]] = true;
    	}
    	
    	
    	for(int k = 1; k <= n; k ++ ) {
    		for(int i = 1; i <= n; i ++) {
    			for(int j = 1; j <= n; j ++) {
    				if(dist[i][k] && dist[k][j]) {
    					dist[i][j] = true;
    				}
    			}
    		}
    	}
    	
    	for(int i = 1; i <= n; i ++) {
    		int count = 0;
    		for(int j = 1; j <= n; j ++) {
    			if(i == j) continue;
    			if(dist[i][j] || dist[j][i]) {
    				count ++;
    			}
    		}
    		
    		if(count == n - 1) {
    			answer ++;
    		}
    	}
    	
    	
        return answer;
    }
}