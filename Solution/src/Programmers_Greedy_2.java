
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;

public class Programmers_Greedy_2 {
	
	public static void main(String[] args) {
		int[] people = {70, 50, 80, 50};
		System.out.println(solution(people, 100));
	}
	
	public static int solution(int[] people, int limit) {
        int answer = 0;
        
        ArrayList<Integer> peopleList = new ArrayList<>();
        for(int p: people) {
        	peopleList.add(p);
        }
        
        Collections.sort(peopleList);
        
        
        int start = 0;
        int end = people.length - 1;
        while(true) {
        	if(start > end) {
        		break;
        	} else if(start == end) {
        		answer ++;
        		break;
        	}
        	if(peopleList.get(end) + peopleList.get(start) <= limit) {
        		answer ++;
        		start ++;
        		end --;
        		continue;
        	} else {
        		answer ++;
        		end --;
        	}
        }
        
        return answer;
    }
}
