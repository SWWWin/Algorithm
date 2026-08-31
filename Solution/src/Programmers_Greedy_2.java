
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
        Arrays.sort(people);
        int length = people.length;
        int left = 0;
        int right = length - 1;
        while(left <= right) {
        	if(people[left] + people[right] <= limit) {
        		left ++;
        	}
        	
        	right --;
        	answer ++;
        }
        return answer;
	}
}
