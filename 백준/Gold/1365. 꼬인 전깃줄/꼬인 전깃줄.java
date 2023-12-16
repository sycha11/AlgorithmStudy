import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int[] lis;
	
	public static void main(String[] args) throws IOException{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		
		StringTokenizer st;
		
		int[] arr = new int[n];
				
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		int len = 0;
		int idx = 0;
		lis = new int[n];
		
		for(int i=0; i<n; i++) {
			// 이번 숫자 > 수열의 마지막으로 저장된 숫자
			if(arr[i] > lis[len]) {
				len += 1;
				lis[len] = arr[i];  
			} else {
				idx = binarySearch(0, len, arr[i]);
				lis[idx] = arr[i];
			}
		}
		System.out.println(n-len);
	}
	
	static int binarySearch(int left, int right, int find) {
		int mid = 0;
		
		while(left < right){
			mid = (left + right) / 2;
			if(lis[mid] < find) { // 중간값이 찾는값보다 작다면
				left = mid + 1; // left 변경
			} else {
				right = mid;
			}
		}
		
		return right;
	}

}