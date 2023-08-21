import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {

	static int w,h;
	static int[][] map;
	static int cnt;
	static int[] dx = {-1,1,0,0,-1,-1,1,1};
	static int[] dy = {0,0,-1,1,-1,1,-1,1}; //상하좌우 좌상우상좌하우하
	public static void main(String[] args) throws IOException{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		ArrayList<Integer> list = new ArrayList<>();
		while(true) {
			st = new StringTokenizer(br.readLine());
			w = Integer.parseInt(st.nextToken());
			h = Integer.parseInt(st.nextToken());
			
			if(w == 0 && h == 0) {
				break;
			}
			map = new int[h][w];
			for(int i=0; i<h; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j=0; j<w; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			cnt = 0;
			for(int i=0; i<h; i++) {
				for(int j=0; j<w; j++) {
					if(map[i][j] == 1) {
						map[i][j] = 0;
						dfs(i,j);
						cnt++;
					}
				}
			}
			list.add(cnt);
		}
		for(Integer i : list) {
			System.out.println(i);
		}
	}
	public static void dfs(int a, int b) {
		for(int i=0; i<8; i++) {
			int nextX = a + dx[i];
			int nextY = b + dy[i];
			
			if(nextX < 0 || nextY < 0 || nextX >= h || nextY >= w) { // 범위 나가면 무시
				continue;
			}
			
			if(map[nextX][nextY] == 0) { // 바다면 무시
				continue;
			}
			
			map[nextX][nextY] -= 1;
			dfs(nextX, nextY);
			
		}
	}


}