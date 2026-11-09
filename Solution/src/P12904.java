import com.sun.imageio.plugins.common.SubImageInputStream;

public class P12904 {
	
	public static void main(String[] args) {
		System.out.println(solution("abacde"));
	}
	
	public static int solution(String s)
    {
        int answer = s.length();
        StringBuilder rev = new StringBuilder(s).reverse();
        for(int i = answer; i >= 1; i --) {
        	for(int start = 0; start <= answer - i; start ++) {
        		boolean isSame = true;
        		for(int j = 0; j <= i / 2 - 1; j ++) {
        			if(s.charAt(start + j) != s.charAt(start + i - j - 1)) {
        				isSame = false;
        				break;
        			}
        		}
        		
        		
        		
        		if(isSame) {
        			answer = i;
        			return answer;
        		}
        	}
        	
        	
        }
        return answer;
    }
	
	public static int solution2(String s) {
        int answer = 1;

        for (int i = 0; i < s.length(); i++) {

           
            int left = i;
            int right = i;

            while (left >= 0 && right < s.length()
                    && s.charAt(left) == s.charAt(right)) {

                answer = Math.max(answer, right - left + 1);
                left--;
                right++;
            }

           
            left = i;
            right = i + 1;

            while (left >= 0 && right < s.length()
                    && s.charAt(left) == s.charAt(right)) {

                answer = Math.max(answer, right - left + 1);
                left--;
                right++;
            }
        }

        return answer;
    }
}
