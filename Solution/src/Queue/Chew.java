package Queue;

import java.util.ArrayDeque;
import java.util.Queue;

public class Chew {
    public static void main(String[] args) {
        int N = 20;
        int i = 1;
        Queue<int[]> q = new ArrayDeque<>();
        int[] arr = {1, 1};
        q.offer(arr);
        while(!q.isEmpty()) {
            int[] chew = q.poll();

            if(N > chew[1]) {
                N -= chew[1];
                q.add(new int[] {chew[0], ++chew[1]});
                q.add(new int[] {chew[0] + 1, 1});
            } else {
                System.out.println("남은 거 전부 털어 넣기");
                break;
            }
        }
    }
}
