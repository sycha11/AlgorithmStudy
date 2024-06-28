import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		int[][] arr = new int[n+1][m+1];
		
		for(int i=1; i<=n; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=1; j<=m; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		// 입력
		
		int[][] sum = new int[n+1][m+1];

		int max = Integer.MIN_VALUE;
		
		for(int i=1; i<=n; i++) {
			for(int j=1; j<=m; j++) {
				int result = Integer.MIN_VALUE;
				int sum1 = sum[i-1][j] + sum[i][j-1] + arr[i][j] - sum[i-1][j-1];
				int sum2 = 0;
				for(int k=j; k>=0; k--) {
					sum2 += arr[i][k];
				}
				int sum3 = 0;
				for(int k=i; k>=0; k--) {
					sum3 += arr[k][j];
				}
				
				result = Math.max(sum3, Math.max(sum1, sum2));
				sum[i][j] = sum1;
				max = Math.max(max, result);
			}
		}
		
		int result = Integer.MIN_VALUE;
        for(int i=1;i<n+1;i++){
            for(int j=1;j<m+1;j++){
                for(int k=i;k<n+1;k++){
                    for(int l=j;l<m+1;l++){
                        result = Math.max(result, sum[k][l]-sum[i-1][l]-sum[k][j-1] + sum[i-1][j-1]);
                    }
                }
            }
        }

        System.out.println(result);
	}

}