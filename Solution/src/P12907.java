import java.util.Arrays;

public class P12907 {
	public static void main(String[] args) {
		System.out.println(solution(5, new int[] {1,2,5}));
	}

	public static int solution(int n, int[] money) {
		int answer = 0;
		
		int[] memo = new int[n + 1];
		memo[0] = 1;
		
		for(int coin: money) {
			for(int i = coin; i <= n; i ++) {
				memo[i] += memo[i - coin];
				memo[i] %= 1000000007;
			}
		}
		return memo[n];
	}
	static int[] arr = {1,2,5};
	static int add;
	public static void sol(int a, int b, int bal) {
		if(bal == 0) {
			add ++;
			return;
		}
		
		if(a < 0) return;
		
		
		for(int j = 0; j <= bal / arr[a]; j ++) {
			sol(a - 1, j, bal - arr[a] * j);
		}
	
	}

}
