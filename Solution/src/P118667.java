import java.util.ArrayDeque;
import java.util.Collections;
import java.util.Queue;


public class P118667 {
	
	public static void main(String[] args) {
		System.out.println(solution(new int[] {1,2,1,2}, new int[] {1,10,1,2}));
	}
	public static int solution(int[] queue1, int[] queue2) {
        int answer = -1;
        int len = queue1.length;
        Queue<Integer> q1 = new ArrayDeque<>();
        Queue<Integer> q2 = new ArrayDeque<>();
        
        int add1 = 0;
        int add2 = 0;
        
        for(int i = 0; i < len; i ++) {
        	q1.add(queue1[i]);
        	q2.add(queue2[i]);
        	add1 += queue1[i];
        	add2 += queue2[i];
        }
        
        int turn = 0;
        
        if((add1 + add2) % 2 != 0) {
        	return -1;
        }
        
        while(add1 != add2 && turn < 3 * len) {
        	
        	if(add1 > add2) {
        		int pop = q1.poll();
        		q2.add(pop);
        		add2 += pop;
        		add1 -= pop;
        	} else {
        		int pop = q2.poll();
        		q1.add(pop);
        		add1 += pop;
        		add2 -= pop;
        	}
        	
        	turn ++;
        	
        	

        }
        

		return add1 == add2? turn: -1;
    }
}
