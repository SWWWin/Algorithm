package P42892;

import java.util.ArrayList;
import java.util.Arrays;


class Node {
    int x, y, num;
    Node left;
    Node right;

    Node(int x, int y, int num) {
        this.x = x;
        this.y = y;
        this.num = num;
    }
}
// 이진 트리는 맞으나 완전 이진 트리가 아니므로 클래스를 만들어 전위, 후위 순회를 한다
// 제일 바닥이 루트인 트리로 생각

public class P42892 {
	
	static Node[] tree; 
	ArrayList<Integer> pre = new ArrayList<>();
    ArrayList<Integer> post = new ArrayList<>();
    
    public int[][] solution(int[][] nodeinfo) {

        tree = new Node[nodeinfo.length];

        for (int i = 0; i < nodeinfo.length; i++) {
            tree[i] = new Node(nodeinfo[i][0], nodeinfo[i][1], i + 1);
        }

        // 1. 가장 위(y 큰) 노드부터 정렬
        Arrays.sort(tree, (a, b) -> {
            if (a.y != b.y) return b.y - a.y;
            return a.x - b.x;
        });

        // 2. 첫 노드가 루트
        Node root = tree[0];

        // 3. 나머지 노드를 x 기준으로 트리에 연결
        for (int i = 1; i < tree.length; i++) {
            insert(root, tree[i]);
        }

        preOrder(root);
        postOrder(root);

        int[][] answer = new int[2][nodeinfo.length];

        for (int i = 0; i < nodeinfo.length; i++) {
            answer[0][i] = pre.get(i);
            answer[1][i] = post.get(i);
        }

        return answer;
    }
    
	private void postOrder(Node now) {
		if(now == null) return;
		
		
		postOrder(now.left);
		postOrder(now.right);
		post.add(now.num);
		
	}

	private void preOrder(Node now) {
		if(now == null) return;
		pre.add(now.num);
		preOrder(now.left);
		preOrder(now.right);

		
		
	}

	private void insert(Node parent, Node child) {
		if (child.x < parent.x) {
            if (parent.left == null) {
                parent.left = child;
            } else {
                insert(parent.left, child);
            }
        } else {
            if (parent.right == null) {
                parent.right = child;
            } else {
                insert(parent.right, child);
            }
        }
	}
}
