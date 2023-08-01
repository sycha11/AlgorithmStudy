import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {

	public static void main(String[] args) throws Exception{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		
		int T = Integer.parseInt(br.readLine());
		for(int tc=1; tc<=T; tc++) {
			int N = Integer.parseInt(br.readLine());
			int[][] map = new int[N][N];
			int[][] bot = new int[(N/2)][N];
			int sum = 0;
			
			for(int i=0; i<N; i++) {
				String str = br.readLine();
				for(int j=0; j<N; j++) {
					map[i][j] = str.charAt(j) - '0';
				}
			}
			//위에
			for(int i=0; i<N/2; i++) {
				for(int j=(N/2)-i; j<=(N/2)+i; j++) {
					sum += map[i][j];
				}
			}
			//가운데
			for(int i=0; i<N; i++) {
				sum += map[N/2][i];
			}
			int m = 2;
			
			for(int i=(N/2)+1; i<N; i++) {
				for(int j=0; j<N; j++) {
					bot[i-m][j] = map[i][j];
				}
				m += 2;
			}
			
			// 아래
			for(int i=0; i<N/2; i++) {
				for(int j=(N/2)-i; j<=(N/2)+i; j++) {
					sum += bot[i][j];
				}
			}


			System.out.println("#" + tc + " " + sum);
		}
		
	}

}
