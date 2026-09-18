import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class S6782 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int T = Integer.parseInt(br.readLine());

		for (int t = 1; t <= T; t++) {
			long N = Long.parseLong(br.readLine());
			long answer = 0;
			while (N != 2) {
				long sqrtTest = (long) Math.sqrt(N);
				if (N == sqrtTest * sqrtTest) {
					N = sqrtTest;
					answer++;
				} else {
					long add = (sqrtTest + 1) * (sqrtTest + 1);
					answer += add - N;
					N = add;
				}

			}

			System.out.println("#" + t + " " + answer);
		}
	}
}
