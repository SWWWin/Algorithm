
import java.util.Arrays;

public class P118668 {

    public int solution(int alp, int cop, int[][] problems) {

        // 1. 목표 알고력, 코딩력 찾기
        int targetAlp = 0;
        int targetCop = 0;

        for (int[] problem : problems) {
            targetAlp = Math.max(targetAlp, problem[0]);
            targetCop = Math.max(targetCop, problem[1]);
        }

        // 이미 목표보다 높은 능력치는 목표로 맞추기
        alp = Math.min(alp, targetAlp);
        cop = Math.min(cop, targetCop);

        // 2. DP 배열 초기화
        int[][] dp = new int[targetAlp + 1][targetCop + 1];

        for (int[] row : dp) {
            Arrays.fill(row, Integer.MAX_VALUE);
        }

        // 현재 상태까지 걸린 시간은 0
        dp[alp][cop] = 0;

        // 3. DP 탐색
        for (int a = alp; a <= targetAlp; a++) {
            for (int c = cop; c <= targetCop; c++) {

                if (dp[a][c] == Integer.MAX_VALUE) {
                    continue;
                }

                // 알고력 공부
                if (a < targetAlp) {
                    dp[a + 1][c] = Math.min(
                        dp[a + 1][c],
                        dp[a][c] + 1
                    );
                }

                // 코딩력 공부
                if (c < targetCop) {
                    dp[a][c + 1] = Math.min(
                        dp[a][c + 1],
                        dp[a][c] + 1
                    );
                }

                // 문제 풀기
                for (int[] problem : problems) {

                    int alpReq = problem[0];
                    int copReq = problem[1];
                    int alpRwd = problem[2];
                    int copRwd = problem[3];
                    int cost = problem[4];

                    if (a < alpReq || c < copReq) {
                        continue;
                    }

                    int nextA = Math.min(targetAlp, a + alpRwd);
                    int nextC = Math.min(targetCop, c + copRwd);

                    dp[nextA][nextC] = Math.min(
                        dp[nextA][nextC],
                        dp[a][c] + cost
                    );
                }
            }
        }

        // 4. 목표에 도달하는 최소 시간
        return dp[targetAlp][targetCop];
    }
}
