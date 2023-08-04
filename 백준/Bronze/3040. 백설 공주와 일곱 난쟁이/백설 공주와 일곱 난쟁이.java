import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int[] arr;
	static boolean[] visited;
	static boolean flag;
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		arr = new int[9];
		visited = new boolean[9];
		flag = false;
		
		for(int i=0; i<9; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		
		hap(0,0);
	}
	
	private static void hap(int cnt, int sum) {
		if(flag) return;
		if(cnt == 7) {
			if(sum == 100) {
				flag = true;
				for(int i=0; i<9; i++) {
					if(visited[i]) {
						System.out.println(arr[i]);
					}
				}
			}
			return;
		}
		
		for(int i=0; i<9; i++) {
			if(visited[i]) continue;
			visited[i] = true;
			hap(cnt+1, sum + arr[i]);
			visited[i] = false;
		}
	}

}