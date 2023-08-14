import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		Stack<Integer> st = new Stack<>();
		
		for(int i=0; i<n; i++) {
			String[] str = br.readLine().split(" ");
			if(str[0].equals("push")) {
				int k = Integer.parseInt(str[1]);
				st.push(k);
			} else if(str[0].equals("top")) {
				if(st.isEmpty()) {
					System.out.println(-1);
				} else {
					System.out.println(st.peek());
				}
			} else if(str[0].equals("size")) {
				System.out.println(st.size());
			} else if(str[0].equals("empty")) {
				if(st.isEmpty()) {
					System.out.println(1);
				} else {
					System.out.println(0);
				}
			} else if(str[0].equals("pop")) {
				if(st.isEmpty()) {
					System.out.println(-1);
				} else {
					System.out.println(st.pop());
				}
			}
		}
		
	}
}