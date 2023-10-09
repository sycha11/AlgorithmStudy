
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String str = br.readLine();
		String boom = br.readLine();
		
		Stack<Character> st = new Stack<>();
		for(int i=0; i<str.length(); i++) {
			st.push(str.charAt(i));
			if(st.size() >= boom.length()){
				boolean flag = true;
				for(int j=0; j<boom.length(); j++) {
					if(st.get(st.size() - boom.length()+j) != boom.charAt(j)) {
						flag = false;
						break;
					}
				}
				if(flag) {
					for(int j=0; j<boom.length(); j++) {
						st.pop();
					}
				}
			}
		}
		
		StringBuilder sb = new StringBuilder();
		for(Character c : st) {
			sb.append(c);
		}
		if(sb.length()==0) {
			System.out.println("FRULA");
		} else {
			System.out.println(sb);
		}
	}

}
