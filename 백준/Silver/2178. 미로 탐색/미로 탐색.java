import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	
	static int N,M;
	static boolean[][] visit;
	static int[][] map;
	static int[] dx = {-1, 1, 0, 0}; // x 상하
	static int[] dy = {0, 0, -1, 1}; // y 좌우
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		M = sc.nextInt();
		
		map = new int[N][M];
		
		for(int i=0; i<N; i++) {
			String str = sc.next();
			for(int j=0; j<M; j++) {
				map[i][j] = str.charAt(j) - '0';
			}
		}
		
		visit = new boolean[N][M];
		visit[0][0] = true;
		bfs(0,0);
		System.out.println(map[N-1][M-1]);
		
	}

	public static void bfs(int a, int b) {
		Queue<int[]> queue = new LinkedList<>();
		// 큐에 a,b 저장
		queue.add(new int[] {a,b});
		
		while(!queue.isEmpty()) {
			int[] now = queue.poll();
			int nowX = now[0];
			int nowY = now[1];
			
			for(int i=0; i<4; i++) {
				int nextX = nowX + dx[i];
				int nextY = nowY + dy[i];
				
				if(nextX < 0 || nextY < 0 || nextX >= N || nextY >=M) {
					continue;
				}
				if(visit[nextX][nextY] || map[nextX][nextY] == 0) {
					continue;
				}
				// map이 1이거나 visit이 false라면 큐에 추가
				queue.add(new int[] {nextX, nextY});
				// 방문 카운트
				map[nextX][nextY] = map[nowX][nowY] + 1;
				visit[nextX][nextY] = true;
			}
		}
	}
	
}
