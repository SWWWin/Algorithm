
import java.util.PriorityQueue;

public class Programmers_Heap_1 {
	/*
	 * 1. 큐에 모든 스코빌 지수 삽입
	 * 
	 * 2. 먄약 큐 안에 있는 모든 수가 k보다 크다면 break;
	 * 3. 가장 작은 수 pop + 두번째 작은 수 pop * 2
	 * 4. 만든 결과 add
	 * 5. answer ++
	 */
	
	public static void main(String[] args) {
		int[] a = {1,2,3,9,10,12};
		System.out.println(solution(a, 7));
	}
	
	public static int solution(int[] scoville, int K) {
        int answer = 0;
        boolean isNonZero = false;
        
        
        PriorityQueue<Integer> heap = new PriorityQueue<>();
        
        for(int s: scoville) {
        	heap.add(s);
        	if(s != 0) isNonZero = true;
        }
        
        if(isNonZero == false) {
        	answer = -1;
        	return answer;
        }
        
        while(true) {
        	if(heap.peek() >= K) {
        		break;
        	}
        	
        	if(heap.size() >= 2) {
        		heap.add(heap.poll() + heap.poll() * 2);
            	answer ++;
        	} else {
        		answer = -1;
        		return answer;
        	}
        }
        return answer;
    }
}
