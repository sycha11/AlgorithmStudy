

import java.util.Scanner;

public class Main {

	static int[] dp;
	static int cnt;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		
		int arr[] = new int[n];
		dp = new int[4];
		for(int i=0; i<n; i++) {
			int k = sc.nextInt();
			int a = recur(k);
			System.out.println(a);
	
		}
	}
	
	static int recur(int k) {
		if(k == 1) {
			return 1;
		} else if(k == 2) {
			return 2;
		} else if(k == 3) {
			return 4;
		} else if(k <= 0) {
			return 0;
		} else {
			return recur(k-3) + recur(k-2) + recur(k-1);
		}
	}

}
