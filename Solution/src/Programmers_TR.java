

import java.util.ArrayDeque;
import java.util.Queue;

/*
 * cross_bridge: 건너고 있는 차
 * truck_info: 건너려고 기다리는 차

 * 
 * 
 * 1. 만약 cross_bridge가 가진 초가 다리의 길이와 같아지는 경우 큐에서 내보낸다
 * 2. 현재 다리 위에 있는 차의 무게 + 들어가려는 차의 무게 <= weight && 현재 다리 위에 있는 차 갯수 + 1 <= bridge_length
 * 인 경우 다리 위로 차를 하나 넣는다
 * 3. 큐가 비어 있으면 끝낸다 
 */
public class Programmers_TR {
	public static void main(String[] args) {
		int[] truck_weights = {10};
		System.out.println(solution(100,100,truck_weights));
	}
	
	public static int solution(int bridge_length, int weight, int[] truck_weights) {
	        int sec = 0;
	        Queue<Integer[]> cross_bridge = new ArrayDeque<>();
	        Queue<Integer[]> truck_info = new ArrayDeque<>();
	        
	        
	        for(int t = 0; t < truck_weights.length; t ++) {
	        	Integer[] info = {truck_weights[t],0};
	        	truck_info.add(info);
	        }
	        
	        cross_bridge.add(truck_info.poll());
	        while(true) {
	        	int bridge_weight = 0;
	        	
	        	sec ++;
	        	
	        	if(cross_bridge.peek()[1] + 1 == bridge_length) {
	        		cross_bridge.poll();
	        	}
	        	
	        	for(Integer[] q: cross_bridge) {
	        		bridge_weight += q[0];
	        		q[1] ++;
	        		System.out.println(sec + " " + q[0] + " " + q[1]);
	        	}
	   
	        	
	        	if(cross_bridge.size() + 1 <= bridge_length && !truck_info.isEmpty() && bridge_weight + truck_info.peek()[0] <= weight) {
	        		cross_bridge.add(truck_info.poll());
	        	
	        	}
	        	
	   
	        
	        	if(cross_bridge.isEmpty() && truck_info.isEmpty()) {
	        		break;
	        	}
	        	
	        	
	        	
	        	
	        	
	        }
	        
	       return sec + 1;
	    }
}
