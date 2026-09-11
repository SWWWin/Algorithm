import java.util.Arrays;

public class P178870 {
	public static void main(String[] args) {
		int[] sequence = {1,2,3,4,5};
		
		System.out.println(Arrays.toString(solution(sequence, 7)));
	}
	
	public static int[] solution(int[] sequence, int k) {
        int[] answer = new int[2];
        
        int N = sequence.length;
        int[] prefix = new int[2 * N + 1];
        
        for(int i = 1; i <= 2 * N; i ++) {
        	prefix[i] = prefix[i - 1] + sequence[i % N];
        }
        
        
        for(int len = 1; len <= N; len ++) {
        	for(int start = 0; start < N; start ++) {
        		int sum = prefix[start + len] - prefix[start];
        		
        		if(sum == k) {
        			answer[0] = start;
        			answer[1] = (start + len) / N;
        			Arrays.sort(answer);
        			return answer;
        		}
        	}
        	
        }
        return answer;
    }
}
