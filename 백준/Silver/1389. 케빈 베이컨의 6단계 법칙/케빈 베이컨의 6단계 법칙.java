import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static int n,m;
	static ArrayList<Integer>[] list;
	static boolean[] visited;
	static int[] check;
	static Queue<int[]> q;
	
	public static void main(String[] args) throws IOException{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		list = new ArrayList[n+1];
		visited = new boolean[n+1];
		check = new int[n+1];
		q = new LinkedList<>();
		
		for(int i=0; i<=n; i++) {
			list[i] = new ArrayList<Integer>();
		}
		
		for(int i=0; i<m; i++) {
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			
			list[s].add(e);
			list[e].add(s); // 무향
		}
		int min = Integer.MAX_VALUE;
		int result = 0;
		for(int i=1; i<=n; i++) {
			int k = bfs(i,0);
			if(min > k) {
				min = k;
				result = i;
			}
			q = new LinkedList<>();
			visited = new boolean[n+1];
		}
		
		System.out.println(result);
	}
	
	private static int bfs(int x, int cnt) {
		q.add(new int[] {x,0});
		visited[x] = true;
		while(!q.isEmpty()) {
			int[] now = q.poll();
			int nx = now[0];
			int depth = now[1];
			
			cnt += depth;
			for(int i=0; i<list[nx].size(); i++) {
				int idx = list[nx].get(i);
				if(!visited[idx]) { //  방문안한 노드면
					visited[idx] = true;
					q.add(new int[] {list[nx].get(i), depth+1});
				}
			}
		}
		
		return cnt;
	}
	
}