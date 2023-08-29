import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		
		int[] dp = new int[n+1];
		
		dp[1] = 0;
		for(int i=2; i<=n; i++) {
			dp[i] = dp[i-1] + 1; // 1로 빼는 경우
			
			if(i%3 == 0) { // 3으로 나누어지는 경우
				dp[i] = Math.min(dp[i/3]+1, dp[i]);
			}
			if(i%2 == 0) { // 2로 나누어지는 경우
				dp[i] = Math.min(dp[i/2]+1, dp[i]);
			}
			
		}
		System.out.println(dp[n]);
		
		
	}

	
}