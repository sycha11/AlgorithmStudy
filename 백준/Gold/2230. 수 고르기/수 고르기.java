import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		int[] arr = new int[n];
		
		for(int i=0; i<n; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		Arrays.sort(arr);
		
		int left = 0;
		int right = 0;
		int result = Integer.MAX_VALUE;
		
		while(right < n) {
			if(arr[right] - arr[left] < m) {
				right++;
			} else if(arr[right] - arr[left] == m) {
				result = arr[right] - arr[left];
				break;
			} else if(arr[right] - arr[left] > m) {
				result = Math.min(arr[right] - arr[left], result);
				left++;
			}
		}
		System.out.println(result);
		
	}

}