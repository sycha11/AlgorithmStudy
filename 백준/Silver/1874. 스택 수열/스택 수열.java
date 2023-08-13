import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Stack;


public class Main {

	public static void main(String[] args) throws IOException{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		
		ArrayList<Integer> list = new ArrayList<>(); //입력 리스트
		Stack<Integer> st = new Stack<>(); 
		StringBuilder sb = new StringBuilder();
		boolean flag = false;
		int top = 0;
		
		for(int i=0; i<n; i++) {
			int idx = Integer.parseInt(br.readLine());
			
			if(top < idx) { // 넣는값이 top 보다 크다면
				for(int j=top+1; j<=idx; j++) { // 위에 있는거부터 찾는값까지 스택에 넣기
					st.push(j);
					sb.append("+").append("\n");
				}
				top = idx;
			} else {
				if(st.peek() != idx) {
					flag = true;
					break;
				}
			} 
			st.pop();
			sb.append("-").append("\n");
			
		}
		
		if(flag) {
			System.out.println("NO");
		} else {
			System.out.println(sb);
		}
	}

}