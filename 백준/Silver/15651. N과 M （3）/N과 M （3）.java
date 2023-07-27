
import java.util.*;

public class Main {

	static int[] arr;
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int M = sc.nextInt();
		
		arr = new int[M];
		
		recu(N, M, 0);
		System.out.println(sb);
	}

	static void recu(int n, int m, int depth) {
		// 깊이에 도달하면 배열 출력
		if(depth == m) {
			for(int i=0; i<m; i++) {
				sb.append(arr[i] + " ");
//				System.out.print(arr[i] + " ");
			}
			sb.append("\n");
//			System.out.println();
			return;
		}
		
		for(int i=0; i<n; i++) {
			arr[depth] = i+1;
			recu(n, m, depth+1);
		}
	}
	
}
