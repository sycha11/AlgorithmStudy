import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static int[][] map;
	
	public static void main(String[] args) throws IOException{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		
		int[][] dprow = new int[n+1][n+1]; // 가로
		int[][] dpcol = new int[n+1][n+1]; // 세로
		int[][] dpcro = new int[n+1][n+1]; // 대각
		
		map = new int[n+1][n+1];
		for(int i=0; i<n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j=0; j<n; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		dprow[0][1] = 1;
		dpcol[0][1] = 0;
		dpcro[0][1] = 0;
		
		for(int i=0; i<n; i++) {
			for(int j=2; j<n; j++) {
				if(map[i][j] == 1) {
					continue;
				}
				// 가로
				if(j-1 >= 0 && map[i][j] == 0) {
					dprow[i][j] = dprow[i][j-1] + dpcro[i][j-1];
				}
				// 세로
				if(i-1 >= 0 && map[i][j] == 0) {
					dpcol[i][j] = dpcol[i-1][j] + dpcro[i-1][j];
				}
				// 대각
				if(i-1 >= 0 && j-1 >=0 && map[i][j] == 0 && map[i-1][j] == 0 && map[i][j-1] == 0) {
					dpcro[i][j] = dprow[i-1][j-1] + dpcol[i-1][j-1] + dpcro[i-1][j-1];
				}
				
			}
		}
//		for(int i=0; i<n; i++) {
//			for(int j=0; j<n; j++) {
//				
//				System.out.print(dprow[i][j] +  dpcol[i][j] + dpcro[i][j] + " ");
//			}
//			System.out.println();
//		}
//		
		
		
		int result = dprow[n-1][n-1] + dpcol[n-1][n-1] + dpcro[n-1][n-1];
		System.out.println(result);
	}
	

}