
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int M = sc.nextInt();
		
		int[] arr = new int[N];
		
		for(int i=0; i<N; i++) {
			arr[i] = sc.nextInt();
		}
		int sum = 0;
		int count = 0;
		for(int i=0; i<N; i++) {
			for(int j=i; j<N; j++) {
				sum += arr[j];
				if(sum > M) {
					break;
				}else if(sum == M) {
					count++;
					break;
				} 
			}
			sum = 0;
		}
		System.out.println(count);
		
	}

}
