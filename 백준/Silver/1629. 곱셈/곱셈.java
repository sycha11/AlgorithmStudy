
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int A = Integer.parseInt(st.nextToken());
		int B = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());
		
		int res = recu(A,B,C);
		System.out.println(res);
	}

	static int recu(int a, int b, int c) {
		if(b==1) {
			return a%c; 
		}
		long res = recu(a,b/2,c);
		long result = res*res;
		result %= c;
		if(b%2 != 0) { // b가 홀수라면
			result *= a;
			result %= c;
		}
		return (int) result;
	}
	
}
