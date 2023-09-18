import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	static int h,w;
	static int[][] map;
	
	public static void main(String[] args) throws IOException{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		h = Integer.parseInt(st.nextToken());
		w = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		int[] block = new int[w];
		map = new int[h][w];
		for(int i=0; i<w; i++) {
			block[i] = Integer.parseInt(st.nextToken());
		}
		
		for(int i=0; i<w; i++) {
			int n = block[i];
			for(int j=h-1; j>=h-n; j--) {
				map[j][i] = 1; // 벽
			}
		}
		
		// 아래에서 부터 열 탐색
		int sum = 0;
		for(int i=0; i<h; i++) {
			int cntBlock = 0;
			int cntWater = 0;
			int sumCol = 0;
			boolean first = false; // 첫번째 벽 처리
			
			for(int j=0; j<w; j++) {
				if(map[i][j] == 1) { // 벽이면
					first = true;
					if(cntWater != 0) {
						sumCol += cntWater;
					}
					cntBlock = 1;
					cntWater = 0;
				} else if(map[i][j] == 0 && first == true) { // 벽이 아니거나 벽이 하나 있었어야 함
					cntBlock = 0;
					cntWater += 1;
				}
			}

			sum += sumCol;
		}
		System.out.println(sum);
		
	}

}