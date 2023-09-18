import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		int m = Integer.parseInt(br.readLine());
		
		String str = br.readLine();
//		char[] p = new char[(2*n) + 1];
		
		StringBuilder sb = new StringBuilder();
		for(int i=1; i<=(2*n)+1; i++) {
			if(i%2 == 0) { // 짝수
				sb.append("O");
			} else {
				sb.append("I");
			}
		}
//		System.out.println(p);
		
		int l = 0;
		int r = 2*n + 1;
		int cnt = 0;
		String string = sb.toString();
		
		while(r <= m) {
			String s = str.substring(l, r);
			if(string.equals(s)) {
				cnt++;
			}
			l++;
			r++;
		}
		System.out.println(cnt);
		
	}

}