class Viewer {
	int start;
	int end;
	
	public Viewer(int start, int end) {
		super();
		this.start = start;
		this.end = end;
	}	
}
public class P72414 {
	public static void main(String[] args) {
		String[] logs = {"01:20:15-01:45:14", "00:40:31-01:00:00", "00:25:50-00:48:29", "01:30:59-01:53:29", "01:37:44-02:02:30"};
		
		System.out.println(solution("02:03:55", "00:14:15", logs));
	}
	public static String solution(String play_time, String adv_time, String[] logs) {

	    int playInt = toSecond(play_time);
	    int advInt = toSecond(adv_time);

	    long[] time = new long[playInt + 1];

	    
	    for (String log : logs) {

	        String[] logSplit = log.split("-");

	        int start = toSecond(logSplit[0]);
	        int end = toSecond(logSplit[1]);

	        time[start]++;
	        time[end]--;
	    }

	    for (int i = 1; i <= playInt; i++) {
	        time[i] += time[i - 1];
	    }

	    for (int i = 1; i <= playInt; i++) {
	        time[i] += time[i - 1];
	    }

	    long max = time[advInt - 1];
	    int answerStart = 0;

	    for (int start = 1;
	         start + advInt <= playInt;
	         start++) {

	        int end = start + advInt - 1;

	        long sum = time[end] - time[start - 1];

	        if (sum > max) {
	            max = sum;
	            answerStart = start;
	        }
	    }

	    return toTime(answerStart);
	}
	
	private static String toTime(int second) {
		int hour = second / 3600;

        second %= 3600;

        int minute = second / 60;
        int sec = second % 60;

        return String.format(
            "%02d:%02d:%02d",
            hour,
            minute,
            sec
        );
	}
	private static int toSecond(String str) {
		String[] secondSplit = str.split(":");
		int[] seconds = new int[3];
		for(int i = 0; i < 3; i ++) { // 3Ä­ »ÓÀÌ´Ï±î 66:66:66
			seconds[i] = Integer.parseInt(secondSplit[i]);
		}
		
		return seconds[0] * 3600 + seconds[1] * 60 + seconds[2];
	}
}
