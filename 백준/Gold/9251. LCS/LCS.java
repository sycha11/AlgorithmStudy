import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Main {

	public static void main(String[] args) throws IOException{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String str1 = br.readLine();
		String str2 = br.readLine();
		
		int al = str1.length();
		int bl = str2.length();
		char[] ch1 = new char[al+1];
		char[] ch2 = new char[bl+1];
		
		for(int i=1; i<=al; i++) {
			ch1[i] = str1.charAt(i-1);
		}
		for(int i=1; i<=bl; i++) {
			ch2[i] = str2.charAt(i-1);
		}
		
		int[][] dp = new int[al+1][bl+1];
		
		for(int i=1; i<=al; i++) {
			for(int j=1; j<=bl; j++) {
				if(ch1[i] == ch2[j]) {
					dp[i][j] = dp[i-1][j-1] + 1;
				} else {
					dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
				}
			}
		}
		System.out.println(dp[al][bl]);
	}

}