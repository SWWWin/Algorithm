package pcs;

import java.util.Scanner;

public class np {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int[] arr = new int[N];

        for (int i = 0; i < N; i++) {
            arr[i] = sc.nextInt();
        }


        if(nextPermutation(arr)) {
            for(int x: arr) {
                System.out.print(x + " ");
            }
            System.out.println();
        }
    }

    public static boolean nextPermutation(int[] arr) {
        int right = arr.length - 1;

        while(right > 0 && arr[right] <= arr[right - 1]) {
            right --;
        }

        int l = arr.length - 1;

        if(right == 0) return false;

        while(arr[right - 1] >= arr[l]) {
            l --;
        }

        swap(l, right - 1, arr);

        int k = arr.length - 1;
        while (right < k) {
            swap(k, right, arr);
            k --;
            right ++;
        }

        return true;
    }

    public static void swap(int i, int j, int[] arr) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
