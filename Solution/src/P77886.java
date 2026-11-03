import java.util.Arrays;

public class P77886 {
	public static void main(String[] args) {
		System.out.println(solution(new String[] {"1110", "100111100"}));
	}
	
	public static String[] solution(String[] s) {
        String[] answer = new String[s.length];
        
        for(int nextStr = 0; nextStr < s.length; nextStr ++) {
        	int pNum = 0; //110이 몇 개 들어있는가
        	
        	String nowStr = s[nextStr];
        	
        	StringBuilder sb = new StringBuilder();
        	
        	for (int i = 0; i < nowStr.length(); i++) {
        		sb.append(nowStr.charAt(i));
        		
        		int len = sb.length();
        	    if (len >= 3 && sb.substring(len - 3).equals("110")) {
        	        pNum++;
        	        sb = sb.delete(len - 3, len);
        	    }
        	}
        	
        	
        	 int index = sb.lastIndexOf("0") + 1;
        	 StringBuilder result = new StringBuilder();
        	 result.append(sb.substring(0, index));

             // 제거한 110 다시 삽입
             for (int i = 0; i < pNum; i++) {
                 result.append("110");
             }
             
             result.append(sb.substring(index));

             answer[nextStr] = result.toString();
        	
        }
        return answer;
    }
    
}
