
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	static class Node {
		// 노드명
		char data;
		// 자식 노드
		Node left, right;
		
		public Node(char data) {
			this.data = data;
		}
		public String toString() {
			return data + "";
		}
	}
	// 노드 개수
	static int N;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		// 노드 개수 입력
		N = Integer.parseInt(br.readLine());
		
		// 노드들을 담을 배열 생성
		Node[] nodeArr = new Node[N];
		
		// 노드 이름
		char name = 'A';
		
		//노드를 배열에 입력하는 반복문
		for(int i=0; i<N; i++) {
			nodeArr[i] = new Node(name++);
		}
		
		// 자식 정보를 입력하는 반복문
		for(int i=0; i<N; i++) {
			//한 줄을 읽어온 후
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			int idx = st.nextToken().charAt(0) -'A';
			char left = st.nextToken().charAt(0);
			char right = st.nextToken().charAt(0);
			
			// 자식 정보 입력
			nodeArr[idx].left = (left =='.') ? null : nodeArr[left -'A'];
			nodeArr[idx].right = (right == '.') ? null : nodeArr[right - 'A'];
			
		}
		
		System.out.println(preorder(nodeArr[0]));
		System.out.println(inorder(nodeArr[0]));
		System.out.println(postorder(nodeArr[0]));
		
	}
	
	// 전위 순회
	private static String preorder(Node node){
		// 반환 문자열
		String result = "";
		
		// 전위순회이므로 현재 노드 데이터부터 연결
		result += node.data;
		
		// 왼쪽 자식 노드가 있으면 연결
		if(node.left != null) {
			result += preorder(node.left);
		}
		
		// 오른쪽 자식 노드가 있으면 연결
		if(node.right != null) {
			result += preorder(node.right);
		}
		
		return result;
	}
	
	// 중위 순회
	private static String inorder(Node node) {
		// 반환 문자열
		String result = "";
		
		// 중위 순회이므로 왼쪽 노드부터 연결
		if(node.left != null) {
			result += inorder(node.left);
		}
		
		result += node.data;
		
		if(node.right != null) {
			result += inorder(node.right);
		}
		
		return result;
	}

	// 후위 순회
		private static String postorder(Node node) {
			// 반환 문자열
			String result = "";
			
			if(node.left != null) {
				result += postorder(node.left);
			}
			
			if(node.right != null) {
				result += postorder(node.right);
			}
			result += node.data;

			return result;
		}
}
