package Sol;

import java.util.Stack;

public class Programmers_StockPrice {
/*
 * 스택 사용
 * 순서대로 스택에 price를 넣는다
 * 만약 삽입 순간에 peek 값> 현재 넣으려는 값이라면 stack에서 pop한다
 * 언제 떨어졌는지: 넣으려는 값의 위치 - peek값의 위치
 * 스택에 남은 것들은 길이 - 자신의 위치
 */
	
	public static void main(String[] args) {
		int[] arr = {4,2,3,1,7};
		int[] arrr = solution(arr);
		for(int a: arrr) {
			System.out.println(a);
		}
	}
	
	public static int[] solution(int[] prices) {
        int[] answer = new int[prices.length];
        Stack<Integer> stack = new Stack<>();
        
      
        for(int p = 0; p < prices.length; p ++) {
        	if(stack.isEmpty()) {
        		stack.add(p);
        		continue;
        	}
        	
        	while(!stack.isEmpty() &&prices[stack.peek()] > prices[p]) {
        		int index = stack.pop();
        		answer[index] = p - index;
        		
        		
        	}
        	
        	stack.add(p);
        }
        
        for(int i: stack) {
        	answer[i] = prices.length - i - 1;
        	
        }
        
        return answer;
    }
}
