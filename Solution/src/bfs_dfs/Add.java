package bfs_dfs;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Add {
    static int V = 5;
    static int E = 5;

    static boolean[] visited = new boolean[V];
    static ArrayList<Integer>[] arrayList = new ArrayList[V];
    public static void main(String[] args) {
        int[][] arr = {{0, 1},
                {0, 2},
                {1, 3},
                {2, 3},
                {3, 4}};
        for(int v = 0; v < V; v ++) {
            arrayList[v] = new ArrayList<>();
        }

        for(int e = 0; e < E; e ++) {
            arrayList[arr[e][0]].add(arr[e][1]);
            arrayList[arr[e][1]].add(arr[e][0]);
        }

        dfs(0);

        visited = new boolean[V];
        bfs(0);
    }

    public static void dfs(int depth) {
        if(depth == V) {
            return;
        }

        for(int v = 0; v < arrayList[depth].size(); v ++) {
            if(visited[arrayList[depth].get(v)]) {continue;}


            dfs(arrayList[depth].get(v));

        }
    }

    public static void bfs(int depth) {
        Queue<Integer> queue = new ArrayDeque<>();
        queue.add(0);
        visited[0] = true;
        while(!queue.isEmpty()) {
            int now = queue.poll();
            for(int v = 0; v < arrayList[now].size(); v ++) {
                if(visited[arrayList[now].get(v)]) {continue;}
                queue.add(arrayList[now].get(v));
                visited[arrayList[now].get(v)] = true;
            }
        }
    }
}
