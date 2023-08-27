import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int n,m;
	static int[] parents;

	// 유니온 파인드
	private static void make() {
		parents = new int[n];
		for(int i=0; i<n; i++) {
			parents[i] = i;
		}
	}
	
	private static int find(int a) {
		if(a == parents[a]) return a;
		return parents[a] = find(parents[a]);
	}
	
	private static boolean union(int a, int b) {
		int aRoot = find(a);
		int bRoot = find(b);
		
		if(aRoot == bRoot) return false;
		
		parents[bRoot] = aRoot;
		return true;
	}
	
	public static void main(String[] args) throws IOException{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		n = Integer.parseInt(br.readLine());
		m = Integer.parseInt(br.readLine());
		
		StringTokenizer st;
		
		make();
		for(int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<n; j++) {
				int con = Integer.parseInt(st.nextToken());
				if(con == 1) {
					union(i,j);
				}
			}
		}
		
		st = new StringTokenizer(br.readLine());
		int[] visited = new int[m];
		boolean flag = true;
		
		for(int i=0; i<m; i++) {
			visited[i] = Integer.parseInt(st.nextToken());
		}
		for(int i=0; i<m-1; i++) {
			int idx = visited[i]-1; // 012
			int nidx = visited[i+1] -1;
			if(find(idx) != find(nidx)) {
				flag = false;
			}
		}
		if(flag) {
			System.out.println("YES");
		} else {
			System.out.println("NO");
		}
		
	}

}
