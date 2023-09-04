import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static ArrayList<Integer>[] list;
	static boolean[] visited;
	
	public static void main(String[] args) throws IOException{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		StringTokenizer st;
		
		visited = new boolean[n+1];
		list = new ArrayList[n+1];
		for(int i=0; i<=n; i++) {
			list[i] = new ArrayList<>();
		}
		
		for(int i=1; i<=n; i++) {
			String str = br.readLine();
			for(int j=1; j<=n; j++) {
				char c = str.charAt(j-1);
				if(c == 'Y') {
					list[i].add(j);
				}
			}
		}
		int max = 0;
		
		for(int i=1; i<=n; i++) {
			int cnt = bfs(i);
			max = Math.max(max, cnt);
			visited = new boolean[n+1];
		}
		System.out.println(max);
		
	}
	
	private static int bfs(int x) {
		Queue<int[]> q = new LinkedList<>();
		q.add(new int[] {x, 0});
		visited[x] = true;
		int cnt = 0;
		
		while(!q.isEmpty()) {
			int[] now = q.poll();
			int nx = now[0];
			int depth = now[1];
			
			if(depth == 1 || depth == 2) {
				cnt++;
			}
			if(depth == 3) {
				break;
			}
			for(int i=0; i<list[nx].size(); i++) {
				int idx = list[nx].get(i);
				if(!visited[idx]) {
					visited[idx] = true;
					q.add(new int[] {idx, depth+1});
				}
			}
		}
		return cnt;
	}

}