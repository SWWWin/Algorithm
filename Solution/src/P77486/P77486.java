package P77486;

public class P77486 {
    /*
    노드의 value: 자신이 발생한 이익 (내가 끌어들인 사람의 10%까지 추가한 값)
     enroll: 판매원들의 이름(노드)
     referral: 판매원을 다단계 조직에 참여시칸 사람(부모 노드)
     seller: 판매량 집계 데이터의 판매원 이름 나열한 배열
     amount: 판매량 집계 데이터의 판매 수량을 나열한 배열

     자식이 없는 것 체크 - leaf 노드임
     leaf노드에서부터 출발해서 최상단 노드인 john까지 이동할 수 있도록 구현
     */

    static int N;
    public int[] solution(String[] enroll, String[] referral,
                          String[] seller, int[] amount) {

        N = enroll.length;
        int[] profit = new int[N];

        for (int idx = 0; idx < seller.length; idx++) {

            String current = seller[idx];
            int money = amount[idx] * 100;

            while (!current.equals("-") && money > 0) {

                int currentIndex = -1;

                for (int i = 0; i < N; i++) {
                    if (enroll[i].equals(current)) {
                        currentIndex = i;
                        break;
                    }
                }

                int commission = money / 10;

                profit[currentIndex] += money - commission;

                if (commission == 0) break;

                current = referral[currentIndex];
                money = commission;
            }
        }

        return profit;
    }
}

