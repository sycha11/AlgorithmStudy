import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

	static int n,r;
	static int[] arr;
	static boolean[] visited;
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] s = br.readLine().split(" ");
		n = Integer.parseInt(s[0]);
		r = Integer.parseInt(s[1]);
		
		arr = new int[r+1];
		visited = new boolean[n];
		recu(1);
	}
	static void recu(int depth) {
		if(depth == r+1) {
			for(int i=1; i<=r; i++) {
				System.out.print(arr[i] + " ");
			}
			System.out.println();
			return;
		}
		
		for(int i=1; i<=n; i++) {
			arr[depth] = i;
			if(arr[depth-1] > arr[depth]) continue;
			recu(depth+1);
		}
	}

}