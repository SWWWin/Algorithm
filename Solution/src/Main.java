import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

import com.sun.xml.internal.ws.dump.LoggingDumpTube.Position;

public class Main {
    public static void main(String[] args) throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	int N = Integer.parseInt(br.readLine());
    	int K = Integer.parseInt(br.readLine());
    	
    	int[] positions = new int[N];
    	StringTokenizer st = new StringTokenizer(br.readLine());
    	for(int n = 0; n < N; n ++) {
    		positions[n] = Integer.parseInt(st.nextToken());
    	}
    	
    	boolean[] repair = new boolean[positions[N-1]];
    	for(int n = 0; n < N; n ++) {
    		repair[positions[n]] = true;
    	}
    	
    	
    	while() {
    		
    	}
    }
}