
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String s = br.readLine();
		
		int[] arr = new int[s.length()];
		int cnt0 = 0;
		int cnt1 = 0;
		
		for(int i=0; i<s.length(); i++) {
			arr[i] = s.charAt(i) - '0';
		}
		if(arr[0] == 1) cnt1++;
		if(arr[0] == 0) cnt0++;
		for(int i=1; i<s.length(); i++) {
			if(arr[i] == arr[i-1]) continue;
			if(arr[i] == 1) cnt1++;
			if(arr[i] == 0) cnt0++;
		}

		int min = Integer.MAX_VALUE;
		min = Math.min(cnt0, cnt1);
		System.out.println(min);
		
	}

}
