import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
 * 이진 트리이기 때문에 트리의 간선 수가 많지 않아 인접 리스트로 구현하였다.
 */

class Node {
	String value;
	int left;
	int right;
	
	public Node(String value) {
		super();
		this.value = value;
	}
	
}



public class S1232 {
	static int TC = 10;
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		for(int tc = 1; tc <= TC; tc ++) {
			
			int N = Integer.parseInt(br.readLine());
			
			Node[] tree = new Node[N + 1];
			
			for(int n = 1; n <= N; n ++) {
				String[] str = br.readLine().split(" ");
				Node node = new Node(str[1]);
				
				if(str.length > 3) {
					node.left = Integer.parseInt(str[2]);
					node.right = Integer.parseInt(str[3]);
				}
				
				tree[n] = node;
			}
		
			int answer = calculate(1, tree);
			StringBuilder sb = new StringBuilder();
			sb.append("#").append(tc).append(" ").append(answer);
			System.out.println(sb);
		}
		
	}
	
	static int calculate(int index, Node[] tree) {

	    Node now = tree[index];

	    
	    if (isInteger(now.value)) {
	        return Integer.parseInt(now.value);
	    }

	    int left = calculate(now.left, tree);
	    int right = calculate(now.right, tree);

	    int next = 0;
	    
	    switch(now.value) {
		    case "+":
		    	next = left + right;
		    	break;
		    	
		    case "-":
		    	next = left - right;
		    	break;
		    	
		    case "*":
		    	next = left * right;
		    	break;
		    	
		    case "/":
		    	next = left / right;
		    	break;
		    	
	    }

	    return next;
	}
	
	static boolean isInteger(String str) {
		if(str.equals("+") || str.equals("-") || str.equals("*") || str.equals("/")) return false;
		
		return true;
	}
}
