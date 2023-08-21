
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static int n,m;
	static List<Integer>[] list;
	static Queue<Integer> q;
	static boolean[] visited;
	static int[] check;
	static StringBuilder sb;
	
	public static void main(String[] args) throws IOException{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		list = new ArrayList[n+1];
		q = new LinkedList<>();
		visited = new boolean[n+1];
		check = new int[n+1];
		sb = new StringBuilder();
		
		for(int i=1; i<=n; i++) {
			list[i] = new ArrayList<>();
		}
		
		for(int i=0; i<m; i++) {
			st = new StringTokenizer(br.readLine());
			int v = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			list[v].add(e); // 유향
			check[e] +=1;
		}
		
		for(int i=1; i<=n; i++) {
			if(check[i] == 0) {
				q.add(i);
			}
		}
//		System.out.println(q.toString());
		bfs();
		System.out.println(sb);
	}

	private static void bfs() {
		while(!q.isEmpty()) {
			int x = q.poll();
			sb.append(x).append(" ");
			for(int i=0; i<list[x].size(); i++) {
				if(check[list[x].get(i)] != 0) {
					check[list[x].get(i)] -= 1;
					if(check[list[x].get(i)] == 0) {
						q.add(list[x].get(i));
					}
				}
			}
		}
	}
}
