import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {

	static int R,C;
	static char[][] map;
	static int[] row; // 방문행 저장
	static int[] dx = {-1, 0, 1}; // 우상 우 우하
	static int[] dy = {1, 1, 1};
	static boolean[][] visited;
	static int cnt;
	static boolean flag;
	public static void main(String[] args) throws IOException{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] s = br.readLine().split(" ");
		R = Integer.parseInt(s[0]);
		C = Integer.parseInt(s[1]);
		
		map = new char[R][C];
		visited = new boolean[R][C];
		row = new int[R];
		cnt = 0;
		flag = false;
		for(int i=0; i<R; i++) {
			String str = br.readLine();
			for(int j=0; j<C; j++) {
				map[i][j] = str.charAt(j);
			}
		}
		
		for(int i=0; i<R; i++) {
			pipe(i,0);
			flag = false;
//			for(int j=0; j<R; j++) {
//				for(int k=0; k<C; k++) {
//					System.out.print(visited[j][k] + " ");
//				}
//				System.out.println();
//			}
//			System.out.println();
		}
		System.out.println(cnt);
	}
	
	private static void pipe(int x, int y) {
		if(flag) return;
		for(int i=0; i<3; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			
			if(nx<0 || ny<0 || nx>=R || ny>=C) {
				continue;
			}
			if(map[nx][ny] == 'x') continue;
			if(visited[nx][ny]) continue;
			if(flag) return;
			
			visited[nx][ny] = true;
			if(ny == C-1) {
				cnt++;
				flag = true;
				return;
			}
			pipe(nx, ny);
		}
	}


}