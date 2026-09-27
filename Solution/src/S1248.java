import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

/*
엣지마다 가지고 있는 자식을 2차원 배열에 등록하여 반복하여 서치
 */
public class S1248 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		
		for(int t = 1; t <= T; t ++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			int V = Integer.parseInt(st.nextToken());
			int E = Integer.parseInt(st.nextToken());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int[][] childs = new int[V + 1][2];
			int[] parents = new int[V + 1];

			st = new StringTokenizer(br.readLine());

			for(int i = 1; i <= E; i ++) {
				int parent = Integer.parseInt(st.nextToken());
				int child = Integer.parseInt(st.nextToken());

				if(childs[parent][0] == 0) {
					childs[parent][0] = child;
				} else {
					childs[parent][1] = child;
				}

				parents[child] = parent;
			}

			int same = 0;

			// 처음 구현 당시 - V ^ 2이기 때문에 리팩토링하였다
//			for(int i = a; i != 0; i = parents[i]) {
//				for(int j = b; j != 0; j = parents[j]) {
//					if(i == j) {
//						same = i;
//						break;
//					}
//				}
//
//				if(same != 0) {
//					break;
//				}
//			}


			// 리팩토링 후
			boolean[] visited = new boolean[V + 1];
			for(int i = a; i != 0; i = parents[i]) {
				visited[i] = true;
			}

			for(int i = b; i != 0 ; i = parents[i]) {
				if(visited[i]) {
					same = i;
					break;
				}
			}

			int size = getSize(same, childs);

			StringBuilder sb = new StringBuilder();
			sb.append("#").append(t).append(" ").append(same).append(" ").append(size);
			System.out.println(sb);
		}
	}

	private static int getSize(int same, int[][] childs) {
		Queue<Integer> queue = new ArrayDeque<>();
		queue.add(same);
		int size = 0;
		while(!queue.isEmpty()) {
			int idx = queue.poll();
			size ++;

			if(idx >= childs.length) {
				continue;
			}
			if(childs[idx][0] != 0) {
				queue.add(childs[idx][0]);
			}

			if(childs[idx][1] != 0) {
				queue.add(childs[idx][1]);
			}
		}

		return size;
	}
}
