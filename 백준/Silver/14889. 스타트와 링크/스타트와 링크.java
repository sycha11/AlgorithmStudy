import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	static int n;
	static int[][] map;
//	static int[] arr;
	static boolean[] visited;
	static int min;
	
	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		map = new int[n][n];
//		arr = new int[n];
		visited = new boolean[n+1];
		
		min = Integer.MAX_VALUE;
		StringTokenizer st;
		for(int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<n; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		recu(0,0);
		System.out.println(min);
	}

	private static void recu(int start, int depth) {
		if(depth == n/2) {
//			System.out.println(Arrays.toString(arr));
			diff();
			return;
		}
		for(int i=start; i<n; i++) {
			if(visited[i]) continue;
			visited[i] = true;
//			arr[depth] = i+1;
			recu(i+1, depth+1);
			visited[i] = false;
		}
	}
	
	private static void diff() {
		int left = 0;
		int right = 0;
		for(int i=0; i<n; i++) {
			for(int j=i+1; j<n; j++) {
				if(visited[i]) {
					if(visited[j]) {
						left += map[i][j];
						left += map[j][i];
					}
				} else if(!visited[i]){
					if(!visited[j]) {
						right += map[i][j];
						right += map[j][i];
					}
				}
			}
		}
		
		int sum = Math.abs(left- right);
		min = Math.min(min, sum);
	}
}