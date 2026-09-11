import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Info {
	int prefer;
	int cal;
	
	public Info(int prefer, int cal) {
		super();
		this.prefer = prefer;
		this.cal = cal;
	}
	
	
}
public class S5215 {
	
	static int maxPrefer, N, L;
	static Info[] infos;
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int TC = Integer.parseInt(br.readLine());
		
		StringTokenizer st;
		for(int tc = 1; tc <= TC; tc ++) {
			st = new StringTokenizer(br.readLine());
			
			N = Integer.parseInt(st.nextToken());
			L = Integer.parseInt(st.nextToken());
			infos = new Info[N];
			maxPrefer = 0;
			
			
			for(int n = 0; n < N; n ++) {
				st = new StringTokenizer(br.readLine());
				int p = Integer.parseInt(st.nextToken());
				int c = Integer.parseInt(st.nextToken());
				
				Info info = new Info(p,c);
				infos[n] = info;
			}
			
			dfs(0, 0, 0); // 찾아볼 숫자 위치 / 선호도 누적 / 칼로리 누적
			dfs(0, infos[0].prefer, infos[0].cal);
			
			System.out.println("#" + tc + " " + maxPrefer);
		}
	}

	private static void dfs(int index, int addPre, int addCal) {
		if(L < addCal) {
			return;
		}
		
		if(index >= N - 1) {
			if(addPre >= maxPrefer) {
				maxPrefer = addPre;
				
			}
			return;
		}
		
		dfs(index + 1, addPre + infos[index + 1].prefer, addCal + infos[index + 1].cal);
		dfs(index + 1, addPre, addCal);
	}
}
