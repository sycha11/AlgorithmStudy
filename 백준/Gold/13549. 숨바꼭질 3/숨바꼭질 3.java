import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {

	static int n,k;
	static boolean[] visited;
	static int min = Integer.MAX_VALUE;
	public static void main(String[] args) throws IOException{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] s = br.readLine().split(" ");
		
		n = Integer.parseInt(s[0]);
		k = Integer.parseInt(s[1]);
		
		visited = new boolean[100001];
		recu(n);
		System.out.println(min);
	}

	private static void recu(int x) {
		Queue<int[]> q = new LinkedList<>();
		q.add(new int[] {x,0});
		visited[x] = true;
		while(!q.isEmpty()) {
			int[] p = q.poll();
			int nowX = p[0];
			int cnt = p[1];
			visited[nowX] = true;
			if(nowX == k) {
				min = Math.min(min, cnt);
			}
			int a = nowX - 1;
			int b = nowX + 1;
			int c = nowX * 2;

			if(a >= 0 && !visited[a]) {
				q.add(new int[] {a,cnt+1});
			}
			if(b <=100000 && !visited[b]) {
				q.add(new int[] {b, cnt+1});
			}
			if(c <= 100000 && !visited[c]) {
				q.add(new int[] {c, cnt});
			}
//			System.out.println(nowX+ " " + a + " " + b + " " + c + " " + cnt);
		}
	}

}