import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class Main {

	public static void main(String[] args) throws IOException{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		
		int[] arr = new int[n+1];
		int[] sum = new int[n+1];
		int max = -10000001;
		
		st = new StringTokenizer(br.readLine());
		for(int i=1; i<=n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		sum[1] = arr[1];
		for(int i=2; i<=n; i++) {
			sum[i] = sum[i-1] + arr[i]; // 누적
		}
		
		
		
		int idx = 0;
		for(int i=k; i<=n; i++) {
			max = Math.max(max, sum[i] - sum[idx++]);
		}
		
		System.out.println(max);
	}

}