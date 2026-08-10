import java.util.*;

class Programmers_FD {
    public static void main(String[] args) {
        Programmers_FD solution = new Programmers_FD();
        int[] progresses = {93, 30, 55};
        int[] speeds = {1, 30, 5};
        int[] result = solution.solution(progresses, speeds);
        System.out.println(Arrays.toString(result));
    }
    public int[] solution(int[] progresses, int[] speeds) {
        Map<Integer, Integer> map = new HashMap<>();
        int[] day = new int[progresses.length];

        for(int i = 0; i < progresses.length; i ++) {
            day[i] = (100 - progresses[i]) / speeds[i];
            if((100 - progresses[i]) % speeds[i] != 0) {
                day[i] ++;
            }
        }

        map.put(0, 1);
        int index = 0;
        for(int i = 1; i < progresses.length; i ++) {
            if(day[i-1] > day[i]) {
                day[i]= day[i-1];
            }

            if(day[i-1] == day[i]) {
                map.put(index, map.get(index) + 1);
            } else {
                index ++;
                map.put(index, 1);
            }
        }

        int[] answer = new int[map.size()];
        for(int i = 0; i < map.size();i ++) {
            answer[i] = map.get(i);
            System.out.println(map.get(i));
        }
        return answer;
    }
}
