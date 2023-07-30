
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		
		for(int i=0; i<N; i++) {
			
			for(int j=1; j<N-i; j++) {
				System.out.print(" ");
			}
			
			for(int j=N-i; j<=N+i; j++) {
				System.out.print("*");
			}
			System.out.println();
		}
		for(int i=2; i<=N; i++) {
			for(int j=1; j<i; j++) {
				System.out.print(" ");
			}
			
			for(int j=i; j<=(N*2)-i; j++) {
				System.out.print("*");
			}
			
			System.out.println();
		}
		
		
	}

}
