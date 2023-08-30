import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int n;
	static int[][] map;
	static boolean[] visited;
	static int ans = Integer.MAX_VALUE;
	
	public static void main(String[] args) throws IOException{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		map = new int[n+1][n+1];
		visited = new boolean[n+1];
		
		for(int i=1; i<=n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j=1; j<=n; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		for(int i=1; i<=n; i++) {
			visited[i] = true;
			dfs(i,i,0,0);
			visited[i] = false;
		}
		System.out.println(ans);
		
	}

	// 시작점, 탐색정점, 합, 깊이
	private static void dfs(int start, int now, int sum, int depth) {
		if(depth == n-1) { // 탐색완료
			if(map[now][start] != 0) {
				sum += map[now][start];
				ans = Math.min(ans, sum);
			}
			return;
		}
		for(int i=1; i<=n; i++) {
			if(!visited[i]) { // 방문안했거나
				if(map[now][i] != 0) { // 갈 수 있다면
					visited[i] = true;
					dfs(start, i, sum+map[now][i], depth+1);
					visited[i] = false;
				}
			}
		}
	}
}