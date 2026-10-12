package pcs;

import java.util.Arrays;

public class Window {
    static int N = 10;
    static int M = 5;


    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 2, 5, 1,1,2,3,1};

        int answer = 0;
        int left = 0;
        int sum = 0;

        for(int right = 0; right < arr.length; right ++) {
            sum += arr[right];

            while(sum > M) {
                sum -= arr[left];
                left ++;
            }

            System.out.println("00");
            if(arr[right] + arr[left] == M) {
                answer ++;

            }
        }

        System.out.println(answer);
    }
}
