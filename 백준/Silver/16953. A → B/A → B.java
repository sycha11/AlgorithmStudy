
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int max;
	static int min;
	static boolean[] visited;
	
	public static void main(String[] args) throws IOException{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int A = Integer.parseInt(st.nextToken());
		int B = Integer.parseInt(st.nextToken());
		max = 1000000001;
		min = Integer.MAX_VALUE;
		
		visited = new boolean[max];
		visited[A] = true;
		
		dfs(A,B,1);
		if(min == Integer.MAX_VALUE) {
			System.out.println(-1);
		} else {
			System.out.println(min);
		}
	}

	static void dfs(int A, int B, int cnt) {
		if(A > Integer.MAX_VALUE) {
			return;
		}
		//기저조건
		if(A == B) {
			min = Math.min(min, cnt);
			return;
		}
		// 재귀
		if(A*2 < max) {
			if(visited[A*2] == false) {
				visited[A*2] = true;
				dfs(A*2, B, cnt+1);
			}
		}
		String a = String.valueOf(A) + "1";
		long l = Long.parseLong(a);
		if(l < max) {
			int sa = (int)l;
			if(visited[sa] == false) {
				visited[sa] = true;
				dfs(sa, B, cnt+1);
			}
		}
	}
	
}
