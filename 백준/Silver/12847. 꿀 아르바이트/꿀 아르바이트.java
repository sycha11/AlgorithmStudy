
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		long[] arr = new long[n+1];
		long[] sum = new long[n+1];
		long max = 0;
		
		for(int i=1; i<=n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
			sum[i] = sum[i-1] + arr[i];
		}
		
		int idx = 1;
		
		for(int i=m; i<=n; i++) {
			long s = 0;
			s =  sum[i] - sum[i-m];
			if(max < s) {
				max = s;
			}
		}
		System.out.println(max);
	}
	

}
