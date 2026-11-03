import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class S4040 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		
		for(int t = 1; t <= T; t ++) {
			String str = br.readLine();
			
			int[] pi = new int[str.length()];
			int j = 0;
			
			for(int i = 1; i < str.length(); i ++) {
				while(j > 0 && str.charAt(i) != str.charAt(j)) {
					j = pi[j - 1];
				}
				if(str.charAt(i) == str.charAt(j)) {
					j ++;
					pi[i] = j;
				}
			}
			
			int len = str.length() - pi[str.length() - 1];
			int answer = str.length() % len == 0 ? str.length() / len : 1;
			
			//System.out.println(Arrays.toString(pi));
			System.out.println("#" + t + " " + answer);
		}
		
		// 가장 짧은 패턴을 찾아 몇 번 반복하나 확인하기
	}
}


/*
 * 이렇게 사용하면 실행 시간이 400ms 정도 더 걸리고 코드도 길다...
 * for(int patternLen = 1; patternLen <= str.length(); patternLen ++) {
 * 				if(str.length() % patternLen != 0) continue;
				int[] failTable = new int[patternLen];
				String pattern = str.substring(0, patternLen);
				int j = 0;
				
				for(int i = 1; i < patternLen; i ++) {
					while(j > 0 && pattern.charAt(i) != pattern.charAt(j)) {
						j = failTable[j - 1];
					}
					if(pattern.charAt(i) == pattern.charAt(j)) {
						j ++;
						failTable[i] = j;
					}
				}
				j = 0;
				int count = 0;
				
				for(int i = 0; i < str.length(); i ++) {
					while(j > 0 && str.charAt(i) != pattern.charAt(j)) {
						j = failTable[j-1];
					}
					
					if(str.charAt(i) == pattern.charAt(j)) {
						j ++;
						
						if(j == patternLen) {
							count ++;
							j = 0;
						}
					} else {
						break;
					}
				}
				
				if(count == str.length() / patternLen) {
					answer = count;
					break;
				}
				
				
			}
*/
