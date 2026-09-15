import java.util.Arrays;

public class P178870 {
	public static void main(String[] args) {
		int[] sequence = {1,2,3,4,5};
		int[] sequence1 = {1,1,1,2,3,4,5};

		System.out.println(Arrays.toString(solution(sequence, 7)));
		System.out.println(Arrays.toString(solution(sequence1, 5)));
	}
	

    public static int[] solution(int[] sequence, int k) {
        int left = 0;
        int sum = 0;

        int bestLeft = 0;
        int bestRight = sequence.length - 1;
        int bestLen = sequence.length + 1;

        for (int right = 0; right < sequence.length; right++) {

            sum += sequence[right];

            while (sum > k) {
                sum -= sequence[left];
                left++;
            }

            if (sum == k) {
                int len = right - left + 1;

                if (len < bestLen) {
                    bestLen = len;
                    bestLeft = left;
                    bestRight = right;
                }
            }
        }

        return new int[]{bestLeft, bestRight};
    }
}

