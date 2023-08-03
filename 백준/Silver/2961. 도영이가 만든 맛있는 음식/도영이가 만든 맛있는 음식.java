import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int n;
	static int[][] arr;
	static boolean[] isSelected;
	static int min;
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		
		arr = new int[n][2];
		isSelected = new boolean[n];
		min = Integer.MAX_VALUE;
		
		for(int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());

			arr[i][0] = s;
			arr[i][1] = b;
		}
//		System.out.println(n);
//		for(int i=0; i<n; i++) {
//			System.out.print(arr[i][0] + " ");
//		}
		gen(0);
		System.out.println(min);
	}
	
	private static void gen(int cnt) {
		if(cnt == n) {
			int minS = 1;
			int minB = 0;
			int count = n;
			for(int i=0; i<n; i++) {
				if(!isSelected[i]) {
					count--;
				}
			}
			if(count == 0) return;
			for(int i=0; i<n; i++) {
				if(isSelected[i]) {
					minS *= arr[i][0];
					minB += arr[i][1];
//					System.out.print(i + " ");
				}
			}
//			System.out.println();
			min = Math.min(min, Math.abs(minS - minB));
//			System.out.println(Math.abs(minS - minB));
			return;
		}
		
		isSelected[cnt] = true;
		gen(cnt+1);
		isSelected[cnt] = false;
		gen(cnt+1);
	}

}