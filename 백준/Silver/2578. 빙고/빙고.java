import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	
	static int[][] arr;
	static boolean[][] visited;
	
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		arr = new int[6][6];
		
		for(int i=1; i<=5; i++) {
			String[] str = br.readLine().split(" ");
			for(int j=1; j<=5; j++) {
				arr[i][j] = Integer.parseInt(str[j-1]);
			}
		}
		
		visited = new boolean[6][6];
		int cnt = 0;
		out:for(int i=1; i<=5; i++) {
			String[] str = br.readLine().split(" ");
			for(int j=1; j<=5; j++) {
				int answer = Integer.parseInt(str[j-1]);
				cnt++;
				check(answer);
				if(isAnswer()) {
					break out;
				}
			}
		}
		System.out.println(cnt);
	}
	
	static void check(int answer) {
		
		for(int i=1; i<=5; i++) {
			for(int j=1; j<=5; j++) {
				if(arr[i][j] == answer) {
					visited[i][j] = true;
				}
			}
		}
	}
	
	static boolean isAnswer() {
		boolean[] width = new boolean[6];
		boolean[] height = new boolean[6];
		
		int cnt = 0;
		int lrSum = 0;
		int rlSum = 0;
		for(int i=1; i<=5; i++) {
			int wSum = 0;
			int hSum = 0;
			if(visited[i][i]) {
				lrSum += i;
			}
			if(visited[i][6-i]) {
				rlSum += i;
			}
			
			for(int j=1; j<=5; j++) {
				if(visited[i][j]) {
					wSum += j;
				}
				if(visited[j][i]) {
					hSum += j;
				}
			}
			
			if(wSum == 15) {
				cnt++;
			}
			if(hSum == 15) {
				cnt++;
			}
			
		}
		if(lrSum == 15) {
			cnt++;
		}
		if(rlSum == 15) {
			cnt++;
		}
		if(cnt >= 3) {
			return true;
		}
		
		return false;
	}
	

}