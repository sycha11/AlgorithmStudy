
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static int R,C,T;
	static int[][] map;
	static int[] dx = {-1,1,0,0}; // 상하좌우
	static int[] dy = {0,0,-1,1};
	
	public static void main(String[] args) throws IOException{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		T = Integer.parseInt(st.nextToken());
		map = new int[R][C];
		
		for(int i=0; i<R; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<C; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		for(int i=0; i<T; i++) {
			recu();
			gonggi();
		}
//		printMap();
		int sum = 0;
		for(int i=0; i<R; i++) {
			for(int j=0; j<C; j++) {
				if(map[i][j] != -1) {
					sum += map[i][j];
				}
			}
		}
		System.out.println(sum);
	}

	static void gonggi() {
		ArrayList<int[]> list = new ArrayList<>();
		for(int i=0; i<R; i++) {
			for(int j=0; j<C; j++) {
				if(map[i][j] == -1) {
					list.add(new int[] {i,j});
				}
			}
		}
		int tx = list.get(0)[0];
		int ty = list.get(0)[1];
		int bx = list.get(1)[0];
		int by = list.get(1)[1];
		
		// 위로
		for(int i=tx-1; i>0; i--) {
			map[i][0] = map[i-1][0];
		}
		// 오른쪽으로
		for(int j=0; j<C-1; j++) { 
			map[0][j] = map[0][j+1];
		}
		// 아래로
		for(int i=0; i<tx; i++) {
			map[i][C-1] = map[i+1][C-1];
		}
		// 왼쪽으로
		for(int j=C-1; j>1; j--) {
			map[tx][j] = map[tx][j-1];
		}
		map[tx][1] = 0;
		
		// 아래 공기청정기
		//위쪽
		for(int i=bx+1; i<R-1; i++) {
			map[i][0] = map[i+1][0];
		}
		// 왼쪽
        for (int i=0; i<C-1; i++) 
            map[R-1][i] = map[R-1][i+1]; 
        // 아래
        for(int i=R-1; i>bx; i--) {
        	map[i][C-1] = map[i-1][C-1];
        }
		// 오른쪽
		for(int j=C-1; j>1; j--) {
			map[bx][j] = map[bx][j-1];
		}
		map[bx][1] = 0;
		
		
	}
	
	static void recu() {
		Queue<int[]> q = new LinkedList<>();
		
		for(int i=0; i<R; i++) {
			for(int j=0; j<C; j++) {
				if(map[i][j] != 0 && map[i][j] != -1) {
					q.add(new int[] {i,j,map[i][j]});
				}
			}
		}
		
		while(!q.isEmpty()) {
			int[] now = q.poll();
			int nx = now[0];
			int ny = now[1];
			int data = now[2];
			
			for(int i=0; i<4; i++) {
				int nextX = nx + dx[i];
				int nextY = ny + dy[i];
				if(nextX < 0 || nextY < 0 || nextX >=R || nextY >= C) {
					continue;
				}
				if(map[nextX][nextY] == -1) {
					continue;
				}
				map[nextX][nextY] += data/5;
				map[nx][ny] = map[nx][ny] - (data/5);
			}
		}
	}
	
	static void printMap() {
		for(int i=0; i<R; i++) {
			for(int j=0; j<C; j++) {
				System.out.print(map[i][j] + " ");
			}
			System.out.println();
		}
	}
	
}
