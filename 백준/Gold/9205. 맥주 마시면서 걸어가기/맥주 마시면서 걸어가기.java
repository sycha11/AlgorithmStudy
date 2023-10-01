import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static int n;
	static int[][] cu;
	static boolean[] visited;
	static String ans;
	
	public static void main(String[] args) throws IOException{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		for(int tc=1; tc<=T; tc++) {
			
			n = Integer.parseInt(br.readLine());
			StringTokenizer st = new StringTokenizer(br.readLine());
			// 집 좌표
			int hx = Integer.parseInt(st.nextToken());
			int hy = Integer.parseInt(st.nextToken());
			
			cu = new int[n+1][2];
			visited = new boolean[n+1];
			ans = "sad";
			for(int i=0; i<n; i++) {
				st = new StringTokenizer(br.readLine());
				cu[i][0] = Integer.parseInt(st.nextToken());
				cu[i][1] = Integer.parseInt(st.nextToken());
			}
			
			st = new StringTokenizer(br.readLine());
			int fx = Integer.parseInt(st.nextToken());
			int fy = Integer.parseInt(st.nextToken());
			
			cu[n][0] = fx;
			cu[n][1] = fy;
			
			bfs(hx, hy, fx, fy);
			System.out.println(ans);
//			System.out.println(Manhattan(1000,1000, 2000, 1001));
		}
	}

	static void bfs(int hx, int hy, int fx, int fy) {
		Queue<int[]> q = new LinkedList<>();
		q.add(new int[] {hx,hy});
		
		while(!q.isEmpty()) {
			int[] now = q.poll();
			int nx = now[0];
			int ny = now[1];
//			System.out.println(nx + " " + ny);
			if(nx == fx && ny == fy) {
				ans ="happy";
//				System.out.println("도착!");
				return;
			}
			
			for(int i=0; i<=n; i++) {
				if(visited[i] == false) {
					if(Manhattan(nx,ny,cu[i][0], cu[i][1]) <= 1000) {
						visited[i] = true;
						q.add(new int[] {cu[i][0], cu[i][1]});
					}
				}
			}
			
		}
		
	}
	
//	static double dis(int a, int b, int c, int d) {
//		return Math.sqrt(Math.pow((a-c),2) + Math.pow((b-d), 2));
//	}
	
	// 맨해튼 거리
    public static int Manhattan(int a, int b, int c, int d) {
        return Math.abs(a - c) + Math.abs(b - d);
    }
	
}