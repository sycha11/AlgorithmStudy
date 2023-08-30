import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int[][] B = new int[31][31];
	
	public static void main(String[] args) throws IOException{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		
		for(int tc=1; tc<=T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int r = Integer.parseInt(st.nextToken());
			int n = Integer.parseInt(st.nextToken());

			for(int i=0; i<=n; i++) {
				for(int j=0, end=Math.min(i, r); j<=end; j++) {
					if(i==j || j==0) {
						B[i][j] = 1;
					} else {
						B[i][j] = B[i-1][j-1] + B[i-1][j];
					}
				}
			}
			
			System.out.println(B[n][r]);
		}
		
	}
	
}