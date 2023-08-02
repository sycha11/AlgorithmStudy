import java.util.Scanner;

public class Main {

	static int N,M;
	static int[] arr;
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		M = sc.nextInt();
		
		arr = new int[M];
		recu(1,0);
	}

	private static void recu(int start, int depth) {
		if(depth == M) {
			for(int i : arr) {
				System.out.print(i + " ");
			}
			System.out.println();
			return;
		}
		for(int i=start; i<=N; i++) {
			arr[depth] = i;
			recu(i+1, depth+1);
		}
		
	}
	
}