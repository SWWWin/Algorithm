import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

public class Programmers_DP_1 {

    /*
    1. 하나씩 stack 안에 넣는다
    2. 넣는 과정에서 peek 했을 때 내가 넣으려는 것과 같은 영문이면 pop 한다
    3. 전부 탐색 후 stack의 길이가 0이면 1 아니면 0으로 출력한다
     */

    public int solution(int N, int number) {
    	int answer = 0;
    	Set<Integer>[] dp = new HashSet[9];
    	
    	for(int i = 0; i < 9; i ++) {
    		dp[i] = new HashSet<>();
    	}
    	
    	String repeated = "";
    	
    	for(int i = 1; i <= 8; i ++) {
    		repeated += N;
    		dp[i].add(Integer.parseInt(repeated));
    		
    		for(int j = 1; j < i; j ++) {
    			
    			for(int a: dp[j]) {
    				for(int b: dp[i - j]) {
    					dp[i].add(a + b);
    					dp[i].add(a - b);
    					dp[i].add(a * b);
    					
    					if(b!= 0) {
    						dp[i].add(a / b);
    					}
    					
    					if(a != 0) {
    						dp[i].add(b / a);
    					}
    				}
    			}
    		}
    		
    		if(dp[i].contains(number)) {
    			return i;
    		}
    	}
    	return answer == 0? -1: answer;
    }
}
