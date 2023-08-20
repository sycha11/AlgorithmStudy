import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		// - 나오면 뒤에 다 빼주기
		String s = br.readLine();
		
		int sum = 0;
		String num = "";
		int mode = 1; // 0 - 1 +
		
		for(int i=0; i<s.length(); i++) {
			char ch = s.charAt(i);
			if(ch != '-' && ch != '+') { // -+ 가 아니면 숫자에 추가
				num += ch;
			}
			if(ch == '-' || ch == '+' || i == s.length()-1) {
				if(mode == 1) {
					sum += Integer.parseInt(num);
				} else {
					sum -= Integer.parseInt(num);
				}
				
				num = ""; // 연산 초기화
			}
			if(ch == '-') {
				mode = 0;
			}
		}
		System.out.println(sum);
		
	}
}