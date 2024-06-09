import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {

	static class Node{
        HashMap<String, Node> child;
        public Node(){
            child = new HashMap<>();
        }
    }
    static int n;
    static Node root = new Node();
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        StringTokenizer st;
        for(int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            int k = Integer.parseInt(st.nextToken());
            Node cur = root;
            for(int j=0; j<k; j++){
                String str = st.nextToken();
                if(!cur.child.containsKey(str)){ // 자식에 없다면
                    cur.child.put(str, new Node());
                }
                cur= cur.child.get(str);
            }
        }
        tree(root, "");
        System.out.println(sb);
    }

    static void tree(Node cur, String s) {
    	ArrayList<String> list = new ArrayList<>(cur.child.keySet());
    	Collections.sort(list);
    	for(String str : list) {
    		sb.append(s).append(str).append("\n");
    		tree(cur.child.get(str), s + "--");
    	}
    }
}