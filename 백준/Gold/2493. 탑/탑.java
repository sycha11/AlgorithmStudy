import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		Stack<int[]> s = new Stack<>();
		
		int[] answer = new int[n+1];
		
		s.add(new int[] {Integer.parseInt(st.nextToken()),1});
		for(int i=2; i<=n; i++) {
			int input = Integer.parseInt(st.nextToken());
			
			while(!s.isEmpty()) {
				
				if(s.peek()[0] < input) { // 입력이 더 크면	
					//앞을 다 찾아본다
					while(!s.isEmpty()) {
						if(s.peek()[0] > input) {
							answer[i] = s.peek()[1];
							break;
						}
						s.pop();
					}
				} else { // 입력이 더 작으면
					answer[i] = s.peek()[1];
					s.add(new int[] {input, i});
					break;
				}
			}
			if(s.isEmpty()) {
				answer[i] = 0;
				s.add(new int[] {input, i});
			} 
			
		}
		
		for(int i=1; i<=n; i++) {
			System.out.print(answer[i] + " ");
		}
	}

}