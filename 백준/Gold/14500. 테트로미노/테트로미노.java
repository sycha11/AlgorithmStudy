import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int n,m;
	static int[][] map;
	static int[] dx = {0, -1, -1, 0, 1, 1}; // 왼쪽부터
	static int[] dy = {-1, 0, 1, 2, 1, 0};
	
	static int[] dx2 = {-1, 0, 1, 2, 1, 0}; // 위부터
	static int[] dy2 = {0, 1, 1, 0, -1, -1};
	
	static boolean[] visited;
	static int max;
	static int max2;
	
	public static void main(String[] args) throws IOException{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		map = new int[n][m];
		visited = new boolean[7];
		max = 0;
		max2 = 0;
		for(int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<m; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		// --
		for(int i=0; i<n; i++) {
			for(int j=0; j<m-1; j++) {
				dfs(i,j,0,0);
			}
		}
		
		visited = new boolean[7];
		// |
		for(int i=0; i<n-1; i++) {
			for(int j=0; j<m; j++) {
				dfs2(i,j,0,0);
			}
		}

		System.out.println(max);
		
	}
	
	private static void dfs(int x, int y, int start, int depth) {
		if(depth == 2) {
			int sum = 0 ;
			sum += map[x][y] + map[x][y+1];
			out:for(int i=0; i<6; i++) {
				if(visited[i]) {
					int nx = x + dx[i];
					int ny = y + dy[i];
					if(nx < 0 || nx >= n || ny < 0 || ny >= m) {
						break out;
					}
					sum += map[nx][ny];
				}
			}
			max = Math.max(max, sum);
			return;
		}
		
		for(int i=start; i<6; i++) {
			visited[i] = true;
			dfs(x, y, i+1, depth+1);
			visited[i] = false;
		}
	}
	
	private static void dfs2(int x, int y, int start, int depth) {
		if(depth == 2) {
			int sum = 0 ;
			sum += map[x][y] + map[x+1][y];
			out:for(int i=0; i<6; i++) {
				if(visited[i]) {
					int nx = x + dx2[i];
					int ny = y + dy2[i];
					if(nx < 0 || nx >= n || ny < 0 || ny >= m) {
						break out;
					}
					sum += map[nx][ny];
//					System.out.println(x + " " + y + " :  " +nx + " " + ny + " " +map[nx][ny] );
				}
			}

			max = Math.max(max, sum);
			return;
		}
		
		for(int i=start; i<6; i++) {
			visited[i] = true;
			dfs2(x, y, i+1, depth+1);
			visited[i] = false;
		}
	}
	
//	private static void combi(int start, int depth) {
//		if(depth == 2) {
//			for(int i=0; i<6; i++) {
//				if(visited[i]) {
//					System.out.print(i + " ");
//				}
//			}
//			System.out.println();
//			return;
//		}
//		
//		for(int i=start; i<6; i++) {
//			visited[i] = true;
//			combi(i+1, depth+1);
//			visited[i] = false;
//		}
//	}

}