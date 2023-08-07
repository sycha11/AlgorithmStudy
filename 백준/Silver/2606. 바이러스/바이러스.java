

import java.util.Scanner;

public class Main {

	static int com, m;
	static int[][] arr;
	static boolean visit[];
	static int cnt = 0;
	static int max = 0;
	
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		
		com = sc.nextInt();
		m = sc.nextInt();
		arr = new int[com+1][com+1];
		visit = new boolean[com+1];
		for(int i=0; i<m; i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			
			arr[a][b] = 1;
			arr[b][a] = 1;
		}
		bfs(1);
		
		
		System.out.println(cnt-1);
	}
	static void bfs(int index) {
		if(visit[index] == true) {
			max = Math.max(cnt, max);
//			System.out.println(max);
			return;
		}
		if(visit[index] == false) {
			cnt++;
			visit[index] = true;
			for(int j=1; j<=com; j++) {
				if(arr[index][j] == 1) {
//					System.out.println(index +" "+ j + " " + cnt);
					bfs(j);
					
				}
			}
		}
	}

}
