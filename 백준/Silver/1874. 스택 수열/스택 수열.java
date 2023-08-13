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
		
		for(int i=0; i<n; i++) {
			list.add(Integer.parseInt(br.readLine()));
		}
		
		int cnt = 1;
		st.push(cnt++);
		sb.append("+").append("\n");
		
		while(!st.isEmpty() && list.size() > 0) {
			if(list.get(0) < st.peek()) { // 원하는 값보다 크다면 뽑을 수 없음
				flag = true; 
				break;
			} 
			
			if(list.get(0).intValue() == st.peek().intValue()) { // 스택의 top과 숫자와 리스트 0번째 숫자가 같다면 pop
				st.pop();
				list.remove(0);
				sb.append("-").append("\n");
				if(st.isEmpty() && cnt <= n) { // 비어있지만 n 이하면 cnt 추가
					st.push(cnt++);
					sb.append("+").append("\n");
				}
			} else { // 다르면 cnt push
				st.push(cnt++);
				sb.append("+").append("\n");
			}
			
//			System.out.println(sb);
		}
		
		if(flag) {
			System.out.println("NO");
		} else {
			System.out.println(sb);
		}
		
	}

}
