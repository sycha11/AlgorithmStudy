import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {

	static int n,m;
	static int[][] map;
	static boolean[][] visited;
	static int[] dx = {-1, 1, 0, 0};// 상하좌우
	static int[] dy = {0, 0, -1, 1};
	
	public static void main(String[] args) throws IOException{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] s = br.readLine().split(" ");
		
		n = Integer.parseInt(s[0]);
		m = Integer.parseInt(s[1]);
		visited = new boolean[n][m];
		
		map = new int[n][m];
		for(int i=0; i<n; i++) {
			String str = br.readLine();
			for(int j=0; j<m; j++) {
				map[i][j] = str.charAt(j) - '0';
			}
		}
		
		bfs(0,0);

		System.out.println(map[n-1][m-1]);
	}
	private static void bfs(int x, int y) {
		Queue<int[]> q = new LinkedList<>();
		q.add(new int[] {x,y});
		
		while(!q.isEmpty()) {
			int[] now = q.poll();
			int nowX = now[0];
			int nowY = now[1];
			for(int i=0; i<4; i++) {
				int nextX = nowX + dx[i];
				int nextY = nowY + dy[i];
				if(nextX < 0 || nextY < 0 || nextX >= n || nextY >= m) {
					continue;
				}
				if(visited[nextX][nextY] || map[nextX][nextY] ==0) continue;

				// 맵에 누적해줌
				map[nextX][nextY] = map[nowX][nowY] + 1;
				q.add(new int[] {nextX,nextY});
				visited[nextX][nextY] = true;
			}
		}
	}
}