import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static class Node{
        char data;
        Node left;
        Node right;

        public Node(char data){
            this.data = data;
        }
    }

    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        Node[] nodeArr = new Node[N];

        char a = 'A';
        for(int i=0; i<N; i++){
            nodeArr[i] = new Node(a++);
        }

        for(int i=0; i<N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());

            int idx = st.nextToken().charAt(0) - 'A';
            char left = st.nextToken().charAt(0);
            char right = st.nextToken().charAt(0);

            if(left == '.'){
                nodeArr[idx].left = null;
            } else {
                nodeArr[idx].left = nodeArr[left - 'A'];
            }

            if(right == '.'){
                nodeArr[idx].right = null;
            } else {
                nodeArr[idx].right = nodeArr[right - 'A'];
            }
        }

        System.out.println(preOrder(nodeArr[0]));
        System.out.println(inOrder(nodeArr[0]));
        System.out.println(postOrder(nodeArr[0]));

    }

    // 전위순회 중왼오
    private static String preOrder(Node node){
        String answer = "";
        // 중간
        answer += node.data;

        // 왼쪽
        if(node.left != null){
            answer += preOrder(node.left);
        }
        // 오른쪽
        if(node.right != null){
            answer += preOrder(node.right);
        }

        return answer;
    }

    // 중위순회 : 왼중오
    private static String inOrder(Node node) {
        String answer = "";

        // 왼쪽
        if(node.left != null){
            answer += inOrder(node.left);
        }

        // 중간
        answer += node.data;

        // 오른쪽
        if(node.right != null){
            answer += inOrder(node.right);
        }

        return answer;
    }


    // 후위순회 : 왼오중
    private static String postOrder(Node node) {
        String answer = "";

        // 왼쪽
        if(node.left != null){
            answer += postOrder(node.left);
        }
        // 오른쪽
        if(node.right != null){
            answer += postOrder(node.right);
        }

        // 중간
        answer += node.data;

        return answer;
    }

}