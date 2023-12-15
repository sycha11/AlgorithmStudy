import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		long[] arr = new long[n];
		
		for(int i=0; i<n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		// 정렬
		Arrays.sort(arr);
		long min = Long.MAX_VALUE;
		long[] answer = new long[3];
		
		for(int i=0; i<n-2; i++) {
			int left = i+1;
			int right = n-1;
			while(left < right) {
				long val = (long) Math.abs(arr[i] + arr[left] + arr[right]);
				if(min > val) {
					min = val;
					answer[0] = arr[i];
					answer[1] = arr[left];
					answer[2] = arr[right];
				}
//				System.out.println(arr[i] +" " + arr[left] + " " + arr[right]);
				if(arr[i] + arr[left] + arr[right] < 0) {
					left++;
				} else {
					right--;
				}
			}
		}
		Arrays.sort(answer);
		
		for(int i=0; i<answer.length; i++) {
			System.out.print(answer[i] + " ");
		}
	}

}