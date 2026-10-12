package bfs_dfs;


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class BFSandDFS {
    static int[][] arr;
    static int E, V;
    static boolean[] visited;
    static ArrayList<Integer>[] list;
    public static void main(String[] args) {
        V = 5;
        E = 5;
        arr = new int[][]{{0, 1},
                {0, 2},
        {1, 3},
                {2, 3},
        {3, 4}};
        list = new ArrayList[V + 1];
        visited = new boolean[V + 1];
        for(int v = 1; v<= V; v ++) {
            list[v] = new ArrayList<Integer>();
        }

        for(int e = 0; e < E; e ++) {
            list[arr[e][0]].add(arr[e][1]);
            list[arr[e][1]].add(arr[e][0]);
        }

        bfs(0);
        dfs(0);
    }

    public static void bfs(int depth) {

    }
//    public static void dfs(int v) {
//
//        visited[v] = true;
//
//        System.out.print(v + " ");
//
//        for (int i = 0; i < list[v].size(); i++) {
//
//            int next = list[v].get(i);
//
//            if (visited[next]) {
//                continue;
//            }
//
//            dfs(next);
//        }
//    }
//
//    public static void bfs(int row) {
//        Queue<Integer> queue = new LinkedList<>();
//        queue.add(row);
//        boolean[] visited = new boolean[V + 1];
//        visited[row] = true;
//        while(!queue.isEmpty()) {
//            int v = queue.poll();
//
//            for(int i = 0; i < list[v].size(); i++) {
//
//                int next = list[v].get(i);
//                if(visited[i]) {
//                    continue;
//                }
//
//                visited[next] = true;
//                queue.add(next);
//            }
//        }
//    }
}
