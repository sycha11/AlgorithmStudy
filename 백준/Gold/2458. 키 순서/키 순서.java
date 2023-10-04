
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		int[][] arr = new int[n][n];
		for(int i=0; i<m; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken())-1;
			int b = Integer.parseInt(st.nextToken())-1;
			arr[a][b] = 1;
			arr[b][a] = -1;
		}
		for(int k=0; k<n; k++) {
			for(int i=0; i<n; i++) {
				for(int j=0; j<n; j++) {
					if(arr[i][k] == 1 && arr[k][j] == 1) {
						arr[i][j] = 1;
					} else if(arr[i][k] == -1 && arr[k][j] == -1) {
						arr[i][j] = -1;
					}
				}
			}	
		}
		int ans = 0;
		for(int i=0; i<n; i++) {
			int cnt = 0;
			for(int j=0; j<n; j++) {
				if(arr[i][j] != 0) {
					cnt++;
				}
			}
			if(cnt == n-1) {
				ans++;
			}
		}
		System.out.println(ans);
		
	}

}
