import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;

public class Main {


	
	public static void main(String[] args) throws IOException{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		
		int[] A = new int[n];
		Integer[]B = new Integer[n];
		
		String[] s = br.readLine().split(" ");
		for(int i=0; i<n; i++) {
			A[i] = Integer.parseInt(s[i]);
		}
		String[] st = br.readLine().split(" ");
		for(int i=0; i<n; i++) {
			B[i] = Integer.parseInt(st[i]);
		}
		
		// A 오름차순
		Arrays.sort(A);
		// B 내림차순
		Arrays.sort(B, Comparator.reverseOrder());
		
		int sum = 0;
		
		for(int i=0 ; i<n; i++) {
			sum += A[i]*B[i];
		}
		System.out.println(sum);
		
	}
	
}