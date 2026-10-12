package search;

public class TC {
    static int N = 4;
    static long M = 7;

    static int[] trees = {20, 15, 10, 17};

    public static void main(String[] args) {
        long left = 0;
        long right = trees.length - 1;

        long answer = 0;
        while(left <= right) {
            long mid = (left + right) / 2;

            long sum = 0;
            for(int tree: trees) {
                if(tree > mid) {
                    sum += tree - mid;
                }
            }

            if(sum >= M) {
                answer = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
    }
}
