import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

	static int N,S;
	static int[] arr;
	static boolean[] visited;
	static int max;
	static int cnt;
	
	public static void main(String[] args) throws IOException{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] s = br.readLine().split(" ");
		N = Integer.parseInt(s[0]);
		S = Integer.parseInt(s[1]);
		
		arr = new int[N];
		visited = new boolean[N];
		max = 0;
		cnt = 0;
		String[] st = br.readLine().split(" ");
		for(int i=0; i<N; i++) {
			arr[i] = Integer.parseInt(st[i]);
		}
		Arrays.sort(arr);
		
		recu(0);
		if(S == 0) {
			cnt = cnt -1;
		}
		System.out.println(cnt);
	}
	
	private static void recu(int start) {
		if(start == N) {
			int sum = 0;
			for(int i=0; i<N; i++) {
				if(visited[i]) sum += arr[i];
			}
			if(sum == S) {
				cnt++;
			}
			return;
		}
		visited[start] = true;
		recu(start+1);
		visited[start] = false;
		recu(start+1);
		
	}

}