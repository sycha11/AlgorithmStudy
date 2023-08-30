import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static long[] fac;
	static int R,N;
	static long ans;
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int TC = Integer.parseInt(st.nextToken());
		
		for (int i = 0; i < TC; i++) {
			st = new StringTokenizer(br.readLine());
			R = Integer.parseInt(st.nextToken());
			N = Integer.parseInt(st.nextToken());
			ans = 1;
			for (int i1 = 0; i1 < R; i1++) {
				ans = ans*(N-i1)/(i1+1);
			}
			System.out.println(ans);
		}
		
		
	}
}