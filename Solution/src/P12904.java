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
//        		for(int j = 0; j <= i / 2 - 1; j ++) {
//        			if(s.charAt(start + j) != s.charAt(start + i - j - 1)) {
//        				isSame = false;
//        				break;
//        			}
//        		}
        		
        		int p = s.substring(start, start + i).hashCode();
        		int r = rev.substring(answer - start - i, answer - start).hashCode();
        		
        		
        		if(p == r) {
        			answer = i;
        			return answer;
        		}
        	}
        	
        	
        }
        return answer;
    }
}
