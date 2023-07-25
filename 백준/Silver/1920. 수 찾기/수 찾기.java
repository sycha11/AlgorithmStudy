
import java.util.*;

public class Main {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int[] arr = new int[N];
		
		for(int i=0; i<N; i++) {
			arr[i] = sc.nextInt();
		}
		Arrays.sort(arr);
		int M = sc.nextInt();
		int[] answer = new int[M];
		
		for(int i=0; i<M; i++) {
			int find = sc.nextInt();
			
			int start = 0;
			int end = arr.length - 1;
			while(start <= end) {
				
				int mid = (start+end)/2;
				
				if(arr[mid] > find) {
					end = mid - 1;
				} else if(arr[mid] < find) {
					start = mid + 1;
				} else {
					answer[i] = 1;
					break;
				}
				
			}
		}
		
		for(int i=0; i<answer.length; i++) {
			System.out.println(answer[i]);
		}
	}

}
