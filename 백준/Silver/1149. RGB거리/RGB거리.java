import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		
		StringTokenizer st;
		
		int[][] color = new int[n][3];
		int[][] dp = new int[n+1][3];
		
		for(int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<3; j++) {
				color[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		dp[0][0] = color[0][0];
		dp[0][1] = color[0][1];
		dp[0][2] = color[0][2];
		
		for(int i=1; i<n; i++) {
			dp[i][0] = color[i][0] + Math.min(dp[i-1][1], dp[i-1][2]);
			dp[i][1] = color[i][1] + Math.min(dp[i-1][0], dp[i-1][2]);
			dp[i][2] = color[i][2] + Math.min(dp[i-1][0], dp[i-1][1]);
		}
		
		System.out.println(Math.min(dp[n-1][0], Math.min(dp[n-1][1], dp[n-1][2])));
	}

}