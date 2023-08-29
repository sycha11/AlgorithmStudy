import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		
		int[][] map = new int[N][N];
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		int[] flag = new int[N];
		for(int i=N/2; i<N; i++) {
			flag[i] = 1;
		}
		
		int res = Integer.MAX_VALUE;
		
		do {
			int sum1 = 0;
			int sum2 = 0;
			
			for(int i=0; i<N; i++) {
				for(int j=0; j<N; j++) {
					if(i==j) continue;
					if(flag[i] == 1 && flag[j] == 1) {
						sum1 += map[i][j];
					}
					if(flag[i] == 0 && flag[j] == 0) {
						sum2 += map[i][j];
					}
				}
			}
			res = Math.min(res, Math.abs(sum1-sum2));
			
		}while(np(flag));
		sb.append(res);
		System.out.println(sb);
	}
	
	private static boolean np(int[] p) {
		
		int N = p.length;
		int i = N-1;
		while(i>0 && p[i-1] >= p[i]) --i;
		
		if(i==0) return false; // 맨앞이 젤 큼
		
		int j = N-1;
		while(p[i-1] >= p[j]) --j;
		
		swap(p, i-1, j);
		
		int k = N-1;
		while(i<k) {
			swap(p, i++, k--); //오름차순으로 정렬
		}
		
		return true;
	}
	
	private static void swap(int[] arr, int a, int b) {
		int tmp = arr[a];
		arr[a] = arr[b];
		arr[b] = tmp;
	}

}