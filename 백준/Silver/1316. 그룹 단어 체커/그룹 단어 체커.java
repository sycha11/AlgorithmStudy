import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		int cnt = 0;
		for(int i=0; i<n; i++) {
			String s = br.readLine();
			boolean flag = false;
			int[] alphaCount = new int[26];
			
			int a = s.charAt(0) - 97;
			alphaCount[a] += 1;		
			a:for(int j=1; j<s.length(); j++) {
				int alpha = s.charAt(j) - 97;
				if(alphaCount[alpha] == 0) { // 방문한적 없으면 추가
					alphaCount[alpha]++;
				} else {
					if(alpha == (s.charAt(j-1) - 97)) { // 방문했지만 전에 알파벳과 같다면
						alphaCount[alpha]++; // 방문 추가
					} else { // 방문했지만 연속되는 수가 아니야
						flag = true;
						break a;
					}
				}
			}
			if(!flag) {
				cnt++;
			}
		}
		System.out.println(cnt);
//		System.out.println('a' - 97);
	}

}