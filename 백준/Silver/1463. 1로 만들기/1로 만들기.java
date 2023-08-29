import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int[] memo;
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		System.out.println(dp(n));
	}
	
	public static long dp(int n) {
		memo = new int[n+1];
		for (int i = 0; i < memo.length; i++) {
			memo[i] = 0;
		}
		
		
		for (int i = 2; i < n+1; i++) {
			memo[i] = memo[i-1] +1;
			if (i%2==0) {
				memo[i] = Math.min(memo[i],memo[i/2]+1);
			}
			if (i%3==0) {
				memo[i] = Math.min(memo[i],memo[i/3]+1);
			}	
		}
		return memo[n];
	}

}