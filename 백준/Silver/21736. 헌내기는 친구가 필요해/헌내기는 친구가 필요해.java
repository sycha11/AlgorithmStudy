import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static int n,m;
	static char[][] map;
	static int[] dx = {-1,1,0,0}; // 상하좌우
	static int[] dy = {0,0,-1,1};
	static boolean[][] visited;
	static int cnt;
	
	public static void main(String[] args) throws IOException{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		cnt = 0;
		map = new char[n][m];
		visited = new boolean[n][m];
		int x = 0;
		int y = 0;
		for(int i=0; i<n; i++) {
			String str = br.readLine();
			for(int j=0; j<m; j++){
				map[i][j] = str.charAt(j);
				if(map[i][j] == 'I') {
					x = i;
					y = j;
				}
			}
		}
		bfs(x,y);
		if(cnt == 0) {
			System.out.println("TT");
		} else {
			System.out.println(cnt);
		}
	}
	
	private static void bfs(int x, int y) {
		Queue<int[]> q = new LinkedList<>();
		q.add(new int[] {x,y});
		visited[x][y] = true;
		
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
				if(map[nextX][nextY] == 'X') continue;
				if(visited[nextX][nextY]) continue;
				if(map[nextX][nextY] == 'P') {
					cnt++;
				}
				visited[nextX][nextY] = true;
				q.add(new int[] {nextX, nextY});
				
			}
		}
	}
	
}