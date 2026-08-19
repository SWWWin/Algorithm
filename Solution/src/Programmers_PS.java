import java.util.*;

class Job {
    int priority;
    int location;

    public Job(int priority, int location) {
        this.priority = priority;
        this.location = location;
    }
}
public class Programmers_PS {

    public static void main(String[] args) {
        int[] p = {1,1,9,1,1,1};
        int location = 0;
        System.out.println(solution(p, location));
    }


    /*
    기본 아이디어
    1. 큐에 원래 위치와 함께 우선순위 삽입
    2. 삽입 후 queue를 poll하여 우선순위가 가장 높은지 확인
        2-1. 가장 높으면 queue에서 그대로 삭제
            2-1-1. 현재 찾는 location과 같은 원래 위치를 가졌다면 break
        2-2. 가장 높지 않다면 queue에 새로 등록

     */

    public static int solution(int[] priorities, int location) {
        int answer = 0;
        Queue<Job> queue = new ArrayDeque<>();

        for(int p = 0; p < priorities.length; p ++) {

            Job job = new Job(priorities[p], p);

            queue.add(job);


        }

        while(!queue.isEmpty()) {
            Job now = queue.poll();

            boolean hasHigherPriority = true;
            for(Job q: queue) {
                if(now.priority < q.priority) {
                    hasHigherPriority = false;

                    break;
                }

            }


            if(hasHigherPriority) {
                answer++;
                if(now.location == location) {

                    break;
                }
            } else {
                queue.add(now);
            }


        }
        return answer;
    }
}
