import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class Solution {

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = 10;
		for(int tc=1; tc<=T; tc++) {
			int n = Integer.parseInt(br.readLine());
			
			String str = br.readLine();
			
			Stack<Character> st = new Stack<>();
			
			for(int i=0; i<str.length(); i++) {
				char inputC = str.charAt(i);
				// 닫히는게 있으면 pop
				if(inputC == ')') { 
					if(st.peek() == '(') {
						st.pop();
					} else {
						st.add(inputC);
					}
				} else if(inputC == ']') {
					if(st.peek() == '[') {
						st.pop();
					} else {
						st.add(inputC);
					}
				} else if(inputC == '}') {
					if(st.peek() == '{') {
						st.pop();
					} else {
						st.add(inputC);
					}
				} else if(inputC == '>') {
					if(st.peek() == '<') {
						st.pop();
					}else {
						st.add(inputC);
					}
				} else {
					st.add(inputC);
				}
			}
			if(st.isEmpty()) {
				System.out.println("#" + tc + " " + 1);
			} else {
				System.out.println("#" + tc + " " + 0);
			}
		}
		
	}

}