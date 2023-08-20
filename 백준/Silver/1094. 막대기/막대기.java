import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int x = Integer.parseInt(br.readLine());
		int cnt =0;
		while(true) {
			if(x == 1) {
				cnt++;
				break;
			}
			if(x%2 == 0) {
				x = x / 2;
			} else {
				x = x / 2;
				cnt++;
			}
		}
		System.out.println(cnt);
	}

}