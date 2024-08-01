import java.io.*;
import java.util.*;
class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		ArrayList<Integer> plus = new ArrayList<>();
		ArrayList<Integer> minus = new ArrayList<>();
				
		int result = 0;
		for(int i=0; i<N; i++){
			int a = Integer.parseInt(st.nextToken());
			result += a;
		}
		
	
		System.out.print(result);
	}
}