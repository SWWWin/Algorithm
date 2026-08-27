

class Programmers_Greedy_1 {
	/*
	 * 1. 위/아래로 움직여야 하는 양 계산 
	 * int[] shiftDistance: 각각의 글자가 되기 위해 이동해야 하는 값
	 * 
	 * 2. 왼/오로 움직여야 하는 양 계산
	 * next: A의 연속 중 제일 마지막
	 * 1. 왼 -> 오 -> 왼
	 * 2. 오 -> 왼 -> 오
	 * 3. 왼쪽/오른쪽으로 쭉 가기
	 * 
	 * answer = shiftDistance 합 + 왼오 움직이는 양
	 */
	
	public static void main(String[] args) {
		System.out.println(solution("JEROEN"));
	}
    public static int solution(String name) {

        int answer = 0;
        int[] shiftDistance = new int[name.length()];
        boolean haveZero = false;
        for(int i = 0; i < name.length(); i ++) {
        	int shiftfront = name.charAt(i) - 'A';
        	int shiftBack = 'Z' - name.charAt(i) + 1;
        	
        	shiftDistance[i] = Math.min(shiftfront, shiftBack);
        	answer += shiftDistance[i];
        	if(shiftDistance[i] == 0) haveZero = true;
        }
        
        
        int minStright = name.length() - 1;
        int minSum = minStright;
        
    	if(haveZero) {
	        for(int i = 0; i < name.length(); i ++) {
	
	        	int next = i + 1;
	    		while(next < name.length() && shiftDistance[next] == 0) {
	    			next ++;
	    		}
	
	        	int rightUTurn = i * 2 + (name.length() - next);
	        	int leftUTurn = 2 * (name.length() - next) + i;
	        	
	        	int minTurn = Math.min(rightUTurn, leftUTurn);
	        	minSum = Math.min(minSum, minTurn);
	    	
	            
	        }
    	}
        answer += minSum;
        return answer;
    }
}


