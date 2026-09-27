import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class S3499 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for(int t = 1; t <= T; t ++) {
            int n = Integer.parseInt(br.readLine());
            int half = n / 2;

            if(n % 2 != 0) {
                half = half + 1;
            }
            Queue<String> list = new ArrayDeque<>();
            Queue<String> list2 = new ArrayDeque<>();
            StringTokenizer st = new StringTokenizer(br.readLine());

            for(int i = 0; i < n; i ++) {
                if(i < half) {
                    list.add(st.nextToken());
                } else {
                    list2.add(st.nextToken());
                }
            }

            System.out.print("#" + t + " ");
            while (true) {
                if(list.isEmpty() && list2.isEmpty()) {
                    break;
                }

                if(!list.isEmpty()) {
                    System.out.print(list.poll() + " ");
                }

                if(!list2.isEmpty()) {
                    System.out.print(list2.poll() + " ");
                }
            }

        }
    }
}
