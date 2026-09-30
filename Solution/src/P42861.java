import java.util.Arrays;




public class P42861 {
	static int[] parents;
	public int solution(int n, int[][] costs) {
        int answer = 0;
        parents = new int[n];
        Arrays.sort(costs, (a, b) -> a[2] - b[2]);
        
        int totalCost = 0, edgeCount = 0;
        
        for(int i = 0; i < n; i ++) {
        	parents[i] = i;
        }
        
        for(int[] cost: costs) {
        	if(union(cost[0], cost[1])) {
        		totalCost += cost[2];
        		edgeCount ++;
        		if(edgeCount == n - 1) break;
        	}
        }
        return answer;
    }
	
	static int find(int x) {
		if(parents[x] == x) return x;
		return parents[x] = find(parents[x]);
	}
	
	static boolean union(int x, int y) {
		int px = find(x);
		int py = find(y);
		
		if(px == py) return false;
		
		parents[py] = px;
		
		return true;
	}
}
