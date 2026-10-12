package pcs;

public class NQueen {

    static int N = 4;
    static int answer = 0;

    static int[] queens = new int[N];
    public static void main(String[] args) {

        dfs(0);

        System.out.println(answer);
    }

    static void dfs(int row) {
        if(row == N) {
            answer ++;
            return;
        }

        for(int i = 0; i < N; i++) {
            if(isCheck(row, i)) {
                queens[row] = i;
                dfs(row + 1);
            }
        }
    }

    static boolean isCheck(int row, int col) {

        for(int prevRow = 0; prevRow < row; prevRow++) {

            // 같은 열
            if(queens[prevRow] == col) {
                return false;
            }

            // 같은 대각선
            if(Math.abs(row - prevRow)
                    == Math.abs(col - queens[prevRow])) {
                return false;
            }
        }

        return true;
    }
}


