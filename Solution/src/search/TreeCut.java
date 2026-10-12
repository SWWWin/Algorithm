package search;
import java.util.Arrays;

public class TreeCut {

    static int N = 4;
    static long M = 7;

    static int[] trees = {20, 15, 10, 17};

    public static void main(String[] args) {

        long left = 0;
        long right = Arrays.stream(trees).max().getAsInt();

        long answer = 0;

        while (left <= right) {

            long mid = (left + right) / 2;

            long sum = 0;

            for (int tree : trees) {
                if (tree > mid) {
                    sum += tree - mid;
                }
            }

            if (sum >= M) {
                answer = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        System.out.println(answer);
    }
}