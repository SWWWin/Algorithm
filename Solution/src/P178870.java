import java.util.Arrays;

public class P178870 {
	public static void main(String[] args) {
		int[] sequence = {1,2,3,4,5};
		int[] sequence1 = {1,1,1,2,3,4,5};

		System.out.println(Arrays.toString(solution(sequence, 7)));
		System.out.println(Arrays.toString(solution(sequence1, 5)));
	}
	
	public static int[] solution(int[] sequence, int k) {
        int[] answer = new int[2];

		int N = sequence.length;
		int[] prefix = new int[N + 1];

		for(int i = 1; i <= N; i ++) {
			prefix[i] = sequence[i - 1] + prefix[i - 1];
		}

		for(int len = 1; len <= N; len ++) {
			for(int start = 0; start <= N - len; start ++) {
				System.out.println(start + "  " + len);
				if(prefix[start + len] - prefix[start] == k) {
					answer[0] = start;
					answer[1] = start + len - 1;
					return answer;
				}
			}
		}
		return answer;
    }
}
