
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

	static int N;
	static int[][] map;
	static boolean[][] visited;
	static int[] dx = {-1,1,0,0}; // 상하좌우
	static int[] dy = {0,0,-1,1};
	static int ans;
	
	static class Node implements Comparable<Node>{
		int x,y,num;
		public Node(int x, int y, int num) {
			this.x = x;
			this.y = y;
			this.num = num;
		}
		
		@Override
		public int compareTo(Node o) {
			return this.num - o.num;
		}
	}
	
	public static void main(String[] args) throws IOException{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		String tmp = "";
		int idx = 1;
		
		while(true) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			if(N == 0) {
				break;
			}
			map = new int[N][N];
			visited = new boolean[N][N];
			
			for(int i=0; i<N; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j=0; j<N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			ans = 0;
			bfs(0,0);
			System.out.println("Problem " + idx++ + ": " + ans);
		}
		
	}
		
	static void bfs(int x, int y) {
		PriorityQueue<Node> pq = new PriorityQueue<>();
		pq.add(new Node(x,y,map[0][0]));
		visited[x][y] = true;
		
		while(!pq.isEmpty()) {
			Node node = pq.poll();
			
			if(node.x == N-1 && node.y == N-1) {
				ans = node.num;
				break;
			}
			visited[node.x][node.y] = true;
			for(int i=0; i<4; i++) {
				int nx = node.x + dx[i];
				int ny = node.y + dy[i];
				if(nx < 0 || ny < 0 || nx >= N || ny >= N) {
					continue;
				}
				if(visited[nx][ny]) {
					continue;
				}
				pq.add(new Node(nx,ny,node.num + map[nx][ny]));
			}
			
		}
	}
	
}
