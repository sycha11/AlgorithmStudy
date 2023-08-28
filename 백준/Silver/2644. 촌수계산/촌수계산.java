import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {

	static int n,m;
	static int b;
	static ArrayList<Integer>[] list;
	static boolean[] visited;
	static int result;
	
	public static void main(String[] args) throws IOException{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		n = Integer.parseInt(br.readLine());
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int a = Integer.parseInt(st.nextToken());
		b = Integer.parseInt(st.nextToken());
		
		m = Integer.parseInt(br.readLine());
		list = new ArrayList[n+1];
		visited = new boolean[n+1];
		result = -1;
		
		for(int i=0; i<=n; i++) {
			list[i] = new ArrayList<>();
		}
		
		for(int i=0; i<m; i++) {
			st = new StringTokenizer(br.readLine());
			int p = Integer.parseInt(st.nextToken());
			int s = Integer.parseInt(st.nextToken());

			list[p].add(s);
			list[s].add(p);
		}
		
		dfs(a, 0);
		System.out.println(result);
	}
	
	private static void dfs(int x, int depth) {
		if(x == b) {
			result = depth;
			return;
		}
		visited[x] = true;
		for(int i=0; i<list[x].size(); i++) {
			int nx = list[x].get(i);
			if(visited[nx]) continue;
			dfs(nx, depth+1);
		}
	}

}