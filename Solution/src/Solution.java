import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;

public class Solution {

    /*
    1. 하나씩 stack 안에 넣는다
    2. 넣는 과정에서 peek 했을 때 내가 넣으려는 것과 같은 영문이면 pop 한다
    3. 전부 탐색 후 stack의 길이가 0이면 1 아니면 0으로 출력한다
     */

    public static void main(String[] args) {
        System.out.println(solution("abaaba"));
    }
    public static int solution(String s)
    {
        int answer = -1;
        Deque<Character> stack = new ArrayDeque<>();

        for(int c = 0; c < s.length(); c ++) {
            if(stack.isEmpty() || stack.peek() != s.charAt(c)) {
                stack.push(s.charAt(c));
            } else if (stack.peek() == s.charAt(c)) {
                stack.pop();
            }
        }

        if(stack.isEmpty()) answer = 1;
        else answer = 0;
        return answer;
    }
}
