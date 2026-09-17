import java.util.*;
import java.io.*;
 
class Atom {
    int x, y, dir, energy;
 
    Atom(int x, int y, int dir, int energy) {
        this.x = x;
        this.y = y;
        this.dir = dir;
        this.energy = energy;
    }
}
 
public class S5648 {
 
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {1, -1, 0, 0};
 
    // 좌표 -2000 ~ 2000
    static final int OFFSET = 2000;
    static final int SIZE = 4001;
 
    public static void main(String[] args) throws Exception {
 
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
 
        int T = Integer.parseInt(br.readLine());
        StringBuilder answer = new StringBuilder();
 
        // 현재 좌표에 몇 번째 원자가 있는지
        // 0 = 없음
        int[] map = new int[SIZE * SIZE];
 
        // 매 턴 map 전체를 초기화하지 않기 위해 사용
        int[] used = new int[1000];
 
        for (int tc = 1; tc <= T; tc++) {
 
            int N = Integer.parseInt(br.readLine());
 
            ArrayList<Atom> atoms = new ArrayList<>(N);
 
            for (int i = 0; i < N; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
 
                int x = Integer.parseInt(st.nextToken()) * 2;
                int y = Integer.parseInt(st.nextToken()) * 2;
                int dir = Integer.parseInt(st.nextToken());
                int energy = Integer.parseInt(st.nextToken());
 
                atoms.add(new Atom(x, y, dir, energy));
            }
 
            int sum = 0;
 
            while (atoms.size() > 1) {
 
                int size = atoms.size();
 
                boolean[] pop = new boolean[size];
                int usedCnt = 0;
 
                // 이동 + 위치 기록
                for (int i = 0; i < size; i++) {
 
                    Atom atom = atoms.get(i);
 
                    atom.x += dx[atom.dir];
                    atom.y += dy[atom.dir];
 
                    /*
                     * 초기 영역을 진행 방향으로 완전히 벗어난 원자는
                     * 이후 충돌할 수 없으므로 아래에서 제거
                     */
                    if (atom.x < -OFFSET || atom.x > OFFSET ||
                        atom.y < -OFFSET || atom.y > OFFSET) {
                        continue;
                    }
 
                    int pos =
                        (atom.x + OFFSET) * SIZE
                        + (atom.y + OFFSET);
 
                    if (map[pos] == 0) {
 
                        // i+1 저장
                        map[pos] = i + 1;
                        used[usedCnt++] = pos;
 
                    } else {
 
                        int before = map[pos] - 1;
 
                        pop[before] = true;
                        pop[i] = true;
                    }
                }
 
                // 살아남은 원자만 다음 리스트로
                ArrayList<Atom> next = new ArrayList<>(size);
 
                for (int i = 0; i < size; i++) {
 
                    Atom atom = atoms.get(i);
 
                    if (pop[i]) {
                        sum += atom.energy;
                        continue;
                    }
 
                    // 범위 밖이면 제거
                    if (atom.x < -OFFSET || atom.x > OFFSET ||
                        atom.y < -OFFSET || atom.y > OFFSET) {
                        continue;
                    }
 
                    next.add(atom);
                }
 
                // 이번 턴에 사용한 map 칸만 초기화
                for (int i = 0; i < usedCnt; i++) {
                    map[used[i]] = 0;
                }
 
                atoms = next;
            }
 
            answer.append("#")
                  .append(tc)
                  .append(" ")
                  .append(sum)
                  .append('\n');
        }
 
        System.out.print(answer);
    }
}