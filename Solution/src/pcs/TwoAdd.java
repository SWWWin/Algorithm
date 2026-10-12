package pcs;

import java.util.Arrays;

public class TwoAdd {
    static int answer;
    static int[] arr;
    static int M;
    public static void main(String[] args) {
        int N = 9;
        M = 13;
        answer = 0;
        arr = new int[]{5, 12, 7, 10, 9, 1, 2, 3, 11};

        Arrays.sort(arr);
        int left = 0;
        int right = arr.length - 1;
        while(left < right) {
            if(arr[left] + arr[right] == M) {
                answer ++;
                left ++;
                right --;
            } else if(arr[left] + arr[right] < M) {
                left ++;
            } else {
                right --;
            }

            System.out.println(left + " " + right);
        }

        System.out.println(answer);
    }


}
