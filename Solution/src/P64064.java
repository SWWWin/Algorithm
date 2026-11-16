import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


public class P64064 {
	static int answer = 0;
	static List<Set<String>> candidates;
	static List<List<String>> canEnterWords;
	static int BANNED;
	static int USER;
	 public int solution(String[] user_id, String[] banned_id) {
	        answer = 0;
	        canEnterWords = new ArrayList<>(); // banned_id로 될 수 있는 후보들을 삽입
	        candidates = new ArrayList<>();
	        
	        
	        
	        BANNED = banned_id.length;
	        USER = user_id.length;
	        
	        for (int patternIndex = 0; patternIndex < banned_id.length; patternIndex++) {
	            canEnterWords.add(new ArrayList<>());
	        }
	        
	        
	        for(int i = 0; i < user_id.length; i ++) {
	        	for(int j = 0; j < banned_id.length; j ++) {
	        		if(user_id[i].length() != banned_id[j].length()) continue;
	        		boolean isSame = true;
	        		for(int k = 0; k < banned_id[j].length(); k ++) {
	        			if(banned_id[j].charAt(k) == '*') continue;
	        			if(user_id[i].charAt(k) != banned_id[j].charAt(k)) {
	        				isSame = false;
	        				break;
	        			}
	        		}
	        		
	        		if(isSame) {
	        			canEnterWords.get(j).add(user_id[i]);
	        		}
	        		
	        	}
	        } 
	        
	        
	        dfs(0, new HashSet<>());
	        
	        return answer;
	    }
	private void dfs(int depth, HashSet<String> candi) {
		if(depth == BANNED) {
			boolean isNew = true;
			for(int i = 0; i < candidates.size(); i ++) {
				if(candi.equals(candidates.get(i))) {
					isNew = false;
					break;
				}
			}
			
			if(isNew) {
				candidates.add(new HashSet<>(candi));
				answer ++;
				
			}
			return;
		}
		
		for(int i = 0; i < canEnterWords.get(depth).size(); i ++) {
			if (!candi.add(canEnterWords.get(depth).get(i))) {
	            continue;
	        }
			
			dfs(depth + 1, candi);
			candi.remove(canEnterWords.get(depth).get(i));
			
		}
		
	}
}
