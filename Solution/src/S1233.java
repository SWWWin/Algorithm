import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class S1233 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		for(int test_case = 1; test_case <= 10; test_case ++) {
			int N = Integer.parseInt(br.readLine());
			int answer = 1;
			
			for(int n = 0; n < N; n ++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				ArrayList<Character> token = new ArrayList<>();
				
				st.nextToken();
				
				char input = st.nextToken().charAt(0);
				
				while(st.hasMoreTokens()) {
					token.add(st.nextToken().charAt(0));
				}
				
				if((input >= '0' && input <= '9') && token.size() != 0)  {
					answer = 0;
					
				}
				if((input == '+' || input == '-' || input == '*' || input == '/') && token.size() != 2) {
					answer = 0;
					
				}
				
			}
			
			System.out.println("#" + test_case + " " + answer);
		}
	}
}
