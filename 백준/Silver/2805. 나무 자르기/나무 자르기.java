import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] s = br.readLine().split(" ");
		
		int N = Integer.parseInt(s[0]);
		int M = Integer.parseInt(s[1]);
		
		String[] st = br.readLine().split(" ");
		int[] arr = new int[N];
		int max = 0; // 나무 높이의 최댓값
		int min = 0;
		for(int i=0; i<N; i++) {
			arr[i] = Integer.parseInt(st[i]);
			max = Math.max(max, arr[i]);
		}
		
		while(min < max) {
			int mid = (min+max) /2;
			long sum = 0;
			for(int a : arr) {
				if(a > mid) { // 중간값 보다 나무가 더 길다면
					sum+= (a-mid); // 자르고 추가
				}
			}
			if(sum >= M) {
				min = mid+1;
			} else{
				max = mid;
			} 
			
		}
		System.out.println(min-1);
		
	}
}