import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		int[][] map = new int[N+1][N+1];
		int[][] sum = new int[N+1][N+1];
		for(int i=1; i<=N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for(int j=1; j<=N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(i == 1) {
					sum[i][j] = sum[i][j-1] + map[i][j];
				} else if(j == 1) {
					sum[i][j] = sum[i-1][j] + map[i][j];
				}
			}
			
			
		}

		for(int i=1; i<=N; i++) {
			for(int j=1; j<=N; j++) {
				sum[i][j] = sum[i][j-1] + sum[i-1][j] + map[i][j] - sum[i-1][j-1];
			}
		}
		
		for(int k=0; k<M; k++) {
			st = new StringTokenizer(br.readLine(), " ");
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken());
			
			int ans = sum[c][d] - sum[c][b-1] - sum[a-1][d] + sum[a-1][b-1];
			
			System.out.println(ans);
		}
	}

}