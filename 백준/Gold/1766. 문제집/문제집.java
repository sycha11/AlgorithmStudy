import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static int n,m;
	static ArrayList<Integer>[] list;
	static int[] dist;
	static PriorityQueue<Integer> q;
	static StringBuilder sb;
	
	public static void main(String[] args) throws IOException{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		list = new ArrayList[n+1];
		dist = new int[n+1];
		q = new PriorityQueue<>();
		sb = new StringBuilder();
		
		for(int i=1; i<=n; i++) {
			list[i] = new ArrayList<>();
		}
		
		for(int i=0; i<m; i++) {
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			
			list[s].add(e);
			dist[e] += 1;
		}
		
		for(int i=1; i<=n; i++) {
			if(dist[i] == 0) {
				q.add(i);
			}
		}
		bfs();
		System.out.println(sb);
	}

	static void bfs() {
		while(!q.isEmpty()) {
			int idx = q.poll();
			sb.append(idx + " ");
			for(int i=0; i<list[idx].size(); i++) {
				int x = list[idx].get(i);
				dist[x] -= 1;
				if(dist[x] == 0) {
					q.add(x);
				}
			}
		}
	}
	
}