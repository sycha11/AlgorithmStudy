import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	static int n;
	static long num;
	static int[] prime, odd;
	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		n = Integer.parseInt(br.readLine());
		
		num = (long)Math.pow(10, n-1);
	
		prime = new int[] {2,3,5,7};
		odd = new int[] {1,3,5,7,9};
		for(int i=0; i<4; i++) {
			recu(prime[i], 1);
		}
	}
	
	private static void recu(int num, int depth) {
		if(depth == n) {
			System.out.println(num);
		}
		for(int i=0; i<5; i++) {
			int k = num*10 + odd[i];
				if(func(k)) { // 소수면
				recu(k, depth+1);
			}
		}
		
	}
	
	private static boolean func(long input) { // 소수판별식
		if(input < 2) {
			return false;
		}
		for(int i=2; i*i<=input; i++) {
			if(input % i == 0) return false; // 그전의 값들과 나눴을때 나누어 떨어지면 false
		}
		return true;
	}
}