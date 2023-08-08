import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {

	static int k;
	static int[] arr;
	static boolean[] visited;
	static int[] save;
//	static StringBuilder sb;
	
	public static void main(String[] args) throws IOException {

//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		StringTokenizer st = new StringTokenizer(br.readLine());
		Scanner sc = new Scanner(System.in);
		
		while(true) {
//			st = new StringTokenizer(br.readLine(), " ");
//			k = Integer.parseInt(st.nextToken());
			k = sc.nextInt();
			if(k==0) break;
			
			arr = new int[k];
			visited = new boolean[k];
			save = new int[6];
			StringBuilder sb = new StringBuilder();
			
			for(int i=0; i<k; i++) {
//				arr[i] = Integer.parseInt(st.nextToken());
				arr[i] = sc.nextInt();
			}
			
			
			lotto(0,0);
			System.out.println();
		}
		
	}

	static void lotto(int start, int depth) {
		if(depth == 6) {
			for (int i = 0; i < save.length; i++) {
				System.out.print(save[i] + " ");
			}
			System.out.println();
			return;
		}
		
		for(int i=start; i<k; i++) {
			if(visited[i]) continue;
			visited[i] = true;
			save[depth] = arr[i];
			lotto(i+1, depth+1);
			visited[i] = false;
		}
		
	}
	
}