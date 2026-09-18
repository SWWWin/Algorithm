import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 * 부모가 무엇인지 계속 찾아다녀야 함 -> 그냥 부모만 확인하면 되지 않을까?
 * 인덱스: 자식 - 배열[인덱스] - 부모의 인덱스
 * 부모의 인덱스에 간 다음 다시 dfs
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
			int[] parents = new int[E * 2];
			
			for(int i = 1; i < E * 2; i ++) {
				
			}
			
			
			
			
			int idxA = a; 
			while(idxA == 1) {
				int idxB = b;
				while(idxB == 1) {
					
				}
			}
		}
	}
}
