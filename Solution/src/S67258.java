import java.util.*;

public class S67258 {

    public static void main(String[] args) {
        String[] gems = {"DIA", "RUBY", "RUBY", "DIA", "DIA", "EMERALD", "SAPPHIRE", "DIA"};
        System.out.println(Arrays.toString(solution(gems)));
    }

    public static int[] solution(String[] gems) {
        int[] answer = new int[2];

        Set<String> set = new HashSet<>();

        for (String gem : gems) {
            set.add(gem);
        }

        Map<String, Integer> map = new HashMap<>();

        int left = 0;
        int min = Integer.MAX_VALUE;

        for (int right = 0; right < gems.length; right++) {

            // 오른쪽 보석 하나 추가
            map.put(gems[right],
                    map.getOrDefault(gems[right], 0) + 1);

            // 모든 종류가 들어있는 동안
            while (map.size() == set.size()) {

                int len = right - left + 1;

                if (len < min) {
                    min = len;
                    answer[0] = left + 1;
                    answer[1] = right + 1;
                }

                map.put(gems[left], map.get(gems[left]) - 1);

                if (map.get(gems[left]) == 0) {
                    map.remove(gems[left]);
                }

                left++;
            }
        }

        return answer;
    }
}
