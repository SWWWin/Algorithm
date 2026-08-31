
public class Programmers_DP_2 {
	public static void main(String[] args) {
		int[][] a = {{7, 0, 0, 0, 0}, {3,8,0,0,0},{8,1,0,0,0}, {2,7,4,4,0},{4,5,2,6,5}};
        System.out.println(solution(a));
        
	}
    public static int solution(int[][] triangle) {
        int answer = 0;
        int n = triangle.length;
        int[] dp = triangle[n-1].clone();
        for(int i = n - 2; i >= 0; i --) {
        	for(int j = 0; j <= i; j ++) {
        		dp[j] = triangle[i][j] + Math.max(dp[j], dp[j+1]);
        		
        	}
     
        	
    }
    
        return dp[0];
    }
}
