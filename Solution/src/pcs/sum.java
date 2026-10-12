package pcs;

public class sum {
    static int arr[] = {1,2,3,4};
    static int add = 5;
    static int answer = 0;
    public static void main(String[] args) {
        bfs(0, 0);
        System.out.println(answer);
    }

    public static void bfs(int i, int j) {
        if(i == arr.length) {
            if(j == arr.length) {answer ++;}
            return;
        }



        bfs(i + 1, j);
        bfs(i + 1, j + arr[i]);

    }
}
