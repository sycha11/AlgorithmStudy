import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static boolean[] visited;
	static int[][] map;
	static int n, min_val;
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		visited = new boolean[n];
		map = new int[n][n];
		min_val= 1000000000;
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		for (int i = 0; i < n; i++) {
			backtracking(i,0,i,0);
			
		}
		System.out.println(min_val);
	}
	
	public static void backtracking(int m, int cnt, int start, int cost) {
		
		if (cnt == n-1) {
			if (map[m][start] !=0) {
				if (min_val>cost+map[m][start]) {
					min_val = cost+map[m][start];
					return;
				}
			}
			return;
		}
		for (int i = 0; i < n; i++) {
			if ((i!=start)&&(visited[i] == false)&&(map[m][i] != 0)){
				visited[i] = true;
//				System.out.println(m+"에서"+i+"로");
				backtracking(i,cnt+1,start,cost+map[m][i]);
				visited[i] = false;
			}
		}
		
		
		
		
		
		
	}

}