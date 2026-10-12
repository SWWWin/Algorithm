package pcs;

import java.util.Scanner;

public class lst {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int[] arr = new int[N];

        for (int i = 0; i < N; i++) {
            arr[i] = sc.nextInt();
        }

        if (nextPermutation(arr)) {
            for (int x : arr) {
                System.out.print(x + " ");
            }
        } else {
            System.out.println(-1);
        }
    }

    static boolean nextPermutation(int[] arr) {

        int i = arr.length - 1;

        // 1. 뒤에서부터 증가가 깨지는 위치 찾기
        while (i > 0 && arr[i - 1] >= arr[i]) {
            i--;
        }

        // 이미 마지막 순열
        if (i == 0) {
            return false;
        }

        int j = arr.length - 1;

        // 2. arr[i - 1]보다 큰 값을 뒤에서 찾기
        while (arr[i - 1] >= arr[j]) {
            j--;
        }

        // 3. swap
        swap(arr, i - 1, j);

        // 4. 뒤쪽 뒤집기
        int k = arr.length - 1;

        while (i < k) {
            swap(arr, i, k);
            i++;
            k--;
        }

        return true;
    }

    static void swap(int[] arr, int a, int b) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }
}