import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {

	static int n,m;
	static ArrayList<Integer>[] list;
	static boolean[] visited;
	static int answer;
	
	public static void main(String[] args) throws IOException{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		list = new ArrayList[n];
		visited = new boolean[n];
		
		for(int i=0; i<n; i++) {
			list[i] = new ArrayList<Integer>();
		}
		for(int i=0; i<m; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			list[a].add(b);
			list[b].add(a);		
		}
		answer = 0;
		for(int i=0; i<n; i++) {
			dfs(i,1);
			if(answer ==1) {
				break;
			}
		}
		System.out.println(answer);
	}
	
	private static void dfs(int x, int cnt) {
		if(cnt == 5) {
			answer = 1;
			return;
		}
		visited[x] = true;
		for(int i=0; i<list[x].size(); i++) {
			int idx = list[x].get(i);
			if(!visited[idx]) {
				dfs(idx, cnt+1);
			}
		}
		visited[x] = false;
	}
	
}