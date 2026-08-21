package Sol;

import java.util.ArrayDeque;
import java.util.Collections;
import java.util.Queue;
import java.util.Stack;

public class Programmers_Stack_1 {
	
	public static void main(String[] args) {
		System.out.println(solution("}]()[{"));
	}
	/*
	 * 1. String의 각 값을 queue에 넣어 삽입-삭제 반복
	 * 2. queue 안의 값을 stack에 넣어 괄호 문자열이 올바른지/몇 개인지 확인
	 * 	2-1. {[(이면 스택에 삽입
	 *  2-2. )}]이면 상대 찾아 pop
	 *  2-3. 스택의 상황을 봤을 때 제대로 된 괄호가 아니면 break 후 다음 queue로 이동
	 *  2-3. 스택 내부가 0이 되면 answer ++
	 */
    public static int solution(String s) {
    	
        int answer = 0;
        int start = 0;
        
        for(int t = 0; t < s.length(); t ++) {
        	Stack<Character> stack = new Stack<>();
        	boolean vaild = true;
        	for(int i = 0; i < s.length(); i ++) {
        		int index = (start + i)% s.length();
        		
        		if(i == 0) {
        			if(s.charAt(index) == '{' || s.charAt(index) == '[' || s.charAt(index) == '(') {
        				stack.add(s.charAt(index));
        				continue;
        			} else {
        				vaild = false;
        				break;
        			}
        		} else {
        			if(s.charAt(index) == '{' || s.charAt(index) == '[' || s.charAt(index) == '(') {
            			stack.add(s.charAt(index));
            			continue;
            		}

            		System.out.println( " " + s.charAt(index) + " " + index);
            		
            		
            		if(stack.isEmpty()) {
            			vaild = false;
            			break;
            		}
            		
            		
            		if(stack.peek() == '(' && !(s.charAt(index) == ')')) {
            			vaild = false;
            			break;
            		}
            		else if(stack.peek() == '{' && !(s.charAt(index) == '}')) {
            			vaild = false;
            			break;
            		}
            		else if(stack.peek() == '[' && !(s.charAt(index) == ']')) {
            			vaild = false;
            			break;
            		}
            		
            		
        		
            		stack.pop();
        		}
        		
        		
        		}
        	
        	if(vaild &&stack.isEmpty()) {
    			answer ++;
    		}
        	
        	start ++;
        }
        return answer;
    }
}
